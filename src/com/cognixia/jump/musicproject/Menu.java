package com.cognixia.jump.musicproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static Connection conn;
	public static int personId;
	public static int albumId;

	public static void setConnection(Connection conn, int id) {

		Menu.conn = conn;
		Menu.personId = id;
		Menu.showMenu();
		

	}

	public static void showMenu() {

		System.out.println("Please choose an option from the menu!!");
		System.out.println("Your options are : 1. Create 2. Read 3. Update 4. Delete");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please choose an option from the menu!!");
			System.out.println("Your options are : 1. Create 2. Read 3. Update 4. Delete");

			String input = sc.nextLine();

			if (input.equals("C")) {
				Menu.addAlbum();
				break;

			} else if (input.equals("R")) {
				Menu.showAlbum();
				break;

			} else if (input.equals("U")) {
				Menu.updateAlbum();
				break;

			} else if (input.equals("D")) {
				Menu.deleteAlbum();
				break;

			}
		}

	}

	public static void addAlbum() {
		
		System.out.println("Hi User");

		
		while(true) {
			System.out.println("PersonId id is " + Menu.personId);
			System.out.println("Please enter an album id : ");
			Scanner sc1 = new Scanner(System.in);
			int album_id = sc1.nextInt();
			sc1.nextLine();

			System.out.println("Please enter the status : ");
			String status = sc1.nextLine();
			
			Playlist pl = new Playlist(Menu.personId, album_id, status);
			
			
			
			PlaylistDaoSql pd = new PlaylistDaoSql();
			
			PlaylistDaoSql.setConnection(conn);
			
			boolean result = pd.addPlaylist(pl);
			
			if(result) {
				System.out.println("You have inserted successfully");
				break;
			}else {
				System.out.println("You can not insert the album");
			}

		}
		
	}

	public static void showAlbum() {
		
		int person_id = Menu.personId;
		
		AlbumDaoSql.setConnection(conn);
		
		AlbumDao albumDao = new AlbumDaoSql();
		
		List<Album> albumList = albumDao.getAllAlbums(person_id);
		
		System.out.println("ALBUMS");
		System.out.println("-----------------");
		
		for(Album al : albumList) {
			System.out.println(al);
		}


	}

	public static void updateAlbum() {
		
		while(true) {
			
			System.out.println("Please enter an album id that you want to update : ");
			Scanner sc2 = new Scanner(System.in);
			albumId = sc2.nextInt();
			sc2.nextLine();
			
			AlbumDaoSql.setConnection(conn);
			
			AlbumDaoSql pd = new AlbumDaoSql();
			
			boolean result = pd.getAlbumById(Menu.personId, albumId);
			
			if(result) {
				System.out.println("You have permission to update the playlist status");
				break;
			}else {
				System.out.println("You do not have permission to update the playlist status");
			}
			
		}
		
		while(true) {
			Scanner sc3 = new Scanner(System.in);
			System.out.println("Please enter the status : ");
			String status = sc3.nextLine();
			
			Playlist pl = new Playlist(Menu.personId, albumId, status);
			
			
			
			PlaylistDaoSql pd = new PlaylistDaoSql();
			
			PlaylistDaoSql.setConnection(conn);
			
			boolean r = pd.updatePlaylist(pl);
			
			if(r) {
				System.out.println("You have updated successfully");
				break;
				
			}else {
				System.out.println("OH, SORRY! You could not update the playlist!");
			}
		}
	}
		


	public static void deleteAlbum() {

	}

}

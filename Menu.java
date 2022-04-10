package com.cognixia.jump.musicproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Menu {

	
	public static Connection conn;
	public static int personId;
    public static char album_name;
    public static char album_genre;
	public static void setConnection(Connection conn, int id ) {
        
		Menu.conn = conn;
		Menu.personId = id;
		Menu.showMenu();
	}	
	public static void showMenu()    {

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
				try {
					Menu.showAlbum();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			sc1.nextInt();

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
	
	public static void showAlbum() throws Exception {	
                String sql = "Select * from music2.album";  //key
            
				Statement st = null;
				st = conn.createStatement();
			    ResultSet rs = st.executeQuery(sql);
				rs.next();
				String name = rs.getString("album_genre"); // key
				System.out.println(name);
				st.close();
	            conn.close();
	}
	
	public static void updateAlbum() {

	}

	public static void deleteAlbum() {

	}

	
	

}
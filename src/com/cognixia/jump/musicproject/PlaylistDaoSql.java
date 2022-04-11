package com.cognixia.jump.musicproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PlaylistDaoSql implements PlaylistDao {
	
	public static Connection conn;
	
	public static void setConnection(Connection conn) {
		
		PlaylistDaoSql.conn = conn;
		
	}
	
	@Override
	public boolean addPlaylist(Playlist pl) {

		try (PreparedStatement pstmt = PlaylistDaoSql.conn
				.prepareStatement("insert into album_person(person_id, album_id, album_person_status) values(?,?,?)")) 
		{

			pstmt.setInt(1, pl.getPerson_id());
			pstmt.setInt(2, pl.getAlbum_id());
			pstmt.setString(3, pl.getAlbum_person_status());

			// if update occurred, count will be 1 or more
			// if update didn't occur, count will be 0
			int count = pstmt.executeUpdate();

			// did update
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("You already inserted the album");
		}

		// no update occurred
		return false;

	}
	
	@Override
	public boolean updatePlaylist(Playlist pl) {

		try (PreparedStatement pstmt = PlaylistDaoSql.conn
				.prepareStatement("update album_person set album_person_status = ? where person_id = ? and album_id = ?")) {
			
			pstmt.setString(1, pl.getAlbum_person_status());
			pstmt.setInt(2, pl.getPerson_id());
			pstmt.setInt(3, pl.getAlbum_id());
			

			// if update occurred, count will be 1 or more
			// if update didn't occur, count will be 0
			int count = pstmt.executeUpdate();

			
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("You could not update the album");
		}

		
		return false;
	}
	
	@Override
	public boolean deleteAlbum(int person_id, int album_id) {

		try (PreparedStatement pstmt = conn
				.prepareStatement("delete from album_person where person_id = ? and album_id = ?")) {

			pstmt.setInt(1, person_id);
			pstmt.setInt(2, album_id);

			// if update occurred, count will be 1 or more
			// if update didn't occur, count will be 0
			int count = pstmt.executeUpdate();

			// did update
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// no update occurred
		return false;

	}

	
	
	
	

}

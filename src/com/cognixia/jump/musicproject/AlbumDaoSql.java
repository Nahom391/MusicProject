package com.cognixia.jump.musicproject;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDaoSql implements AlbumDao {

	public static Connection conn;

	public static void setConnection(Connection conn) {

		PlaylistDaoSql.conn = conn;

	}

	public List<Album> getAllAlbums(int person_id) {

		List<Album> albumList = new ArrayList<Album>();

		String sql = "SELECT album.album_id, album.album_name, album.album_release, album.album_genre FROM person left JOIN album_person ON ? = album_person.person_id left join album on album_person.album_id = album.album_id group by album.album_id";

		try (PreparedStatement pstmt = PlaylistDaoSql.conn.prepareStatement(sql)) {

			pstmt.setInt(1, person_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("album_id");

				String name = rs.getString("album_name");

				String release = rs.getString("album_release");

				String genre = rs.getString("album_genre");

				Album al = new Album(id, name, release, genre);

				albumList.add(al);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return albumList;
	}

	@Override
	public boolean getAlbumById(int person_id, int album_id) {

		try (PreparedStatement pstmt = PlaylistDaoSql.conn.prepareStatement("SELECT album_id FROM album_person where person_id = ? and album_id = ? ")) {

			pstmt.setInt(1, person_id);
			pstmt.setInt(2, album_id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}

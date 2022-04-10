package com.cognixia.jump.musicproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDaoSql implements AlbumDao {

	public static final String SQL_SELECT = "SELECT * FROM album";
	public static Connection conn;
	
	public static void setConnection(Connection conn) {
		
		AlbumDaoSql.conn = conn;
}
	//public Object showAlbum;
	
	public AlbumDaoSql() throws SQLException{

		 PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
		 
		}
	
	@Override
	public boolean showAlbum() {
		// TODO Auto-generated method stub
		return false;
	}




}	
	
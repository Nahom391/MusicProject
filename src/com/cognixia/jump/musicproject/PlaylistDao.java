package com.cognixia.jump.musicproject;

public interface PlaylistDao {
	
	public boolean addPlaylist(Playlist pl);
	
	public boolean updatePlaylist(Playlist pl);
	
	public boolean deleteAlbum(int person_id, int album_id);

}

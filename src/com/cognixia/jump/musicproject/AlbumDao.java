package com.cognixia.jump.musicproject;

import java.util.List;

public interface AlbumDao {
	
	public List<Album> getAllAlbums(int person_id);
	
	public boolean getAlbumById(int person_id, int album_id);
	
//	public boolean addPlaylist(Playlist pl);

	
}

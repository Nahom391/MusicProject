package com.cognixia.jump.musicproject;

public class Album {
	private String album_name;
	private String album_genre;
	
	public String getAlbum_name() {
		return album_name;
	}

	public void  setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_genre() {
		return album_genre;
	}

	public void setAlbum_genre(String album_genre) {
		this.album_genre = album_genre;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
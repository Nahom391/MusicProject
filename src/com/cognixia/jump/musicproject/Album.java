package com.cognixia.jump.musicproject;

public class Album {
	
	private int id;
	private String album_name;
	private String album_release;
	private String album_genre;
	

	public Album(int id, String album_name, String album_release, String album_genre) {
		super();
		this.id = id;
		this.album_name = album_name;
		this.album_release = album_release;
		this.album_genre = album_genre;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAlbum_release() {
		return album_release;
	}



	public void setAlbum_release(String album_release) {
		this.album_release = album_release;
	}

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
		return "Album [id=" + id + ", album_name=" + album_name + ", album_release=" + album_release + ", album_genre="
				+ album_genre + "]";
	}

	
	
}
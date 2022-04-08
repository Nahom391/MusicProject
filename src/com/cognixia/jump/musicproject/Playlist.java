package com.cognixia.jump.musicproject;

public class Playlist {
	
	private int person_id;
	private int album_id;
	private String album_person_status;

	public Playlist(int person_id, int album_id, String album_person_status) {
		super();
		this.person_id = person_id;
		this.album_id = album_id;
		this.album_person_status = album_person_status;
		
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_person_status() {
		return album_person_status;
	}

	public void setAlbum_person_status(String album_person_status) {
		this.album_person_status = album_person_status;
	}

	@Override
	public String toString() {
		return super.toString();
	}


}

package com.company;

public class Album {
    private String name;
    private int artistId;
    private int releaseYear;

    public Album(String name, int artist_id, int release_year) {
        this.name = name;
        this.artistId = artist_id;
        this.releaseYear = release_year;
    }

    public Album() {

    }

    public Album(Album e){
        this.name=e.name;
        this.artistId=e.artistId;
        this.releaseYear=e.releaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}




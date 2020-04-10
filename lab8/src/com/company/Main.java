package com.company;


public class Main {

    public static void main(String args[]) {
        try {
            Database database=Database.getInstance();
            ArtistController artist = new ArtistController((database.getConnection()));
            //artist.create("Costel", "romania");
            //artist.findByName("Paul");
            AlbumController album=new AlbumController((database.getConnection()));
            album.create("fsdgsr",4,1990);
            Album newAlbum=new Album(album.findByArtist(8));
            System.out.println(newAlbum.getName()+" "+newAlbum.getArtistId()+" "+newAlbum.getReleaseYear());
            database.getConnection().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

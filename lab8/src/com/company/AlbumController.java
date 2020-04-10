package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    private Connection con;
    List<Album> albums= new ArrayList<Album>();

    AlbumController(Connection con) {
        this.con = con;
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            Statement stmt = con.createStatement();
            String sql = "insert into albums values (0,'" + name + "','" + artistId + "','" + releaseYear + "');";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Album findByArtist(int artistId) {
        Album temp= new Album();
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from albums where artist_id=" + artistId + ";";
            ResultSet rs = stmt.executeQuery((sql));
            while (rs.next()) {
                temp.setName(rs.getString(2));
                temp.setArtistId(rs.getInt(3));
                temp.setReleaseYear(rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;

    }

}

package com.company;

import java.sql.*;

public class ArtistController {
    Connection con;

    ArtistController(Connection con) {
        this.con = con;
    }

    public void create(String name, String country) {
        try {
            Statement stmt = con.createStatement();
            String sql = "insert into artists values (0,'" + name + "','" + country + "');";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Artist findByName(String name) {
        Artist temp = new Artist();
        try {
            Statement stmt = con.createStatement();
            String sql = "select * from artists where name like '" + name + "';";
            ResultSet rs = stmt.executeQuery((sql));
            while (rs.next()) {
                temp.setName(rs.getString(2));
                temp.setCountry(rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }
}

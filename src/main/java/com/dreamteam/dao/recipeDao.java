package com.dreamteam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dreamteam.model.Recipe;
import com.dreamteam.util.DbUtil;
/**
 * chuj, dupa, kurwa, cipa
 */
public class recipeDao {
    private Connection connection;

    public recipeDao() {
        connection = DbUtil.getConnection();
    }

    public void addRecipe(Recipe przepis) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into przepis (id_przepis,nazwa,opis,ocena, typ, zdjecie) values (?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setLong(1, przepis.getId_przepis());
            preparedStatement.setString(2, przepis.getNazwa());
            preparedStatement.setString(3, przepis.getOpis());
            preparedStatement.setInt(4, przepis.getOcena());
            preparedStatement.setInt(5, przepis.getTyp());
            preparedStatement.setString(6, przepis.getZdjecie());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe(long recipeId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from przepis where przepis_id=?");
            // Parameters start with 1
            preparedStatement.setLong(1, recipeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe przepis) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update przepis set id_przepis=? ,nazwa=? , " +
                    "opis=? ,ocena=? , typ=?, zdjecie=?" + "where userid=?");
            // Parameters start with 1
            preparedStatement.setLong(1, przepis.getId_przepis());
            preparedStatement.setString(2, przepis.getNazwa());
            preparedStatement.setString(3, przepis.getOpis());
            preparedStatement.setInt(4, przepis.getOcena());
            preparedStatement.setInt(5, przepis.getTyp());
            preparedStatement.setString(6, przepis.getZdjecie());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from przepis");
            Recipe przepis = new Recipe();
            while (rs.next()) {
                przepis.setId_przepis(rs.getLong("przepis_id"));
                przepis.setNazwa(rs.getString("nazwa"));
                przepis.setOpis(rs.getString("opis"));
                przepis.setOcena(rs.getInt("ocena"));
                przepis.setTyp(rs.getInt("typ"));
                przepis.setZdjecie(rs.getString("zdjecie"));
                recipes.add(przepis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public Recipe getUserById(int przepisId) {
        Recipe przepis = new Recipe();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, przepisId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                przepis.setId_przepis(rs.getLong("przepis_id"));
                przepis.setNazwa(rs.getString("nazwa"));
                przepis.setOpis(rs.getString("opis"));
                przepis.setOcena(rs.getInt("ocena"));
                przepis.setTyp(rs.getInt("typ"));
                przepis.setZdjecie(rs.getString("zdjecie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return przepis;
    }
}

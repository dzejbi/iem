package com.dreamteam.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dreamteam.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser() {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO uzytkownik (id_uzytkownik, isAdmin, haslo, email) VALUES (NULL, 1, 'haslo', 'email');");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

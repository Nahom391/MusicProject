package com.cognixia.jump.musicproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class LoginPerson {

	public static void loginFunction(Connection conn) throws IOException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please Enter your username:");
			String username = sc.nextLine();

			System.out.println("Please Enter your password:");
			String password = sc.nextLine();

			try (PreparedStatement psmt = conn
					.prepareStatement("select * from person where person_username = ? and person_password = ?")) {
				psmt.setString(1, username);
				psmt.setString(2, password);

				ResultSet rs = psmt.executeQuery();
				int personId;

				if (rs.next()) {
					personId = rs.getInt("person_id");
					System.out.println("Welcome User, your username is : " + rs.getString("person_username"));
					
					System.out.println("PersonId " + personId);
					
					Menu.setConnection(conn, personId);
	
					break;

				}

				rs.close();
			}

			catch (SQLException e) {

				e.printStackTrace();

			}
		}

		sc.close();

	}
}

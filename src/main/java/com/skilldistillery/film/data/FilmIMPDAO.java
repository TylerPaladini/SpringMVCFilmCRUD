package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.filmquery.entities.Actor;

public class FilmIMPDAO implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	private static Connection connect() {
		Connection conn = null;
		try {
			String user = "student";
			String pass = "student";
			conn = DriverManager.getConnection(URL, user, pass);
		} catch (Exception e) {
			System.err.println(e);
		}
		return conn;
	}

	@Override
	public Film filmById(int filmId) {
		Film output = null;
		try {
			Connection conn = connect();
			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				List<Actor> actor = new ArrayList<>();
				cast = getActorsByFilmId(filmId);
				output = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, actor);
			}
			rs.close();
			stmt.close();

			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return output;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film addFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

}

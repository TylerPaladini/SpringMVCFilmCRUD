package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Repository
public class FilmIMPDAO implements FilmDAO {

	private String user = "student";
	private String pass = "student";

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	@Override
	public Film getFilmById(int filmId) throws SQLException {

		Film film = null;
		Actor actor = null;
		String sql = "select film.id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost,"
				+ " rating, special_features from film "
				+ "where film.id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film();
			actor = new Actor();

			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguage_id(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeature(filmResult.getString("special_features"));
          
//            actor.setId( filmResult.getInt( "actor.id" ));
//            actor.setFirstName(filmResult.getString( "actor.first_name" ));
//            actor.setLastName(filmResult.getString( "actor.last_name" ));

			film.setActor(getActorsByFilmId(filmResult.getInt("film.id")));

		}
		filmResult.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actorList = null;
		Actor actor = null;

		String sql = " select actor.first_name, actor.last_name from actor "
				+ " join film_actor on actor.id = film_actor.actor_id " + "  join film on film.id = film_actor.film_id "
				+ " where film.id = ? ";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet actorResult = stmt.executeQuery();
		actorList = new ArrayList<>();
		while (actorResult.next()) {
			actor = new Actor();

			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));

			actorList.add(actor);
		}

		return actorList;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();
		Film film = null;
		Actor actor = null;
		String sql = "select film.id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost,"
				+ " rating, special_features   from film "
				+ "where title like ? or description like ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet filmResult = stmt.executeQuery();
		while (filmResult.next()) {
			film = new Film();

			film.setId(filmResult.getInt("film.id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguage_id(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeature(filmResult.getString("special_features"));
			// actor.setId( filmResult.getInt( "actor.id" ));
			// actor.setFirstName(filmResult.getString( "actor.first_name" ));
			// actor.setLastName(filmResult.getString( "actor.last_name" ));
			film.setActor(getActorsByFilmId(filmResult.getInt("film.id")));
			films.add(film);
			System.out.println(films);
		}
		filmResult.close();
		stmt.close();
		conn.close();
		return films;

	}

	@Override
	public boolean addFilm(Film film) throws SQLException {
		boolean output = false;
		String sql = "INSERT INTO film (title, description, release_year, "
				+ " language_id, length ) VALUES (?, ?, ?, ?, ?)";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, film.getTitle());
		stmt.setString(2, film.getDescription());
		stmt.setInt(3, film.getReleaseYear());
		stmt.setInt(4, film.getLanguage_id());
		
		
		stmt.setInt(5, film.getLength());
		
	
		
		
		int updateCount = stmt.executeUpdate();

		if (updateCount == 1) {
			ResultSet keys = stmt.getGeneratedKeys();
			if (keys.next()) {
				int newFilmId = keys.getInt(1);
				film.setId(newFilmId);
			}


			}
		else {
			film = null;

		}
		
		
		
		
		
		stmt.close();
		conn.close();
		return output;
	}
	
public boolean deleteFilm ( int filmId ) throws SQLException {
		
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "delete from film where film.id = ( ? )";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,  filmId );
		
		int updateCount = stmt.executeUpdate();
		
		if (updateCount == 1) {
			return true;
		}
		
		
		
		stmt.close();
		conn.close();
		
		
		
		
		return false;
	}

//UPDATE film
//SET title = "traci", description="aaa" , release_year=2007, language_id="1", rental_duration =30, rental_rate=2, 
//length=30, replacement_cost=2.0,
//rating="g", special_features="Trailers"
//where title = "kyle";


public boolean updateFilm( int id,String title, String description, int year, int lang, int rentalDur, double rentalrate,
		int length, double replace, String rating, String SF) {
	
	Connection conn;
	try {
		conn = DriverManager.getConnection(URL, user, pass);
		String sql = "UPDATE film "
				+ "SET title = ?, description= ? , release_year= ?, language_id= ?, rental_duration = ? "
				+ ", rental_rate= ?, length= ?, replacement_cost = ?, rating= ?, special_features=?"
				+ "WHERE id = ? ";
		
		
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,  title);
		stmt.setString(2, description);
		stmt.setInt(3, year);
		stmt.setInt(4, lang);
		stmt.setInt(5, rentalDur);
		stmt.setDouble(6, rentalrate);
		stmt.setInt(7, length);
		stmt.setDouble(8, replace);
		stmt.setString(9, rating);
		stmt.setString(10, SF);
		stmt.setInt(11, id);
		
		
		
		int updateCount = stmt.executeUpdate();
		
		if (updateCount == 1) {
			return true;
		}
		
		
		
		stmt.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	return false;
	
}


















}

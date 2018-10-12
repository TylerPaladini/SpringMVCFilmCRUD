package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "select film.id, title, description, release_year, language.name, rental_duration, rental_rate, length, replacement_cost,"
                + " rating, special_features" + "  from film join language on film.language_id = language.id "
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
            film.setLanguage(filmResult.getString("language.name"));
            film.setRentalDuration(filmResult.getInt("rental_duration"));
            film.setRentalRate(filmResult.getDouble("rental_rate"));
            film.setLength(filmResult.getInt("length"));
            film.setReplacementCost(filmResult.getDouble("replacement_cost"));
            film.setRating(filmResult.getString("rating"));
            film.setSpecialFeature(filmResult.getString("special_features"));
//            
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
        List<Actor> list = null;
        Actor actor = null;

        String sql = " select actor.first_name, actor.last_name from actor "
                + " join film_actor on actor.id = film_actor.actor_id " + "  join film on film.id = film_actor.film_id "
                + " where film.id = ? ";
        Connection conn = DriverManager.getConnection(URL, user, pass);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, filmId);
        ResultSet actorResult = stmt.executeQuery();
        list = new ArrayList<>();
        while (actorResult.next()) {
            actor = new Actor();

            actor.setFirstName(actorResult.getString("first_name"));
            actor.setLastName(actorResult.getString("last_name"));

            list.add(actor);
        }

        return list;
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

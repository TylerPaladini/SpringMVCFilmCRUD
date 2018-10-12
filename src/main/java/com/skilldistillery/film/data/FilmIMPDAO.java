package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Film;

public class FilmIMPDAO implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	@Override
	public Film filmById(int filmId) {
		Film output = null;

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

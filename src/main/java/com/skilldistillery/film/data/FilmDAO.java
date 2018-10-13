package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public List<Film> getFilmByKeyword(String keyword) throws SQLException;
	public boolean addFilm(Film film) throws SQLException;
	Film getFilmById(int filmId) throws SQLException;
	List<Actor> getActorsByFilmId(int filmId) throws SQLException;

}

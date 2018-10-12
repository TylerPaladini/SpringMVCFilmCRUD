package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public Film filmById(int filmId);
	public List<Film> getFilmByKeyword(String keyword);
	public Film addFilm(Film film);

}
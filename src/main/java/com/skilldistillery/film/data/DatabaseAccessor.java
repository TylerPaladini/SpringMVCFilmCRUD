package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	
	public Film filmById();
	public List<Film> getFilmByKeyword(String keyword);
	public Film addFilm(Film film);

}

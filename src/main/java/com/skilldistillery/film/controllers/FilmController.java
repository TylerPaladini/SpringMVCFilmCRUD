package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;


@Controller
public class FilmController {
	@Autowired
	private FilmDAO fdao  ;
	
	
	
	
	@RequestMapping( path= "GetFilm.do", method = RequestMethod.GET, params= "FilmId")
	public ModelAndView getFilmById( int filmId ) throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		Film fSearch = fdao.getFilmById(filmId);
		mv.addObject("film", fSearch);
		mv.setViewName("WEB_INF/views/home.jsp");
		
		
		return mv;
	}
	
}

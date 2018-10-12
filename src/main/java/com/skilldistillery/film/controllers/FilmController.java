package com.skilldistillery.film.controllers;

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
	
	
	
	
	@RequestMapping( path= "XXX", method = RequestMethod.GET, params= "filmId")
	public ModelAndView getFilmById( int filmId ) {
		
		ModelAndView mv = new ModelAndView();
		Film fSearch = fdao.filmById(filmId);
		mv.addObject("film", fSearch);
		mv.setViewName("WEB_INF/views/home.jsp");
		
		
		return null;
		
		
		
	}
	@RequestMapping("index.do")
	public String index() {
		return "/WEB-INF/views/home.jsp";
	}
	
}

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
	
	
	
	
	@RequestMapping( path= "GetFilm.do", method = RequestMethod.GET)
	public ModelAndView getFilmById( int FilmId ) {
		
		ModelAndView mv = new ModelAndView();
		Film fSearch;
		try {
			fSearch = fdao.getFilmById(FilmId);
			mv.addObject("film", fSearch);
			mv.setViewName("WEB-INF/views/home.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
	@RequestMapping( "index.do")
	public String index() {
		return "/WEB-INF/views/home.jsp";
	}
	
}

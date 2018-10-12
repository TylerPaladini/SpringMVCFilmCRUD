package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	private FilmDAO fdao;

	@RequestMapping(path = "GetFilm.do", method = RequestMethod.GET)
	public ModelAndView getFilmById(int FilmId) {

		ModelAndView mv = new ModelAndView();
		List<Film> fList = new ArrayList<>();
		try {
			Film fSearch = fdao.getFilmById(FilmId);
			fList.add(fSearch);
			mv.addObject("film", fList);
			mv.setViewName("WEB-INF/views/results.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	// public List<Film> getFilmByKeyword(String keyword)
	@RequestMapping(path = "GetKeyword.do", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> kSearch = new ArrayList<>();

		try {
			kSearch = fdao.getFilmByKeyword(keyword);
			mv.addObject("film", kSearch);
			mv.setViewName("WEB-INF/views/results.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("index.do")
	public String index() {
		return "/WEB-INF/views/home.jsp";
	}

}

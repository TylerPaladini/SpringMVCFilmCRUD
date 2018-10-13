package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	
	@RequestMapping(path = "GetKeyword.do", method = RequestMethod.GET, params = "Keyword")
	public ModelAndView getFilmByKeyword(String Keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> kSearch = new ArrayList<>();

		try {
			kSearch = fdao.getFilmByKeyword( Keyword );
			System.out.println("*******************" + kSearch);
			mv.addObject("film", kSearch);
			mv.setViewName("WEB-INF/views/results.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	//public boolean addFilm(Film film);
//	
//	@RequestMapping(path = "newFilm.do", method = RequestMethod.POST)
//	public ModelAndView addFilm ( Film film, RedirectAttributes redir) {
//		boolean added = fdao.addFilm(film);
//		
//		ModelAndView mv = new ModelAndView();
//		redir.addFlashAttribute("filmAdd", added );
//		mv.setViewName("filmAdded.do");
//		
//		return mv;
//	}
//	@RequestMapping( path ="filmAdded.do", method=RequestMethod.GET)
//	public ModelAndView filmAdded () {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/WEB-INF/views/home.jsp");
//		
//		return mv;
//		
//	}
//	
//	@RequestMapping( path="deleteFilm.do",method = RequestMethod.POST )
//	public ModelAndView deleteFilm( String keyword, RedirectAttributes redir) {
//		boolean deleted = fdao.deleteFilm(keyword);
//		ModelAndView mv = new ModelAndView();
//		redir.addFlashAttribute("deleted", deleted );
//		mv.setViewName("filmDeleted.do");
//		
//		return mv;
//		
//	}
//	@RequestMapping( path ="filmDeleted.do", method=RequestMethod.GET)
//	public ModelAndView filmDeleted () {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/WEB-INF/views/home.jsp");
//		
//		return mv;
//		
//	}
//	
	
	

	@RequestMapping("index.do")
	public String index() {
		return "/WEB-INF/views/home.jsp";
	}

}


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
	
	@RequestMapping(path = "newFilm.do", method = RequestMethod.GET, 
			params = {"Title", "Description", "ReleaseYear", "FilmLength"})
	public ModelAndView addFilm ( String Title, String Description, int ReleaseYear,  int FilmLength, RedirectAttributes redir) {
		
		Film newFilm = new Film(0,Title, Description, ReleaseYear, 1, 0, 2.99, FilmLength, 5.99, "G", null, null);
		
		
		ModelAndView mv = new ModelAndView();
		try {
			boolean added = fdao.addFilm( newFilm );
			redir.addFlashAttribute("filmAdd", added );
			mv.setViewName("filmAdded.do");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
		
		
	}
	@RequestMapping( path ="filmAdded.do", method=RequestMethod.GET)
	public ModelAndView filmAdded () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/conformation.jsp");
		
		return mv;
		
	}
	
	@RequestMapping( path="deleteFilm.do",method = RequestMethod.GET )
	public ModelAndView deleteFilm( int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean deleted;
		try {
			deleted = fdao.deleteFilm( filmId );
			redir.addFlashAttribute("deleted", deleted );
			mv.setViewName("filmDeleted.do");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
		
	}
	@RequestMapping( path ="filmDeleted.do", method=RequestMethod.GET)
	public ModelAndView filmDeleted () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/conformation.jsp");
		
		return mv;
		
	}
	@RequestMapping( path="updateFilm.do",method = RequestMethod.GET )
	public ModelAndView updateFilm( int filmId, String filmTitle, String filmDescription, int filmYear, int filmLanguage, int filmrentalDuration,
			double filmRentalRate, int filmLength, double filmReplacementCost, String filmRating, String filmSF,  RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean updated;
		
			updated = fdao.updateFilm(filmId, filmTitle, filmDescription, filmYear, filmLanguage, filmrentalDuration,
					filmRentalRate, filmLength, filmReplacementCost, filmRating, filmSF);
					
					
			redir.addFlashAttribute("updated", updated);
			mv.setViewName("filmUpdated.do");
	
		
		return mv;
	}
	
	@RequestMapping( path ="filmUpdated.do", method=RequestMethod.GET)
	public ModelAndView filmUpdated () {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/conformation.jsp");
		
		return mv;
		
	}
		
	
	
	
	

	@RequestMapping("index.do")
	public String index() {
		return "/WEB-INF/views/home.jsp";
	}

}

package com.skilldistillery.film.entities;


import static junit.framework.TestCase.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.film.data.FilmIMPDAO;

public class FilmTests {



	@Test
	public void test_getFilmByKeyword() {
		try {

			FilmIMPDAO dao = new FilmIMPDAO();
			List list = dao.getFilmByKeyword("killer");

//			for (Object object : list) {
//				System.out.println(object.toString());
//			}

			assertEquals(2, dao.getFilmByKeyword("killer").size());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_addFilm() {
		try {
			Film newFilm = new Film();
			newFilm.setTitle("Test01");
			newFilm.setDescription("Description test 01");

			FilmIMPDAO dao = new FilmIMPDAO();
			dao.addFilm(newFilm);
			
			List list = dao.getFilmByKeyword("test");
			
			for (Object object : list) {
				System.out.println(object.toString());
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	



}

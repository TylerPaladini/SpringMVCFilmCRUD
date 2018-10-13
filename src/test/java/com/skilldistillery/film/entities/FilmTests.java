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
	public void testCreate() {
		try {
			
			FilmIMPDAO dao = new FilmIMPDAO();
			List list = dao.getFilmByKeyword("laska");

			assertEquals("test", "tes");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			
			FilmIMPDAO dao = new FilmIMPDAO();
			List list = dao.getActorsByFilmId(3);
			
			assertEquals("test", "tes");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}



}

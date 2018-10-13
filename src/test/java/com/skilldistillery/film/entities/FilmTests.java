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
			List list = dao.getFilmByKeyword("killer");
			
			for (Object object : list) {
				System.out.println(object.toString());
			}

			assertEquals("test", "tes");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	



}

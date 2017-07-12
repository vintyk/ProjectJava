package by.ecp.tests;

import by.ecp.entity.Company;
import by.ecp.entity.Genre;
import by.ecp.services.CompanyService;
import by.ecp.services.GenreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class GenreServiceTest extends BaseTest{
    @Autowired
    private GenreService genreService;

    @Test
    public void findAll(){
        Genre genre = new Genre();
        genre.setName("a");
        genreService.save(genre);
        List<Genre> genreList = genreService.findAll();
        assertThat(genreList, notNullValue());
        Genre genre1 = genreService.findOne(1L);
        assertThat(genre1, notNullValue());
    }
}

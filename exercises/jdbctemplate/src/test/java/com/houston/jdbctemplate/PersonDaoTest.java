package com.houston.jdbctemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Person dao, you should implement the person dao implementation.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context.xml")
public class PersonDaoTest {
    @Autowired
    PersonDao personDao;

    @Test
    public void getPersonByIdFoundInDB() {
        Long id = 2L;
        Person person = personDao.get(id);
        assertEquals("Ids should match", id, person.id);
        String work = "work";
        assertTrue("Name should match with '" + work + "'", person.name.contains(work));
    }

    @Test(expected = PersonNotFoundException.class)
    public void getPersonByIdNotFoundInDB() {
        personDao.get(-1L);
    }

}

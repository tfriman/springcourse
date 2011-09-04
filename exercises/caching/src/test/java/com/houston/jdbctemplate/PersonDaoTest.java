package com.houston.jdbctemplate;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDaoTest.class);

    @Autowired
    private PersonDao personDao;

    @Autowired
    private EhCacheFactoryBean ehCacheFactoryBean;

    @Test
    public void getPersonByIdFoundInDBAndThenFromCache() {
        Long id = 2L;
        Person personA = personDao.get(1L);
        Person person = personDao.get(id);
        checkPerson(id, person);
        Person person2 = personDao.get(id);
        int hitLimit = 10;
        for (int i = 0; i < hitLimit; i++) {
            person2 = personDao.get(id);
        }
        checkPerson(id, person2);
        assertEquals("persons should match", person, person2);
        assertEquals("persons should match", personA, personDao.get(1L));
        Ehcache cache = ehCacheFactoryBean.getObject();
        Statistics statistics = cache.getStatistics();
        long hits = statistics.getCacheHits();
        assertEquals("there should be cache hits...", hits , hitLimit + 2);
        long misses = statistics.getCacheMisses();
        assertEquals("there should be two cache misses", 2, misses);
    }

    private void checkPerson(Long id, Person person) {
        assertEquals("Ids should match", id, person.id);
        String work = "work";
        assertTrue("Name should match with '" + work + "'", person.name.contains(work));
    }


}

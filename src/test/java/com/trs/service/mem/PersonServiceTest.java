package com.trs.service.mem;

import com.trs.entity.Person;
import com.trs.util.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;


/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.service.mem
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
    @Mock
    PersonService personService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(personService.findById(Mockito.any())).thenReturn(TestUtil.getPerson());
    }

    @Test
    public void testFindById() {
        long userId = 1;
        Optional<Person> person = personService.findById(userId);
        Assert.assertNotNull(person.get());
    }

}

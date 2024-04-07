package com.trs.service.mem;

import com.trs.TicketReservSysApplication;
import com.trs.entity.Sections;
import com.trs.util.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.service.mem
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TicketReservSysApplication.class)
public class SectionServiceTest {
    @Autowired
    SectionService sectionService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(sectionService.findById(Mockito.any())).thenReturn(TestUtil.getSection());
        Mockito.when(sectionService.findAll()).thenReturn(TestUtil.getSections());
    }

    @Test
    public void testFindById() {
        long userId = 1;
        Optional<Sections> section = sectionService.findById(userId);
        Assert.assertNotNull(section.get());
    }

    @Test
    public void testFindAll() {
        List<Sections> sectionList = sectionService.findAll();
        Assert.assertNotNull(sectionList);
    }
}

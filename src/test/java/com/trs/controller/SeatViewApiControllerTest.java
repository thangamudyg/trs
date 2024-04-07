package com.trs.controller;

import com.trs.model.Section;
import com.trs.service.mem.BookingService;
import com.trs.service.mem.SectionService;
import com.trs.util.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.mockito.Mockito.doNothing;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SeatViewApiControllerTest {
    @InjectMocks
    SeatViewApiController seatViewApiController;

    @Mock
    BookingService bookingService;

    @Mock
    SectionService sectionService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(sectionService.findAll())
                .thenReturn(TestUtil.getSections());
        Mockito.when(bookingService.findAll()).thenReturn(TestUtil.getBookingEntityList());
        doNothing().when(bookingService).remove(Mockito.any());
    }

    @Test
    public void testSeatView() throws Exception {
        ResponseEntity<List<Section>> response = seatViewApiController.getSeat("1", TestUtil.getBoarding());
        Assert.assertNotNull(response.getBody());
    }
}

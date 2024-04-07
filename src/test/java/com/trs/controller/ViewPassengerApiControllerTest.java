package com.trs.controller;

import com.trs.model.Passenger;
import com.trs.service.mem.BookingService;
import com.trs.service.mem.PersonService;
import com.trs.service.mem.TrainService;
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
public class ViewPassengerApiControllerTest {
    @InjectMocks
    ViewPassengerApiController viewPassengerApiController;

    @Mock
    BookingService bookingService;

    @Mock
    TrainService trainService;

    @Mock
    PersonService personService;
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(TestUtil.getPerson());
        Mockito.when(trainService.findById(Mockito.any()))
                .thenReturn(TestUtil.getTrain());
        Mockito.when(bookingService.findByTrainNumber(Mockito.any())).thenReturn(TestUtil.getBookingEntityList());
        doNothing().when(bookingService).remove(Mockito.any());
    }

    @Test
    public void testViewPassenger() throws Exception {
        ResponseEntity<List<Passenger>> response = viewPassengerApiController.gePassengerList("1122");
        Assert.assertNotNull(response.getBody());
    }
}

package com.trs.controller;

import com.trs.TicketReservSysApplication;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.mockito.Mockito.doNothing;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.controller
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TicketReservSysApplication.class)
public class ViewPassengerApiControllerTest {
    @InjectMocks
    ViewPassengerApiController viewPassengerApiController;

    @Autowired
    BookingService bookingService;

    @Autowired
    TrainService trainService;

    @Autowired
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

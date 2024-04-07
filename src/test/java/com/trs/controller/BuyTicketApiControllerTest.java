package com.trs.controller;

import com.trs.TicketReservSysApplication;
import com.trs.model.Receipt;
import com.trs.service.mem.BookingService;
import com.trs.service.mem.PersonService;
import com.trs.service.mem.ReceiptService;
import com.trs.service.mem.SectionService;
import com.trs.util.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Mockito.doNothing;


/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.controller
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TicketReservSysApplication.class)
public class BuyTicketApiControllerTest {
    @InjectMocks
    BuyTicketApiController buyTicketApiController;

    @Autowired
    PersonService personService;

    @Autowired
    BookingService bookingService;

    @Autowired
    SectionService sectionService;

    @Autowired
    ReceiptService receiptService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(TestUtil.getPerson());
        Mockito.when(bookingService.findAll()).thenReturn(TestUtil.getBookingList());
        Mockito.when(sectionService.findAll()).thenReturn(TestUtil.getSections());
        doNothing().when(receiptService).save(Mockito.any());
        doNothing().when(bookingService).save(Mockito.any());
    }

    @Test
    public void testBuyTicket() throws Exception {
        ResponseEntity<Receipt> response = buyTicketApiController.buyTicket("1", TestUtil.getBoarding());
        Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(response.getBody().getBooking());
        Assert.assertNotNull(response.getBody().getReceiptId());
        Assert.assertNotNull(response.getBody().getUser());
    }

    @Test
    public void testBuyTicketBadRequest() throws Exception {
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(Optional.empty());
        ResponseEntity<Receipt> response = buyTicketApiController.buyTicket("1", TestUtil.getBoarding());
        Assert.assertNull(response.getBody());
    }
}

package com.trs.controller;

import com.trs.TicketReservSysApplication;
import com.trs.model.Receipt;
import com.trs.service.mem.BookingService;
import com.trs.service.mem.PersonService;
import com.trs.service.mem.ReceiptService;
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
public class ModifySeatApiControllerTest {
    @InjectMocks
    ModifySeatApiController modifySeatApiController;

    @Autowired
    PersonService personService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ReceiptService receiptService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(TestUtil.getPerson());
        Mockito.when(receiptService.findByUserId(Mockito.any()))
                .thenReturn(TestUtil.getReceiptEntityList());
        Mockito.when(bookingService.findByUserAndReceiptId(Mockito.any(), Mockito.any())).thenReturn(TestUtil.getBookingEntity());
        doNothing().when(bookingService).remove(Mockito.any());
    }

    @Test
    public void testModifyTicket() throws Exception {
        ResponseEntity<Receipt> response = modifySeatApiController.modifySeat("1", TestUtil.getBooking());
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testModifyTicketBadRequest() throws Exception {
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(Optional.empty());
        ResponseEntity<Receipt> response = modifySeatApiController.modifySeat("1", TestUtil.getBooking());
        Assert.assertNull(response.getBody());
    }
}

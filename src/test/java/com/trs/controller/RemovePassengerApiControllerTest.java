package com.trs.controller;

import com.trs.service.mem.BookingService;
import com.trs.service.mem.PersonService;
import com.trs.service.mem.ReceiptService;
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

import java.util.Optional;

import static org.mockito.Mockito.doNothing;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RemovePassengerApiControllerTest {

    @InjectMocks
    RemovePassengerApiController removePassengerApiController;

    @Mock
    PersonService personService;

    @Mock
    BookingService bookingService;

    @Mock
    ReceiptService receiptService;
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(TestUtil.getPerson());
        Mockito.when(receiptService.findByUserId(Mockito.any()))
                .thenReturn(TestUtil.getReceiptEntityList());
        Mockito.when(bookingService.findByUserAndReceiptId(Mockito.any(), Mockito.any())).thenReturn(TestUtil.getBookingEntity());
        doNothing().when(receiptService).save(Mockito.any());
        doNothing().when(bookingService).save(Mockito.any());
    }
    @Test
    public void testRemovePassenger() throws Exception {
        ResponseEntity<String> response = removePassengerApiController.offBoard("1");
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testRemovePassengerBadRequest() throws Exception {
        Mockito.when(personService.findById(Mockito.any()))
                .thenReturn(Optional.empty());
        ResponseEntity<String> response = removePassengerApiController.offBoard("1");
        Assert.assertNull(response.getBody());
    }
}

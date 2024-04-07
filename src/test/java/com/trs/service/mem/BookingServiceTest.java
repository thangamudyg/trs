package com.trs.service.mem;

import com.trs.TicketReservSysApplication;
import com.trs.entity.Booking;
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

import static org.mockito.Mockito.doNothing;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.service.mem
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TicketReservSysApplication.class)
public class BookingServiceTest {
    @Autowired
    BookingService bookingService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(bookingService.findAll()).thenReturn(TestUtil.getBookingList());
        Mockito.when(bookingService.findByTrainNumber(Mockito.any())).thenReturn(TestUtil.getBookingList());
        Mockito.when(bookingService.findByUserAndReceiptId(Mockito.any(), Mockito.any())).thenReturn(TestUtil.getBookingEntity());
        doNothing().when(bookingService).save(Mockito.any());
    }

    @Test
    public void testFindAll() {
        List<Booking> bookingList = bookingService.findAll();
        Assert.assertNotNull(bookingList);
    }

    @Test
    public void testFindByTrainNumber() {
        long trainNumber = 1122;
        List<Booking> bookingList = bookingService.findByTrainNumber(trainNumber);
        Assert.assertNotNull(bookingList);
    }

    @Test
    public void testFindByUserAndReceiptId() {
        long userId = 1;
        long receiptId = 1;
        Booking booking = bookingService.findByUserAndReceiptId(userId, receiptId);
        Assert.assertNotNull(booking);
    }
}

package com.trs.service.mem;

import com.trs.TicketReservSysApplication;
import com.trs.entity.Receipt;
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
public class ReceiptServiceTest {
    @Autowired
    ReceiptService receiptService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(receiptService.findById(Mockito.any())).thenReturn(TestUtil.getReceiptEntity());
        Mockito.when(receiptService.findByUserId(Mockito.any())).thenReturn(TestUtil.getReceiptEntityList());
    }

    @Test
    public void testFindById() {
        long userId = 1;
        Optional<Receipt> receipt = receiptService.findById(userId);
        Assert.assertNotNull(receipt.get());
    }

    @Test
    public void testFindByUserId() {
        long userId = 1;
        List<Receipt> receiptList = receiptService.findByUserId(userId);
        Assert.assertNotNull(receiptList);
    }
}

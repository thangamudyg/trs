package com.trs.service.mem;

import com.trs.entity.Receipt;
import com.trs.util.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.service.mem
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ReceiptServiceTest {
    @Mock
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

package com.trs.service;


import com.trs.api.ReceiptsApi;
import com.trs.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ViewReceiptService implements ReceiptsApi {

    @Autowired
   com.trs.service.mem.ReceiptService receiptService;

    @Override
    public ResponseEntity<List<Receipt>> getReceipt(String userId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}

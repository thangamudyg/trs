package com.trs.service;


import com.trs.api.ReceiptsApi;
import com.trs.entity.Person;
import com.trs.model.Receipts;
import com.trs.service.mem.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReceiptService implements ReceiptsApi {

    @Autowired
    PersonService personService;

    @Override
    public ResponseEntity<List<Receipts>> getReceipt(String userId) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}

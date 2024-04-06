package com.trs.service.mem;

import com.trs.entity.Person;
import com.trs.entity.Receipt;
import com.trs.repository.PersonRepository;
import com.trs.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    public Optional<Receipt> findById(Long id) {
        return receiptRepository.findById(id);
    }

    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }
}

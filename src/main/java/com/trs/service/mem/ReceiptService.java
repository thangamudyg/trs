package com.trs.service.mem;



import com.trs.entity.Receipt;
import com.trs.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.service.mem
 */
@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    public Optional<Receipt> findById(Long id) {
        return receiptRepository.findById(id);
    }

    public List<Receipt> findByUserId(Long userId) {
        return receiptRepository.findByUserId(userId);
    }

    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    public void remove(Receipt receipt) {
        receiptRepository.delete(receipt);
    }
}

package com.trs.service;

import com.trs.api.OffBoardApi;
import com.trs.entity.Booking;
import com.trs.entity.Person;
import com.trs.entity.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RemovePassengerService implements OffBoardApi {

    @Autowired
    com.trs.service.mem.PersonService personService;
    @Autowired
    com.trs.service.mem.BookingService bookingService;
    @Autowired
    com.trs.service.mem.ReceiptService receiptService;
    @Override
    public ResponseEntity<String> offBoard(String userId) {
        Optional<Person> person = personService.findById(Long.valueOf(userId));
        if(!person.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        List<Receipt> receipts = receiptService.findByUserId(Long.valueOf(userId));
        if(receipts.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        receipts.forEach( r -> {
            bookingService.remove(r.getBooking());
            r.setBooking(null);
        });
        receipts.forEach( r -> receiptService.remove(r));
        return ResponseEntity.ok().body("SUCCESS");
    }
}

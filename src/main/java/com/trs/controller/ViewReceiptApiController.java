package com.trs.controller;


import com.trs.api.ReceiptsApi;
import com.trs.entity.Person;
import com.trs.model.Booking;
import com.trs.model.Receipt;
import com.trs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.controller
 */
@RestController
public class ViewReceiptApiController implements ReceiptsApi {

    @Autowired
    com.trs.service.mem.ReceiptService receiptService;

    @Autowired
    com.trs.service.mem.PersonService personService;
    @Override
    public ResponseEntity<List<Receipt>> getReceipt(String userId) {
        Optional<Person> person = personService.findById(Long.valueOf(userId));
        if(!person.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        List<com.trs.entity.Receipt> receipts = receiptService.findByUserId(Long.valueOf(userId));

        if(receipts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<Receipt> receiptListResp = new ArrayList<>();
        receipts.forEach(r -> {
            Receipt receipt = new Receipt();
            receipt.setReceiptId(r.getReceipt_id());
            User user = new User();
            user.setEmail(person.get().getEmail_address());
            user.setFirstName(person.get().getFirst_name());
            user.setLastName(person.get().getLast_name());
            receipt.setUser(user);
            receipt.setPrice(r.getPrice());
            receipt.setToStation(r.getTo_station());
            receipt.setFromStation(r.getFrom_station());
            Booking booking = new Booking();
            booking.setSeatNumber(String.valueOf(r.getBooking().getSeat_number()));
            booking.setSectionName(r.getBooking().getSection_name());
            booking.setTrainNumber(r.getBooking().getTrain_number());
            receipt.setBooking(booking);
            receiptListResp.add(receipt);
        });
        return ResponseEntity.ok(receiptListResp);
    }
}

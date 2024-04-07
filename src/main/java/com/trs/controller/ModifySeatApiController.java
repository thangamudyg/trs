package com.trs.controller;

import com.trs.api.ModifySeatApi;

import com.trs.entity.Person;
import com.trs.model.Booking;
import com.trs.model.Receipt;
import com.trs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.controller
 */
@RestController
public class ModifySeatApiController implements ModifySeatApi {

    @Autowired
    com.trs.service.mem.PersonService personService;
    @Autowired
    com.trs.service.mem.BookingService bookingService;
    @Autowired
    com.trs.service.mem.ReceiptService receiptService;

    @Override
    public ResponseEntity<Receipt> modifySeat(String userId, Booking booking) {
        Optional<Person> person = personService.findById(Long.valueOf(userId));
        if(!person.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        List<com.trs.entity.Receipt> receipts = receiptService.findByUserId(Long.valueOf(userId));
        if(receipts.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        com.trs.entity.Booking bookingRecord = bookingService.findByUserAndReceiptId(Long.valueOf(userId), Long.valueOf(booking.getReceiptId()));
        bookingRecord.setSeat_number(Integer.valueOf(booking.getSeatNumber()));
        bookingRecord.setSection_name(booking.getSectionName());
        bookingService.save(bookingRecord);

        com.trs.entity.Receipt receipt = receipts.stream().filter(x -> x.getReceipt_id() == bookingRecord.getReceipt_id()).findAny().get();
        Receipt receiptRes = new Receipt();
        receiptRes.setReceiptId(receipt.getReceipt_id());
        User user = new User();
        user.setEmail(person.get().getEmail_address());
        user.setFirstName(person.get().getFirst_name());
        user.setLastName(person.get().getLast_name());
        receiptRes.setUser(user);
        receiptRes.setPrice(receipt.getPrice());
        receiptRes.setToStation(receipt.getTo_station());
        receiptRes.setFromStation(receipt.getFrom_station());
        Booking bookingResp = new Booking();
        bookingResp.setSeatNumber(String.valueOf(receipt.getBooking().getSeat_number()));
        bookingResp.setSectionName(bookingRecord.getSection_name());
        bookingResp.setSeatNumber(String.valueOf(bookingRecord.getSeat_number()));
        bookingResp.setTrainNumber(bookingRecord.getTrain_number());
        receiptRes.setBooking(bookingResp);
        return ResponseEntity.ok(receiptRes);
    }
}

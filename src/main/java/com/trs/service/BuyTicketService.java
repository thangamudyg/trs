package com.trs.service;

import com.trs.api.BuyTicketApi;
import com.trs.entity.Booking;
import com.trs.entity.Person;
import com.trs.entity.Sections;
import com.trs.model.Boarding;
import com.trs.model.Receipt;
import com.trs.model.Section;
import com.trs.model.User;
import com.trs.service.mem.BookingService;
import com.trs.service.mem.PersonService;
import com.trs.service.mem.ReceiptService;
import com.trs.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BuyTicketService implements BuyTicketApi {

    @Autowired
    BookingService bookingService;

    @Autowired
    PersonService personService;

    @Autowired
    com.trs.service.mem.SectionService sectionService;

    @Autowired
    ReceiptService receiptService;

    @Override
    public ResponseEntity<Receipt> buyTicket(String userId, Boarding boarding) {
        Optional<Person> person = personService.findById(Long.valueOf(userId));
        if(!person.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        List<Booking> bookingList = bookingService.findAll();
        List<Sections> sectionsList = sectionService.findAll();
        List<Section> availableSeat =  MyUtil.getAvailableSeat(bookingList, sectionsList);
        if(availableSeat.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Section section = availableSeat.stream().findAny().get();

        com.trs.entity.Receipt receipt = new com.trs.entity.Receipt();
        receipt.setPrice(5.00);
        receipt.setUser_id(Integer.valueOf(userId));
        receipt.setFrom_station(boarding.getFromStation());
        receipt.setTo_station(boarding.getToStation());
        receiptService.save(receipt);

        Booking booking = new Booking();
        booking.setTrain_number(boarding.getTrainNumber());
        booking.setSeat_number(section.getSeatNumber());
        booking.setSection_name(section.getSectionName());
        booking.setReceipt_id(receipt.getReceipt_id());
        bookingService.save(booking);

        // Prepare response
        Receipt receiptResp = new Receipt();
        receiptResp.setPrice(receipt.getPrice());
        com.trs.model.Booking bookingResp = new com.trs.model.Booking();
        bookingResp.setSectionName(booking.getSection_name());
        bookingResp.setSeatNumber(String.valueOf(booking.getSeat_number()));
        bookingResp.setTrainNumber(booking.getTrain_number());
        receiptResp.setBooking(bookingResp);
        User user = new User();
        user.setFirstName(person.get().getFirst_name());
        user.setLastName(person.get().getLast_name());
        user.setEmail(person.get().getEmail_address());
        receiptResp.setUser(user);
        receiptResp.setFromStation(boarding.getFromStation());
        receiptResp.setToStation(boarding.getToStation());
        receiptResp.setReceiptId(receipt.getReceipt_id());
        return ResponseEntity.ok(receiptResp);
    }
}

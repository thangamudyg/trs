package com.trs.controller;


import com.trs.api.PassengerApi;
import com.trs.entity.Booking;
import com.trs.entity.Person;
import com.trs.entity.Train;
import com.trs.model.Passenger;
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
public class ViewPassengerApiController implements PassengerApi {

    @Autowired
    com.trs.service.mem.TrainService trainService;

    @Autowired
    com.trs.service.mem.BookingService bookingService;

    @Autowired
    com.trs.service.mem.PersonService personService;

    @Override
    public ResponseEntity<List<Passenger>> gePassengerList(String trainNumber) {
        Optional<Train> train = trainService.findById(Long.valueOf(trainNumber));
        if(!train.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        List<Booking> bookings = bookingService.findByTrainNumber(Long.valueOf(trainNumber));
        if(bookings.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Passenger> passengers = new ArrayList<>();
        bookings.forEach(b -> {
            Optional<Person> person = personService.findById((long)b.getUser_id());
            Passenger passenger = new Passenger();
            if(person.isPresent()){
                User user = new User();
                user.setFirstName(person.get().getFirst_name());
                user.setLastName(person.get().getLast_name());
                user.setEmail(person.get().getEmail_address());
                passenger.setUser(user);
            }
            com.trs.model.Booking bookingResp = new com.trs.model.Booking();
            bookingResp.setSectionName(b.getSection_name());
            bookingResp.setSeatNumber(String.valueOf(b.getSeat_number()));
            bookingResp.setTrainNumber(b.getTrain_number());
            passenger.setBooking(bookingResp);
            passengers.add(passenger);
        });

        return ResponseEntity.ok(passengers);
    }
}

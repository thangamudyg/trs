package com.trs.controller;

import com.trs.api.ViewSeatApi;
import com.trs.entity.Booking;
import com.trs.entity.Sections;
import com.trs.model.Boarding;
import com.trs.model.Section;
import com.trs.service.mem.BookingService;
import com.trs.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatViewApiController implements ViewSeatApi {

    @Autowired
    BookingService bookingService;

    @Autowired
    com.trs.service.mem.SectionService sectionService;

    @Override
    public ResponseEntity<List<Section>> getSeat(String userId, Boarding boarding) {
        List<Booking> bookingList = bookingService.findAll();
        List<Sections> sectionsList = sectionService.findAll();
        return ResponseEntity.ok(MyUtil.getAvailableSeat(bookingList, sectionsList));
    }
}

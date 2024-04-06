package com.trs.service.mem;

import com.trs.entity.Booking;
import com.trs.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> findByTrainNumber(Long train_number) {
        return bookingRepository.findByTrainNumber(train_number);
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public void remove(Booking booking) {
        bookingRepository.delete(booking);
    }
}

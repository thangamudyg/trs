package com.trs.repository;

import com.trs.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value="select b from Booking b where b.train_number=?1")
    public List<Booking> findByTrainNumber(Long train_number);

    @Query(value="select b from Booking b where b.user_id=?1")
    public List<Booking> findByUserId(Long user_id);

    @Query(value="select b from Booking b where b.user_id=?1 and b.receipt_id=?2")
    public Booking findByUserAndReceiptId(Long user_id, Long receipt_id);
}

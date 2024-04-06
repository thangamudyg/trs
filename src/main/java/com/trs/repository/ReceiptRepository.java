package com.trs.repository;

import com.trs.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Query(value="select r from Receipt r where r.user_id=?1")
    List<Receipt> findByUserId(Long user_id);
}

package com.trs.repository;

import com.trs.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.repository
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
}

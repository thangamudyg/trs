package com.trs.repository;

import com.trs.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.repository
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

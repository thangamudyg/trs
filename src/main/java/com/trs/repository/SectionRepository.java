package com.trs.repository;

import com.trs.entity.Sections;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.repository
 */
public interface SectionRepository extends JpaRepository<Sections, Long> {
}

package com.trs.service.mem;

import com.trs.entity.Booking;
import com.trs.entity.Sections;
import com.trs.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Thangamudy Gurusamy
 * Date : 06/04/24
 * Package : com.trs.service.mem
 */
@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    public Optional<Sections> findById(Long id) {
        return sectionRepository.findById(id);
    }

    public List<Sections> findAll() {
        return sectionRepository.findAll();
    }
}

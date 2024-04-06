package com.trs.service.mem;

import com.trs.entity.Train;
import com.trs.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;
    public Optional<Train> findById(Long id) {
        return trainRepository.findById(id);
    }
}

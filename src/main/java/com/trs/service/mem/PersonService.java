package com.trs.service.mem;

import com.trs.entity.Person;
import com.trs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}

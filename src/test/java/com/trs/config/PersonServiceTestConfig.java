package com.trs.config;

import com.trs.service.mem.PersonService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.confgi
 */
@Profile("test")
@Configuration
public class PersonServiceTestConfig {
    @Bean
    @Primary
    public PersonService personService() {
        return Mockito.mock(PersonService.class);
    }
}

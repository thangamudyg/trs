package com.trs.config;

import com.trs.service.mem.TrainService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author Thangamudy Gurusamy
 * Date : 07/04/24
 * Package : com.trs.config
 */
@Profile("test")
@Configuration
public class TrainServiceTestConfig {
    @Bean
    @Primary
    public TrainService trainService() {
        return Mockito.mock(TrainService.class);
    }
}

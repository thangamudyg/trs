package com.trs.config;

import com.trs.service.mem.SectionService;
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
public class SectionServiceTestConfig {
    @Bean
    @Primary
    public SectionService sectionService() {
        return Mockito.mock(SectionService.class);
    }
}

package com.tui.ordering.pilotes;


import com.tui.ordering.pilotes.service.ValidPilotesValuesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ValidPilotesValuesService validPilotesValuesService() {
        return new ValidPilotesValuesService();
    }
}

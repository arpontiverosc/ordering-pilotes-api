package com.tui.ordering.pilotes;


import com.tui.ordering.pilotes.port.out.FindOrderPiloteValuesRepository;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.PilotesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PilotesService pilotesService(FindOrderPiloteValuesRepository findOrderPiloteValuesRepository,
                                                    FindPilotePriceRepository findPilotePriceRepository) {
        return new PilotesService(findOrderPiloteValuesRepository, findPilotePriceRepository);
    }

    @Bean
    public ClientService  clientService(){
        return new ClientService();

    }

}

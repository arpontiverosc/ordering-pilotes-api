package com.tui.ordering.pilotes;


import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import com.tui.ordering.pilotes.port.out.FindClientRepository;
import com.tui.ordering.pilotes.port.out.FindOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientService clientService(FindClientRepository findClientRepository) {
        return new ClientService(findClientRepository);
    }

    @Bean
    public OrderService orderService(FindOrderRepository findOrderRepository) {
        return new OrderService(findOrderRepository);
    }

}

package com.tui.ordering.pilotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.request.SearchOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.request.UpdateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.mother.CreateOrderRequestMother;
import com.tui.ordering.pilotes.mother.CredentialsMother;
import com.tui.ordering.pilotes.mother.UpdateOrderRequestMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SearchOrderE2ETestIT {

    private static final String ORDER_ID = "472bd97a-e744-4f40-9b14-159dc1881591";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void searchOrder_UnauthorizedTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isUnauthorized());

    }

    @Test
    void searchOrder_SuccessfullyTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders")
                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[0].orderId").isNotEmpty())
                .andExpect(jsonPath("$[0].deliveryAddress").isNotEmpty())
                .andExpect(jsonPath("$[0].pilotesNumber").isNotEmpty())
                .andExpect(jsonPath("$[0].orderTotal").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.id").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.firstName").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.lastName").isNotEmpty())
                .andExpect(jsonPath("$[0].createAt").isNotEmpty())
                .andExpect(jsonPath("$[0].email").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[2]").isNotEmpty())
                .andExpect(jsonPath("$[3]").isNotEmpty())
                .andExpect(jsonPath("$[4]").isNotEmpty())
                .andExpect(jsonPath("$[5]").isNotEmpty());

    }

    @Test
    void searchOrder_ByPilotesNumber_SuccessfullyTest() throws Exception {

        int pilotesNumber = 10;

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders?pilotesNumber="+pilotesNumber)

                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pilotesNumber").isNotEmpty())
                .andExpect(jsonPath("$[0].pilotesNumber").value(pilotesNumber));

    }

    @Test
    void searchOrder_ByCustomerId_SuccessfullyTest() throws Exception {

        String customerId = "1011";

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders?customerId="+customerId)

                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.id").value(customerId))
                .andExpect(jsonPath("$[1].customer.id").value(customerId));;

    }

    @Test
    void searchOrder_ByCustomerFirstName_SuccessfullyTest() throws Exception {

        String customerFirstName = "Antonio";

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders?customerFirstName="+customerFirstName)

                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.firstName").value(customerFirstName))
                .andExpect(jsonPath("$[1].customer.firstName").value(customerFirstName));

    }

    @Test
    void searchOrder_BySeveralParameters_SuccessfullyTest() throws Exception {

        String letterA = "A";
        String customerId = "1011";
        String letterT = "t";

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders?customerFirstName="+letterA
                                +"&customerId="+customerId
                                +"&customerLastName="+letterT)

                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.id").value(customerId))
                .andExpect(jsonPath("$[0].customer.firstName", containsString(letterA)))
                .andExpect(jsonPath("$[0].customer.lastName", containsString(letterT)))
                .andExpect(jsonPath("$[1].customer.id").value(customerId))
                .andExpect(jsonPath("$[1].customer.firstName", containsString(letterA)))
                .andExpect(jsonPath("$[1].customer.lastName", containsString(letterT)));

    }

    @Test
    void searchOrder_ByCustomerLastNameContainsCharacter_SuccessfullyTest() throws Exception {

        String letterT = "t";

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders?customerLastName="+letterT)

                        .header(HttpHeaders.AUTHORIZATION, "Basic " + CredentialsMother.getBase64Credentials())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[2]").isNotEmpty())
                .andExpect(jsonPath("$[0].customer.lastName", containsString(letterT)))
                .andExpect(jsonPath("$[1].customer.lastName", containsString(letterT)))
                .andExpect(jsonPath("$[2].customer.lastName", containsString(letterT)));

    }

}

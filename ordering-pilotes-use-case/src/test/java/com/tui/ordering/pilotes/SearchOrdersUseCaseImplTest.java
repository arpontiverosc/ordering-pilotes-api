package com.tui.ordering.pilotes;


import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.mother.OrderMother;
import com.tui.ordering.pilotes.mother.SearchOrderQueryMother;
import com.tui.ordering.pilotes.port.in.SearchOrdersUseCase;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;
import com.tui.ordering.pilotes.port.out.SearchOrdersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchOrdersUseCaseImplTest {

    private SearchOrdersUseCase searchOrdersUseCase;

    private SearchOrdersRepository searchOrdersRepository;

    @BeforeAll
    public void setUp() {
        searchOrdersRepository = mock(SearchOrdersRepository.class);
        searchOrdersUseCase = new SearchOrdersUseCaseImpl(searchOrdersRepository);
    }


    @Test
    public void executeQueryTest() {

        SearchOrderQuery searchOrderQuery = SearchOrderQueryMother.create();

        when(searchOrdersRepository.searchBy(searchOrderQuery)).thenReturn(OrderMother.createList());

        List<Order> orders = searchOrdersUseCase.execute(searchOrderQuery);

        assertNotNull(orders);
    }
}

package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.SearchOrdersUseCase;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.port.out.SearchOrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SearchOrdersUseCaseImpl implements SearchOrdersUseCase {

    private final SearchOrdersRepository searchOrdersRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Order> execute(String searchQuery) {
        return searchOrdersRepository.searchBy(searchQuery);
    }
}

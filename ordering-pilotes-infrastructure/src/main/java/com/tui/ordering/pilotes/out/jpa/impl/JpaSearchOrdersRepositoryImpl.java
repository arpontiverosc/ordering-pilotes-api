package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.impl.spec.OrderSpecificationsBuilder;
import com.tui.ordering.pilotes.out.jpa.impl.spec.SearchCriteria;
import com.tui.ordering.pilotes.port.out.SearchOrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
@RequiredArgsConstructor
public class JpaSearchOrdersRepositoryImpl implements SearchOrdersRepository {




    @Override
    public List<Order> searchBy(String searchQuery) {
/*
        OrderSpecificationsBuilder UserSpecificationsBuilder = new OrderSpecificationsBuilder();
        OrderSpecificationsBuilder builder = new OrderSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(searchQuery + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        return null;*/
/*
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (!Objects.isNull(searchQuery)) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(searchQuery + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return service.searchOrder(params);*/

        return null;
    }
}

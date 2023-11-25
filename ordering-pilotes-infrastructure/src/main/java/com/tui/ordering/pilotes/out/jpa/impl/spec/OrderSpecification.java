package com.tui.ordering.pilotes.out.jpa.impl.spec;

import com.tui.ordering.pilotes.out.jpa.model.CustomerEntity;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderSpecification {
    public static Optional<Specification<OrderEntity>> where(SearchOrderQuery query) {
        List<Specification<OrderEntity>> specifications = new ArrayList<>();
        specifications.add(byOrderIdEqual(query.getOrderId()));
        specifications.add(byPilotesNumberEqual(query.getPilotesNumber()));
        specifications.add(byCustomerIdEqual(query.getCustomerId()));
        specifications.add(byCustomerFirstNameEqual(query.getCustomerFirstName()));
        specifications.add(byCustomerLastNameEqual(query.getCustomerLastName()));
        return Optional.ofNullable(listToOne(removeNullElements(specifications)));
    }


    public static Specification<OrderEntity> byOrderIdEqual(String orderId) {
        if (orderId == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("orderId"), orderId);
    }

    public static Specification<OrderEntity> byPilotesNumberEqual(Integer pilotesNumber) {
        if (pilotesNumber == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("pilotesNumber"), pilotesNumber);
    }

    public static Specification<OrderEntity> byCustomerIdEqual(String customerId) {
        if (customerId == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<CustomerEntity, OrderEntity> joinCustomer = root.join("customer");
            return criteriaBuilder.equal(joinCustomer.get("id"), customerId);
        };
    }

    public static Specification<OrderEntity> byCustomerFirstNameEqual(String customerFirstName) {
        if (customerFirstName == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<CustomerEntity, OrderEntity> joinCustomer = root.join("customer");
            return criteriaBuilder.like(
                    criteriaBuilder.lower(joinCustomer.get("firstName")),
                    "%" + customerFirstName.toLowerCase() + "%"
            );
        };
    }

    public static Specification<OrderEntity> byCustomerLastNameEqual(String customerLastName) {
        if (customerLastName == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            Join<CustomerEntity, OrderEntity> joinCustomer = root.join("customer");
            return criteriaBuilder.like(
                    criteriaBuilder.lower(joinCustomer.get("lastName")),
                    "%" + customerLastName.toLowerCase() + "%"
            );
        };
    }


    private static List<Specification<OrderEntity>> removeNullElements(List<Specification<OrderEntity>> specifications) {
        return specifications.stream().filter(Objects::nonNull).toList();
    }

    private static Specification<OrderEntity> listToOne(List<Specification<OrderEntity>> specifications) {
        Specification<OrderEntity> specification = null;
        for (Specification<OrderEntity> spec : specifications) {
            if (specification == null) {
                specification = spec;
            } else {
                specification = specification.and(spec);
            }
        }
        return specification;
    }
}

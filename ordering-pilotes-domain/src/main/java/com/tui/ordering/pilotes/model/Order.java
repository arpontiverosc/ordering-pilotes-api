package com.tui.ordering.pilotes.model;

import com.tui.ordering.pilotes.port.in.model.OrderAddress;

public class Order {
    private final String userIdentier;
    private final OrderAddress deliveryAddress;
    private final int pilotes;
    private final double orderTotal;

    private Order(Builder builder) {
        this.userIdentier = builder.userIdentifier;
        this.orderTotal = builder.orderTotal;
        this.pilotes = builder.pilotes;
        this.deliveryAddress = builder.deliveryAddress;
    }

    public String getUserIdentier() {
        return userIdentier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotes() {
        return pilotes;
    }

    public double getOrderTotal() {
        return orderTotal;
    }


    public static final class Builder {
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private int pilotes;
        private double orderTotal;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder deliveryAddress(OrderAddress deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder pilotes(int pilotes) {
            this.pilotes = pilotes;
            return this;
        }

        public Builder orderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

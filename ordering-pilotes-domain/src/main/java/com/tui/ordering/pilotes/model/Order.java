package com.tui.ordering.pilotes.model;


import java.time.OffsetDateTime;

public class Order {
    private final String orderId;
    private final Customer customer;
    private final Address deliveryAddress;
    private final int pilotesNumber;
    private final double orderTotal;
    private final OffsetDateTime createdAt;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customer = builder.customer;
        this.orderTotal = builder.orderTotal;
        this.pilotesNumber = builder.pilotesNumber;
        this.deliveryAddress = builder.deliveryAddress;
        this.createdAt = builder.createdAt;
    }


    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotesNumber() {
        return pilotesNumber;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {
        private String orderId;
        private Customer customer;
        private Address deliveryAddress;
        private int pilotesNumber;
        private double orderTotal;
        private OffsetDateTime createdAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder deliveryAddress(Address deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder pilotes(int pilotes) {
            this.pilotesNumber = pilotes;
            return this;
        }

        public Builder orderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

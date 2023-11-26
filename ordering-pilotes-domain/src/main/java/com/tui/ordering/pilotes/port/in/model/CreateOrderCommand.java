package com.tui.ordering.pilotes.port.in.model;

public class CreateOrderCommand {

    private final String userIdentifier;
    private final OrderAddress deliveryAddress;
    private final Integer pilotesNumber;
    private final String email;

    private CreateOrderCommand(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.deliveryAddress = builder.deliveryAddress;
        this.pilotesNumber = builder.pilotesNumber;
        this.email = builder.email;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public Integer getPilotesNumber() {
        return pilotesNumber;
    }

    public String getEmail() {
        return email;
    }

    public static final class Builder {
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private Integer pilotesNumber;
        private String email;

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

        public Builder pilotes(Integer pilotesNumber) {
            this.pilotesNumber = pilotesNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public CreateOrderCommand build() {
            return new CreateOrderCommand(this);
        }
    }
}

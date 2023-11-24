package com.tui.ordering.pilotes.port.in.model;

public class CreateOrderCommand {

    private final String userIdentifier;
    private final OrderAddress deliveryAddress;
    private final int pilotesNumber;

    private CreateOrderCommand(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.deliveryAddress = builder.deliveryAddress;
        this.pilotesNumber = builder.pilotesNumber;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotesNumber() {
        return pilotesNumber;
    }

    public static final class Builder {
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private int pilotesNumber;

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

        public Builder pilotes(int pilotesNumber) {
            this.pilotesNumber = pilotesNumber;
            return this;
        }

        public CreateOrderCommand build() {
            return new CreateOrderCommand(this);
        }
    }
}

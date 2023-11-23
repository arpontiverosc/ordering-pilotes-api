package com.tui.ordering.pilotes.port.in.model;

public class CreateOrderCommand {

    private final String userIdentifier;
    private final OrderAddress deliveryAddress;
    private final int pilotes;

    private CreateOrderCommand(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.deliveryAddress = builder.deliveryAddress;
        this.pilotes = builder.pilotes;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getPilotes() {
        return pilotes;
    }

    public static final class Builder {
        private String userIdentifier;
        private OrderAddress deliveryAddress;
        private int pilotes;

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

        public CreateOrderCommand build() {
            return new CreateOrderCommand(this);
        }
    }
}

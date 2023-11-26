package com.tui.ordering.pilotes.util;


public class OrderErrorCode {
    public static final String USER_IDENTIFIER_MANDATORY = "order.user.identifier.mandatory";
    public static final String DELIVERY_ADDRESS_MANDATORY = "order.delivery.address.mandatory";
    public static final String PILOTES_NUMBER_MANDATORY = "order.pilotes.number.mandatory";
    public static final String ADDRESS_STREET_MANDATORY = "order.address.street.mandatory";
    public static final String ADDRESS_POSTCODE_MANDATORY = "order.address.postcode.mandatory";
    public static final String ADDRESS_CITY_MANDATORY = "order.address.city.mandatory";
    public static final String ADDRESS_CODE_MANDATORY = "order.address.code.mandatory";
    public static final String NOT_FOUND = "order.notFound";
    public static final String INVALID_STATUS = "order.invalidStatus";
    public static final String EMAIL_MANDATORY = "order.email.mandatory";
    public static final String EMAIL_FORMAT = "order.email.invalid.format";
    public static final String STREET_MIN_LENGTH = "order.street.min.length";
    public static final String POSTCODE_INVALID = "order.postcode.invalid";
    public static final String STREET_MAX_LENGTH = "order.street.max.length";
    public static final String CITY_MIN_LENGTH = "order.city.min.length";
    public static final String CITY_MAX_LENGTH = "order.city.max.length";
    public static final String COUNTRY_MIN_LENGTH = "order.country.min.length";
    public static final String COUNTRY_MAX_LENGTH = "order.country.max.length";
    public static final String ORDER_ID_MIN_LENGTH = "order.orderId.min.length";
    public static final String ORDER_ID_MAX_LENGTH = "order.orderId.max.length";
    public static final String CUSTOMER_ID_MIN_LENGTH = "order.customerId.min.length";
    public static final String CUSTOMER_ID_MAX_LENGTH = "order.customerId.max.length";
    public static final String FIRST_NAME_MIN_LENGTH = "order.fistName.min.length";
    public static final String FIRST_NAME_MAX_LENGTH = "order.fistName.max.length";
    public static final String LAST_NAME_MIN_LENGTH = "order.lastName.min.length";
    public static final String LAST_NAME_MAX_LENGTH = "order.lastName.max.length";

    private OrderErrorCode() {
    }


}

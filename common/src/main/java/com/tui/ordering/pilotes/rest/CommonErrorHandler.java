package com.tui.ordering.pilotes.rest;


import com.tui.ordering.pilotes.exception.BusinessValidationException;
import com.tui.ordering.pilotes.exception.FieldValidationException;
import com.tui.ordering.pilotes.exception.InternalErrorException;
import com.tui.ordering.pilotes.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class CommonErrorHandler {

  private static final String DEFAULT_DETAIL = "internalError";

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    List<String> fields = new ArrayList<>();
    for (ObjectError objectError : exception.getBindingResult().getAllErrors()) {
      fields.add(objectError.getDefaultMessage());
    }
    return buildResponseEntity(exception, HttpStatus.UNPROCESSABLE_ENTITY, "fieldError", fields);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
    return buildResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_DETAIL);
  }

  @ExceptionHandler(InternalErrorException.class)
  public ResponseEntity<ErrorResponse> handleInternalErrorException(
      InternalErrorException exception) {
    return buildResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_DETAIL);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
    return buildResponseEntity(exception, HttpStatus.NOT_FOUND, exception.getMessage());
  }

  @ExceptionHandler(BusinessValidationException.class)
  public ResponseEntity<ErrorResponse> handleBusinessValidationException(
      BusinessValidationException exception) {
    return buildResponseEntity(exception, HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
  }

  @ExceptionHandler(FieldValidationException.class)
  public ResponseEntity<ErrorResponse> handleFieldValidationException(
      FieldValidationException exception) {
    return buildResponseEntity(
        exception, HttpStatus.UNPROCESSABLE_ENTITY, "fieldValidation", exception.getMessages());
  }

  private ResponseEntity<ErrorResponse> buildResponseEntity(
      Exception exception, HttpStatus httpStatus, String errorDetail) {
    return buildResponseEntity(exception, httpStatus, errorDetail, null);
  }

  private ResponseEntity<ErrorResponse> buildResponseEntity(
      Exception exception, HttpStatus httpStatus, String errorDetail, List<String> fields) {
    showExceptionLog(exception, httpStatus);
    return new ResponseEntity<>(buildErrorResponse(httpStatus, errorDetail, fields), httpStatus);
  }

  private ErrorResponse buildErrorResponse(
      HttpStatus httpStatus, String errorDetail, List<String> fields) {
    return ErrorResponse.builder()
        .timestamp(Instant.now())
        .status(httpStatus.value())
        .error(httpStatus.getReasonPhrase())
        .detail(errorDetail)
        .fields(fields)
        .build();
  }

  private void showExceptionLog(Exception exception, HttpStatus httpStatus) {
    if (httpStatus.is5xxServerError()) {
      log.error("Exception: ", exception);
    } else {
      log.warn("Exception: ", exception);
    }
  }
}

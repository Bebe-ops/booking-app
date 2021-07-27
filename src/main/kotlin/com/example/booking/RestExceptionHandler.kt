package com.example.booking

import com.example.booking.entities.BookingNotFoundException
import com.example.booking.entities.CustomerNotFoundException
import com.example.booking.entities.HotelNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class RestExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = "Malformed JSON request"
        return buildResponseEntity(ApiError(HttpStatus.BAD_REQUEST, error, ex))
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = "Server error happened"
        return buildResponseEntity(ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex))
    }

    @ExceptionHandler(value = [(BookingNotFoundException::class)])
    fun handleBookingNotFound(ex: BookingNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponseEntity(ApiError(HttpStatus.NOT_FOUND, "Booking not found", ex))
    }

    @ExceptionHandler(value = [(CustomerNotFoundException::class)])
    fun handleCustomerNotFound(ex: CustomerNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponseEntity(ApiError(HttpStatus.NOT_FOUND, "Employee not found", ex))
    }

    @ExceptionHandler(value = [(HotelNotFoundException::class)])
    fun handleHotelNotFound(ex: HotelNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponseEntity(ApiError(HttpStatus.NOT_FOUND, "Employee not found", ex))
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<Any> {
        return ResponseEntity(apiError, apiError.status)
    }
}
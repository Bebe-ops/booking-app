package com.example.booking.controllers

import com.example.booking.entities.Booking
import com.example.booking.entities.BookingPayload
import com.example.booking.services.BookingService
import org.springframework.web.bind.annotation.*

@RestController
class BookingController(private val bookingService: BookingService) {

    @GetMapping("/bookings")
    fun getAllBookings(): List<Booking> = bookingService.getAllBookings()

    @GetMapping("/bookings/{id}")
    fun getBookingsById(@PathVariable("id") bookingId: Long): Booking =
            bookingService.getBookingById(bookingId)

    @PostMapping("/bookings")
    fun createBookings(@RequestBody payload: BookingPayload): Booking = bookingService.createBooking(payload)

    @PutMapping("/bookings/{id}")
    fun updateBookingsById(@PathVariable("id") bookingId: Long, @RequestBody payload: BookingPayload): Booking =
            bookingService.updateBookingById(bookingId, payload)

    @DeleteMapping("/bookings/{id}")
    fun deleteBookingsById(@PathVariable("id") bookingId: Long): Unit =
            bookingService.deleteBookingById(bookingId)
}
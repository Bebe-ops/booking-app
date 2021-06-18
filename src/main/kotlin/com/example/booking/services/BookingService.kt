package com.example.booking.services

import com.example.booking.entities.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class BookingService(private val bookingRepository: BookingRepository) {
    @Autowired
    lateinit var hotelRepository: HotelRepository

    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getAllBookings(): List<Booking> = bookingRepository.findAll()

    fun getBookingById(bookingId: Long): Booking = bookingRepository.findById(bookingId)
            .orElseThrow { BookingNotFoundException(HttpStatus.NOT_FOUND, "No matching booking was found") }
    fun createBooking(booking: BookingPayload): Booking {
       return bookingRepository.save(Booking(
                customer = customerRepository.findById(booking.customer_id).orElseThrow { CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching customer was found") },
                hotel = hotelRepository.findById(booking.hotel_id).orElseThrow { HotelNotFoundException(HttpStatus.NOT_FOUND, "No matching Hotel was found") },
                from_date = booking.from_date,
                to_date = booking.to_date
        ))
    }

    fun updateBookingById(bookingId: Long, booking: BookingPayload): Booking {
        return if (bookingRepository.existsById(bookingId)) {
            bookingRepository.save(
                    Booking(
                            customer = customerRepository.findById(booking.customer_id) as Customer,
                            hotel = hotelRepository.findById(booking.hotel_id) as Hotel,
                            from_date = booking.from_date,
                            to_date = booking.to_date
                    )
            )
        } else throw BookingNotFoundException(HttpStatus.NOT_FOUND, "No matching booking was found")
    }

    fun deleteBookingById(bookingId: Long) {
        return if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId)
        } else throw BookingNotFoundException(HttpStatus.NOT_FOUND, "No matching booking was found")
    }
}
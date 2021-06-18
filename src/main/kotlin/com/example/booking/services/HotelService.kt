package com.example.booking.services

import com.example.booking.entities.*
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class HotelService(private val hotelRepository: HotelRepository) {
    fun getAllHotels(): List<Hotel> = hotelRepository.findAll()

    fun getHotelById(hotelId: Long): Hotel = hotelRepository.findById(hotelId)
            .orElseThrow { HotelNotFoundException(HttpStatus.NOT_FOUND, "No matching Hotel was found") }
    fun createHotel(payload: HotelPayload): Hotel {
        return hotelRepository.save(Hotel(
                id = 0,
                bookings = listOf<Booking>(),
                name = payload.name,
                address = payload.address,
                addedAt =  payload.addedAt
        ))
    }

    fun updateHotelById(hotelId: Long, hotel: Hotel): Hotel {
        return if (hotelRepository.existsById(hotelId)) {
            hotelRepository.save(
                    Hotel(
                            id = hotel.id,
                            name = hotel.name,
                            address = hotel.address,
                            addedAt = hotel.addedAt,
                            bookings = listOf<Booking>()
                    )
            )
        } else throw HotelNotFoundException(HttpStatus.NOT_FOUND, "No matching hotel was found")
    }

    fun deleteHotelById(hotelId: Long) {
        return if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId)
        } else throw HotelNotFoundException(HttpStatus.NOT_FOUND, "No matching Hotel was found")
    }
}
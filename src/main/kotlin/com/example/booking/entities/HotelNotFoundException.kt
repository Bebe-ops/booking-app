package com.example.booking.entities

import org.springframework.http.HttpStatus

class HotelNotFoundException(status: HttpStatus, message: String): Exception(message) {

}

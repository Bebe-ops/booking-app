package com.example.booking.entities

import org.springframework.http.HttpStatus

class CustomerNotFoundException(status: HttpStatus, message: String): Exception(message) {

}

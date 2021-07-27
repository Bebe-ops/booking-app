package com.example.booking

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.util.*

class ApiError(var status: HttpStatus, var message: String, var debugMessage: String) {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    lateinit var timestamp: LocalDateTime

    constructor(status: HttpStatus, message: String) : this(status, message, "") {
        this.timestamp = LocalDateTime.now()
    }

    constructor(status: HttpStatus, ex: Throwable) : this(status, "", ex.localizedMessage) {
        this.timestamp = LocalDateTime.now()
    }

    constructor(status: HttpStatus, message: String, ex: Throwable) : this(status, message, ex.localizedMessage) {
        this.timestamp = LocalDateTime.now()
    }
}
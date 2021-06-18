package com.example.booking.entities

import java.util.*

data class BookingPayload(val hotel_id: Long, val customer_id: Long, var from_date: Date = Date(),
                          var to_date: Date = Date())
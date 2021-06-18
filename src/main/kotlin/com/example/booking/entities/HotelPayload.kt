package com.example.booking.entities

import java.time.LocalDateTime

data class HotelPayload(val name: String, val address: String, val addedAt: LocalDateTime)
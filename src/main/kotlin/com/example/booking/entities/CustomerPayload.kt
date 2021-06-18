package com.example.booking.entities

import java.util.*

data class CustomerPayload(val userName: String,
                           val firstName: String,
                           val middleName: String,
                           val lastName: String,
                           val emailId: String,
                           val dayOfBirth: Date)
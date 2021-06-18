package com.example.booking.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val bookings: List<Booking>,
        @Column(name = "user_name", unique = true, nullable = false)
        val userName: String,
        @Column(name = "first_name", nullable = false)
        val firstName: String,
        @Column(name = "middle_name", nullable = true)
        val middleName: String?,
        @Column(name = "last_name", nullable = false)
        val lastName: String,
        @Column(name = "email_address", nullable = false)
        val emailId: String,
        @Column(name = "day_of_birth", nullable = false)
        val dayOfBirth: Date
)
package com.example.booking.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "hotel")
data class Hotel(
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    val bookings: List<Booking>,
    var name: String,
    var address: String,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @GeneratedValue
    var id: Long? = null)
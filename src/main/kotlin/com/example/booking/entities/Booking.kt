package com.example.booking.entities

import com.fasterxml.jackson.annotation.JsonProperty
import jdk.nashorn.internal.objects.annotations.Getter
import jdk.nashorn.internal.objects.annotations.Setter
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "booking")
data class Booking(
        @ManyToOne
        @JoinColumn(name = "hotel_id")
        val hotel: Hotel,
        @ManyToOne
        @JoinColumn(name = "customer_id")
        val customer: Customer,
        var from_date: Date = Date(),
        var to_date: Date = Date(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long? = null)
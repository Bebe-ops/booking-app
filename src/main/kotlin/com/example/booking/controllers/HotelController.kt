package com.example.booking.controllers

import com.example.booking.entities.Hotel
import com.example.booking.entities.HotelPayload
import com.example.booking.services.HotelService

import org.springframework.web.bind.annotation.*

@RestController
class HotelController(private val hotelService: HotelService) {

    @GetMapping("/hotels")
    fun getHotels(): List<Hotel> = hotelService.getAllHotels()

    @GetMapping("/hotels/{id}")
    fun getHotelId(@PathVariable("id") hotelId: Long): Hotel =
            hotelService.getHotelById(hotelId)

    @PostMapping("/hotels")
    fun createHotel(@RequestBody payload: HotelPayload): Hotel = hotelService.createHotel(payload)

    @PutMapping("/hotels/{id}")
    fun updateHotelById(@PathVariable("id") hotelId: Long, @RequestBody payload: Hotel): Hotel =
            hotelService.updateHotelById(hotelId, payload)

    @DeleteMapping("/hotels/{id}")
    fun deleteHotelById(@PathVariable("id") hotelId: Long): Unit =
            hotelService.deleteHotelById(hotelId)
}
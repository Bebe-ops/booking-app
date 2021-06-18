package com.example.booking

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookingApplication

fun main(args: Array<String>) {
	runApplication<BookingApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}

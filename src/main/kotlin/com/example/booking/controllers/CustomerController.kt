package com.example.booking.controllers

import com.example.booking.entities.Customer
import com.example.booking.entities.CustomerPayload
import com.example.booking.services.CustomerService

import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/customers")
    fun getAllCustomers(): List<Customer> = customerService.getAllCustomers()

    @GetMapping("/customers/{id}")
    fun getCustomersById(@PathVariable("id") customerId: Long): Customer =
            customerService.getCustomersById(customerId)

    @PostMapping("/customers")
    fun createCustomer(@RequestBody payload: CustomerPayload): Customer = customerService.createCustomer(payload)

    @PutMapping("/customers/{id}")
    fun updateCustomerById(@PathVariable("id") customerId: Long, @RequestBody payload: Customer): Customer =
            customerService.updateCustomerById(customerId, payload)

    @DeleteMapping("/customers/{id}")
    fun deleteCustomersById(@PathVariable("id") customerId: Long): Unit =
            customerService.deleteCustomersById(customerId)
}
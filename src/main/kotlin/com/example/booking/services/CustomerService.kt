package com.example.booking.services

import com.example.booking.entities.*

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getAllCustomers(): List<Customer> = customerRepository.findAll()

    fun getCustomersById(customerId: Long): Customer = customerRepository.findById(customerId)
            .orElseThrow { CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching customer was found") }
    fun createCustomer(payload: CustomerPayload): Customer{
        return customerRepository.save(Customer(
                id = 0,
                bookings = listOf<Booking>(),
                userName = payload.userName,
                firstName = payload.firstName,
                middleName = payload.middleName,
                lastName = payload.lastName,
                emailId = payload.emailId,
                dayOfBirth = payload.dayOfBirth
        ))
    }

    fun updateCustomerById(customerId: Long, customer: Customer): Customer {
        return if (customerRepository.existsById(customerId)) {
            customerRepository.save(
                    Customer(
                            id = customer.id,
                            bookings = listOf<Booking>(),
                            userName = customer.userName,
                            firstName = customer.firstName,
                            middleName = customer.middleName,
                            lastName = customer.lastName,
                            emailId = customer.emailId,
                            dayOfBirth = customer.dayOfBirth
                    )
            )
        } else throw CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching customer was found")
    }

    fun deleteCustomersById(customerId: Long) {
        return if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId)
        } else throw CustomerNotFoundException(HttpStatus.NOT_FOUND, "No matching customer was found")
    }
}
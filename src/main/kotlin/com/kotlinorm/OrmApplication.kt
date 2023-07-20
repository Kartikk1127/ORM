package com.kotlinorm

import com.kotlinorm.service.UserService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrmApplication

fun main(args: Array<String>) {
    val context = runApplication<OrmApplication>(*args)
    val userService = context.getBean(UserService::class.java)

    // Save a new user
    userService.saveUser("John Doe", 30)

    // Retrieve users over a certain age and print their details
    val usersOver18 = userService.getUsersOverAge(18)
    for (user in usersOver18) {
        println("Name: ${user.name}, Age: ${user.age}")
    }
}

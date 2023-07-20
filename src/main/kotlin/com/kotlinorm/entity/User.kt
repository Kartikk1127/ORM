package com.kotlinorm.entity

import jakarta.persistence.*

@Entity
@Table(name = "app_user")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val age: Int
)

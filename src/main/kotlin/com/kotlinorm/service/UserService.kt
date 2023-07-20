package com.kotlinorm.service

import com.kotlinorm.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
interface UserRepository : CrudRepository<User, Long>{
    fun findByAgeGreaterThanEqual(age: Int): List<User>
}

@Service
class UserService(private val userRepository: UserRepository) {
    fun saveUser(name: String, age: Int) {
        val user = User(name = name, age = age)
        userRepository.save(user)
    }

    fun getUsersOverAge(age: Int): List<User> {
        return userRepository.findByAgeGreaterThanEqual(age)
    }
}

package com.example.kotlinspringbootassignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.orm.hibernate5.LocalSessionFactoryBean

@SpringBootApplication
class KotlinSpringbootAssignmentApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinSpringbootAssignmentApplication>(*args)
        }
    }
//    fun main(args: Array<String>) {
//        runApplication<KotlinSpringbootAssignmentApplication>(*args)
//    }
}


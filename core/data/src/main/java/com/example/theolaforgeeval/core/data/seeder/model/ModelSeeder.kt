package com.example.theolaforgeeval.core.data.seeder.model

import java.util.Date

data class RuleMock(val id: Int, val label: String)

data class UserMock(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val email: String,
    val password: String,
    val photo: ByteArray = ByteArray(0),
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val ruleId: Int? = null
)

data class SpaceTypeMock(val id: Int, val label: String)

data class SpaceMock(
    val id: Int,
    val name: String,
    val description: String,
    val photo: ByteArray = ByteArray(0),
    val maxCapacity: Int,
    val isActive: Boolean = true,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val spaceTypeId: Int
)

data class OptionMock(val id: Int, val label: String)

data class SpaceOptionMock(val id: Int, val spaceId: Int, val optionId: Int)

data class BookingMock(
    val id: Int,
    val start: Date,
    val end: Date,
    val peopleCount: Int,
    val status: Boolean,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val spaceId: Int,
    val userId: Int
)

data class AttendeeMock(
    val id: Int,
    val bookingId: Int,
    val userId: Int
)

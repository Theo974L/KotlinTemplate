package com.example.theolaforgeeval.core.data.seeder

import com.example.theolaforgeeval.core.data.seeder.model.AttendeeMock
import com.example.theolaforgeeval.core.data.seeder.model.BookingMock
import com.example.theolaforgeeval.core.data.seeder.model.OptionMock
import com.example.theolaforgeeval.core.data.seeder.model.RuleMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceOptionMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceTypeMock
import com.example.theolaforgeeval.core.data.seeder.model.UserMock
import java.util.Calendar
import java.util.Date
import kotlin.random.Random

object ModelsSeeder {

    // Compteurs pour l'auto-increment
    private var ruleCounter = 0
    private var userCounter = 0
    private var spaceTypeCounter = 0
    private var spaceCounter = 0
    private var optionCounter = 0
    private var spaceOptionCounter = 0
    private var bookingCounter = 0
    private var attendeeCounter = 0

    fun generateRules(): List<RuleMock> = listOf(
        RuleMock(id = ++ruleCounter, label = "Admin"),
        RuleMock(id = ++ruleCounter, label = "User")
    )

    fun generateUsers(rules: List<RuleMock>, count: Int = 10): List<UserMock> {
        val UserMockGenerated = (1..count).map {
            val rule = rules.random()
            UserMock(
                id = ++userCounter,
                lastName = "Last$it",
                firstName = "First$it",
                email = "user$it@example.com",
                password = "password$it",
                ruleId = rule.id
            )
        }

        val user =
            UserMock(
                id = 1000,
                lastName = "1",
                firstName = "Client",
                email = "1",
                password = "1",
                ruleId = rules.find { it.label == "User" }?.id
            )

        val userAdmin =
            UserMock(
                id = 1001,
                lastName = "2",
                firstName = "Admin",
                email = "2",
                password = "2",
                ruleId = rules.find { it.label == "Admin" }?.id
            )

        return UserMockGenerated + user + userAdmin

    }

    fun generateSpaceTypes(): List<SpaceTypeMock> = listOf(
        SpaceTypeMock(id = ++spaceTypeCounter, label = "Salle de cours"),
        SpaceTypeMock(id = ++spaceTypeCounter, label = "Bureau"),
        SpaceTypeMock(id = ++spaceTypeCounter, label = "Amphithéatre")

        )

    fun generateSpaces(spaceTypes: List<SpaceTypeMock>, count: Int = 10): List<SpaceMock> =
        (1..count).map {
            val type = spaceTypes.random()
            SpaceMock(
                id = ++spaceCounter,
                name = "Space $it",
                description = "Description of Space $it",
                maxCapacity = 5 + it,
                spaceTypeId = type.id
            )
        }

    fun generateOptions(): List<OptionMock>
    {
        val listOptionMock = listOf(
            OptionMock(1, "Grand écran"),
            OptionMock(2, "Tableau blanc"),
            OptionMock(3, "Prises"),
            OptionMock(4, "Télé"),
            OptionMock(5, "Cafetière"),
            OptionMock(6, "Tableau mobile"),
            OptionMock(7, "Vidéoprojecteur"),
            OptionMock(8, "Enceintes"),
            OptionMock(9, "Téléviseur"),
            OptionMock(10, "Câble HDMI"),
            OptionMock(11, "Paperboard"),
            OptionMock(12, "Wifi"),
            OptionMock(14, "Sonorisation"),
            OptionMock(15, "Micros"),
            OptionMock(16, "Ordinateurs fixes"),
            OptionMock(17, "Imprimante"),
            OptionMock(18, "Écran plat"),
            OptionMock(19, "Écran tactile"),
            OptionMock(20, "Écrans")
        )
        return listOptionMock
    }


    fun generateSpaceOptions(spaces: List<SpaceMock>, options: List<OptionMock>): List<SpaceOptionMock> =
        spaces.flatMap { space ->
            options.shuffled().take(3).map { option ->
                SpaceOptionMock(
                    id = ++spaceOptionCounter,
                    spaceId = space.id,
                    optionId = option.id
                )
            }
        }

    fun generateBookings(spaces: List<SpaceMock>, users: List<UserMock>, count: Int = 200): List<BookingMock> =
        (1..count).map {
            val space = spaces.random()
            val user = users.random()

            val start = randomTimeSlot()

            // On calcule end = start + 1h ou 2h
            val calendar = Calendar.getInstance()
            calendar.time = start
            calendar.add(Calendar.HOUR_OF_DAY, Random.nextInt(1, 3)) // 1 ou 2h
            val end = calendar.time

            BookingMock(
                id = ++bookingCounter,
                start = start,
                end = end,
                peopleCount = (1..space.maxCapacity).random(),
                status = true,
                createdAt = Date(),
                updatedAt = Date(),
                spaceId = space.id,
                userId = user.id
            )

        }

    fun generateAttendees(bookings: List<BookingMock>, users: List<UserMock>): List<AttendeeMock> =
        bookings.flatMap { booking ->
            users.shuffled().take((1..booking.peopleCount).random()).map { user ->
                AttendeeMock(
                    id = ++attendeeCounter,
                    bookingId = booking.id,
                    userId = user.id
                )
            }
        }

    fun randomTimeSlot(): Date {
        val calendar = Calendar.getInstance()

        // Jour dans les 5 prochains jours
        val dayOffset = Random.nextInt(0, 6) // 0 à 5
        calendar.add(Calendar.DAY_OF_YEAR, dayOffset)

        // Liste des horaires fixes
        val hoursList = (8..17).toList()
        val chosenHour = hoursList.random()

        // Reset heures/minutes/secondes
        calendar.set(Calendar.HOUR_OF_DAY, chosenHour)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        return calendar.time
    }
}

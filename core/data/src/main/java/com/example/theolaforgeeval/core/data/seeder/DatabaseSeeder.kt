package com.example.theolaforgeeval.core.data.seeder

import com.example.theolaforgeeval.core.data.seeder.model.AttendeeMock
import com.example.theolaforgeeval.core.data.seeder.model.BookingMock
import com.example.theolaforgeeval.core.data.seeder.model.OptionMock
import com.example.theolaforgeeval.core.data.seeder.model.RuleMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceOptionMock
import com.example.theolaforgeeval.core.data.seeder.model.SpaceTypeMock
import com.example.theolaforgeeval.core.data.seeder.model.UserMock


object DatabaseSeeder {

    lateinit var rules: List<RuleMock>
    lateinit var users: List<UserMock>
    lateinit var spaceTypes: List<SpaceTypeMock>
    lateinit var spaces: List<SpaceMock>
    lateinit var options: MutableList<OptionMock>
    lateinit var spaceOptions: List<SpaceOptionMock>
    lateinit var bookings: List<BookingMock>
    lateinit var attendees: List<AttendeeMock>

    fun seed() {
        rules = ModelsSeeder.generateRules()
        users = ModelsSeeder.generateUsers(rules)
        spaceTypes = ModelsSeeder.generateSpaceTypes()
        spaces = ModelsSeeder.generateSpaces(spaceTypes)
        options = ModelsSeeder.generateOptions().toMutableList()
        spaceOptions = ModelsSeeder.generateSpaceOptions(spaces, options)

        // ici on appelle generateBookings qui retourne une liste
        bookings = ModelsSeeder.generateBookings(spaces, users)

        attendees = ModelsSeeder.generateAttendees(bookings, users)
    }

}

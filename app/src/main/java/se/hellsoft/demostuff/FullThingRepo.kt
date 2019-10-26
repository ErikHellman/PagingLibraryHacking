package se.hellsoft.demostuff

import androidx.annotation.WorkerThread

data class FullThing(
    val id: Int,
    val name: String,
    val subStuff: List<Stuff>,
    val childThings: List<FullThing>
)

data class Stuff(
    val id: Int,
    val displayName: String,
    val role: Role,
    val age: Int
)

enum class Role {
    Author, Narrator, Illustrator
}

class FullThingRepo {
    @WorkerThread
    fun loadFullThing(id: Int): FullThing {
        return FullThing(1, "", emptyList(), emptyList()) //
    }
}
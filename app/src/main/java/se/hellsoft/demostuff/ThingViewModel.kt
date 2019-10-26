package se.hellsoft.demostuff

import androidx.lifecycle.ViewModel
import androidx.paging.toLiveData

class ThingViewModel(private val thingDao: ThingDao, private val thingRepo: FullThingRepo) : ViewModel() {
    // Loads paged list and converts each item synchronously - SLOW
    val fullThings = thingDao.basicThings()
        .map { thingRepo.loadFullThing(it.id) }
        .toLiveData(pageSize = 50)

    // Load just the basic things - Faster, but needs lazy loading in each item
    val basicThings = thingDao.basicThings()
        .toLiveData(pageSize = 50)

    // Convert from BasicThing to FullThing
    suspend fun convertThing(basicThing: BasicThing): FullThing =
        thingRepo.loadFullThing(basicThing.id)
}
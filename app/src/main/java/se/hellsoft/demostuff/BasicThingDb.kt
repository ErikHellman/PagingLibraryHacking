package se.hellsoft.demostuff

import androidx.paging.DataSource
import androidx.room.*

@Entity(tableName = "basic_thing")
data class BasicThing(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
)

@Dao
interface ThingDao {
    @Query("SELECT * FROM basic_thing")
    fun basicThings(): DataSource.Factory<Int, BasicThing>
}
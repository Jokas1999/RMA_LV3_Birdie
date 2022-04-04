package room

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.lv3_zadatak.data.BirdDao
import com.example.lv3_zadatak.model.Bird

@Database(
    entities = [Bird::class],
    version = 2,
    exportSchema = false

)

@TypeConverters(BirdConverter::class)
abstract class BirdDatabase :RoomDatabase(){
    abstract fun getBirdDao() : BirdDao

    companion object{

        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE: BirdDatabase? = null

        fun getDatabase(context: Context): BirdDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): BirdDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BirdDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }


    }
}



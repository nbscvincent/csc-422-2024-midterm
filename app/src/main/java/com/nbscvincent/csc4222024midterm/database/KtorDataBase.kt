package com.nbscvincent.csc4222024midterm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nbscvincent.csc4222024midterm.data.dao.UserProfileDao
import com.nbscvincent.csc4222024midterm.model.UserProfile

@Database(entities = [UserProfile::class,], version = 1, exportSchema = true)
abstract class KtorDatabase : RoomDatabase() {
    abstract fun UserProfileDao(): UserProfileDao

    companion object {
        @Volatile
        private var Instance: KtorDatabase? = null
        fun getDatabase(context: Context): KtorDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KtorDatabase::class.java,
                    "ktor_database"
                )
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
package com.learning.formfilling.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learning.formfilling.data.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "app_db"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,
                    DATABASE_NAME).build()
                INSTANCE =instance
                instance
            }
        }
    }
}
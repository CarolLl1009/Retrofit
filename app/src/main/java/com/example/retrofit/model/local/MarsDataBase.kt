package com.example.retrofit.model.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MarsEntity::class], version = 1)
abstract class MarsDataBase : RoomDatabase() {

    abstract fun getMarsDao(): MarsDao

    companion object {
        @Volatile
        private var INSTANCE : MarsDataBase? = null

        fun getDataBase(context: Context) : MarsDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MarsDataBase::class.java,
                        "mars_db")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
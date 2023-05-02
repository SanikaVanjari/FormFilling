package com.learning.formfilling.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learning.formfilling.data.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("select * from user")
    fun allUsers(): List<User>

    @Query("delete from user where id=:id")
    fun deleteUser(id: Int): Int

    @Query("select * from user where id=:id")
    fun getSingleUser(id: Int): User
}
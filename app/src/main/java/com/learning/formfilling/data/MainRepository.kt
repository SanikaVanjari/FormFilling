package com.learning.formfilling.data

import com.learning.formfilling.data.db.AppDatabase

class MainRepository(database: AppDatabase) {
    var userTable = database.userDao()

    suspend fun insertUser(user: User) = userTable.addUser(user)

    suspend fun deleteUser(id:Int) = userTable.deleteUser(id)

    suspend fun getAllUsers() = userTable.allUsers()

    suspend fun getSingleUser(id:Int) = userTable.getSingleUser(id)


}
package com.learning.formfilling.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user", indices = [Index(value = ["first_name", "last_name"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "phone_no")
    val phoneNo: Int,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "state")
    val state: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "pincode")
    val pincode: Int,

    )

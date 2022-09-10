package com.apjake.codetestmovielist.local.entity.converter

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<Int>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<Int> = Gson().fromJson(value, Array<Int>::class.java).toList()

}
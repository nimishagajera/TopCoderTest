package com.app.test.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.test.model.Row.Companion.TABLE_NAME

/**
 * Data class for Database entity and Serialization.
 */
@Entity(tableName = TABLE_NAME)
data class Row (
    @PrimaryKey
    var id: Int? = 0,
    var title: String ?= null,
    var description: String ?= null,
    var imageHref: String ?= null
){
    companion object {
        const val TABLE_NAME = "data_test"
    }
}

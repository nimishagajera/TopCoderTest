package com.app.test.model

import com.google.gson.annotations.SerializedName

data class DataResponse(
    val title: String,
    @SerializedName("rows")
    val row: List<Row>
)


data class Row (
    val title: String,
    val description: String,
    val imageHref: String
)

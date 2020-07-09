package com.app.test.model

import com.google.gson.annotations.SerializedName

data class DataResponse (
    var title: String ?= null,
    @SerializedName("rows")
    var row: List<Row> ?= null
)
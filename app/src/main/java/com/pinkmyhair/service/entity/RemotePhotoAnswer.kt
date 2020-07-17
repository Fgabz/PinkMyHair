package com.pinkmyhair.service.entity

import com.google.gson.annotations.SerializedName

data class RemotePhotoAnswer(
    @field:SerializedName("b64_output")
    var base64Image: String
)
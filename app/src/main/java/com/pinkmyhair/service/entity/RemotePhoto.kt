package com.pinkmyhair.service.entity

import com.google.gson.annotations.SerializedName

data class RemotePhoto(
    @field:SerializedName("b64_img")
    var base64Image: String
)
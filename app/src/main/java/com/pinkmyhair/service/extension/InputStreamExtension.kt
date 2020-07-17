package com.pinkmyhair.service.extension

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

val InputStream.bytes: ByteArray
    get() {
        var len: Int
        var size = 8192
        var bytes: ByteArray

        if (this is ByteArrayInputStream) {
            size = available()
            bytes = ByteArray(size)
            read(bytes, 0, size)
        } else {
            val bos = ByteArrayOutputStream()
            bytes = ByteArray(size)

            len = read(bytes, 0, size)
            while (len != -1) {
                bos.write(bytes, 0, len)
                len = read(bytes, 0, size)
            }
            bytes = bos.toByteArray()
        }

        return bytes
    }
package com.freedman.funregistrationform

import android.widget.Spinner
import java.io.Serializable

data class Information(
    val title: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: Number,
    var password: String
) : Serializable
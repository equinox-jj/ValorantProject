package com.valorantproject.core.common.extension

import android.graphics.Color

fun String.parseHexColor() = Color.parseColor("#${this.dropLast(2)}")
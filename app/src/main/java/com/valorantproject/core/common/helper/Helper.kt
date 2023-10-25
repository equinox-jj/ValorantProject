package com.valorantproject.core.common.helper

import android.graphics.Color

fun parseHexColor(color: String): Int = Color.parseColor("#${color.dropLast(2)}")
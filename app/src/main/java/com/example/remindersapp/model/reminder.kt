package com.example.remindersapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Reminder(
    @StringRes val day: Int,
    @StringRes val text: Int,
    @DrawableRes val imageRes: Int
)
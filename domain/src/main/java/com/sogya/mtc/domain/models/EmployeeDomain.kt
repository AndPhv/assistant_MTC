package com.sogya.mtc.domain.models

import android.widget.ImageView


data class EmployeeDomain(
    val imageEmployee: Int,
    val fullName: String,
    val jobTitle: String,
    val email: String,
    val phone: String,
    val phoneAdd: String,
    val audience: String
)
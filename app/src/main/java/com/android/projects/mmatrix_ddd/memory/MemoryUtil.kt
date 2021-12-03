package com.android.projects.mmatrix_ddd.memory

import java.util.*

object MemoryUtil {
    fun formatFileSize(size: Long): String {
        if (size <= 0) return ""
        val formater = Formatter()
        return when {
            size < 1024 -> size.toString() + "B"
            size < 1024 * 1024 -> {
                formater.format("%.2f KB", size / 1024f).toString()
            }
            size < 1024 * 1024 * 1024 -> {
                formater.format("%.2f MB", size / 1024f / 1024f).toString()
            }
            else -> {
                formater.format("%.2f GB", size / 1024f / 1024f / 1024f).toString()
            }
        }
    }
}
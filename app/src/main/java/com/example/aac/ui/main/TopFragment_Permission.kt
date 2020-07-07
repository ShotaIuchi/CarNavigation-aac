package com.example.aac.ui.main

import android.content.Context
import androidx.appcompat.app.AlertDialog
import permissions.dispatcher.PermissionRequest

fun showRationaleDialog(
    context: Context,
    request: PermissionRequest,
    message: String
) {
    AlertDialog.Builder(context)
        .setPositiveButton("ok") { _, _ -> request.proceed() }
        .setNegativeButton("ng") { _, _ -> request.cancel() }
        .setMessage(message)
        .show()
}


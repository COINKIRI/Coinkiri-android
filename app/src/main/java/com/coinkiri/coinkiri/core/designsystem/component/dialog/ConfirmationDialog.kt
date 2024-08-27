package com.coinkiri.coinkiri.core.designsystem.component.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Red
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun ConfirmationDialog(
    title: String,
    message: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = title,
                style = CoinkiriTheme.typography.titleLarge
            )
        },
        text = {
            Text(
                text = message,
                style = CoinkiriTheme.typography.titleMedium
            )
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    text = confirmButtonText,
                    color = Red,
                    style = CoinkiriTheme.typography.bodyLarge
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = dismissButtonText,
                    style = CoinkiriTheme.typography.bodyLarge
                )
            }
        },
        containerColor = White
    )
}

@Preview
@Composable
private fun ConfirmationDialogPreView() {
    CoinkiriTheme {
        ConfirmationDialog(
            title = "로그아웃 확인",
            message = "정말 로그아웃 하시겠습니까?",
            confirmButtonText = "확인",
            dismissButtonText = "취소",
            onConfirm = {},
            onDismiss = {}
        )
    }
}

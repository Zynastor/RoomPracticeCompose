package com.zynastor.roompracticecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(modifier = modifier, onDismissRequest = { onEvent(ContactEvent.HideDialog) },
        title = { Text("Add contact") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    },
                    placeholder = { Text("First name") }
                )
                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(it))
                    },
                    placeholder = { Text("Last name") }
                )
                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(it))
                    },
                    placeholder = { Text("Phone number") }
                )
            }
        },
        buttons = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                }) {
                    Text("Save")
                }
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
private fun PreviewDialog(){
    AddContactDialog(state = ContactState(), onEvent = {})
}
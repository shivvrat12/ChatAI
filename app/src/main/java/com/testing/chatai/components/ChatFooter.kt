package com.testing.chatai.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChatFooter(
    onCLick: (String)-> Unit
){
    var inputText by remember {
        mutableStateOf("")
    }
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(10.dp)
    ){
        OutlinedTextField(value = inputText, onValueChange = { inputText=it },
            placeholder = { Text(text = "Enter Your Prompt")},
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray)
        )

        IconButton(onClick = {
            onCLick(inputText)
            inputText = ""
        }) {
            Icon(Icons.Rounded.Send, contentDescription = null,
                modifier = Modifier.size(40.dp).clip(CircleShape).background(Color.Black).padding(8.dp) , tint= Color.White)
        }
    }
}
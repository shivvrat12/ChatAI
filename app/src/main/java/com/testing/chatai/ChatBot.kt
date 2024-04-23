package com.testing.chatai

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.testing.chatai.components.ChatFooter
import com.testing.chatai.components.ChatHeader
import com.testing.chatai.components.ChatList

@Composable
fun ChatBot(
    viewModel:ChatBotVM = viewModel()
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
            ChatHeader()

            Box(modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center) {
                if (viewModel.list.isEmpty()) {
                    Text(text = "Welcome to Generative AI Model \n The App is made by Shiv Vrat")
                } else {
                    ChatList(list = viewModel.list)
                }
            }

            ChatFooter {
            if (it.isNotEmpty()){
                viewModel.sendMessage(it)
            }
            }
    }
}
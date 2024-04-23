package com.testing.chatai

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM: ViewModel() {
    val list = mutableStateListOf<ChatData>()

        private val genAI by lazy {
            GenerativeModel(
                modelName = "gemini-pro",
                apiKey = API_KEY
            )
        }


    fun sendMessage(message: String) = viewModelScope.launch {

        val chat = genAI.startChat()
        list.add(ChatData(message,Sender.User.sender))

        chat.sendMessage(
            content(Sender.User.sender){text(message)}
        ).text?.let {
            list.add(ChatData(it,Sender.AI.sender))
        }
    }
}
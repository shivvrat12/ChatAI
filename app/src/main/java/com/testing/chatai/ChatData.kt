package com.testing.chatai

data class ChatData(
    val message: String,
    val sender : String
)

enum class Sender(val sender: String){
    User("user"),
    AI("AI")
}

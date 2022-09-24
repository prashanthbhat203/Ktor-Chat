package com.example.di

import com.example.data.model.MessageDataSource
import com.example.data.model.MessageDataSourceImplementation
import com.example.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db")
    }

    single<MessageDataSource> {
        MessageDataSourceImplementation(get())
    }

    single {
        RoomController(get())
    }
}
package com.kaza.newsshortsapp.domain.usecases.app_entry

import com.kaza.newsshortsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (private val localUserManger: LocalUserManger) {

    operator fun invoke():Flow<Boolean>{
        return localUserManger.readAppEntry()
    }
}
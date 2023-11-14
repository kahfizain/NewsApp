package com.kaza.newsshortsapp.domain.usecases.app_entry

import com.kaza.newsshortsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class SaveAppEntry (private val localUserManger: LocalUserManger){

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}
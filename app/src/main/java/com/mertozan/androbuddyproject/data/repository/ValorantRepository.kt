package com.mertozan.androbuddyproject.data.repository

import com.mertozan.androbuddyproject.common.ResponseState
import com.mertozan.androbuddyproject.common.toValorantModelList
import com.mertozan.androbuddyproject.data.model.ValorantModel
import com.mertozan.androbuddyproject.data.source.RemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ValorantRepository {

    fun getAllCharacter(): Flow<ResponseState<List<ValorantModel>>> {
        return flow {
            emit(ResponseState.Loading)
            val response = RemoteSource().getAllAgents().body()?.data
            emit(ResponseState.Success(response!!.toValorantModelList()))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    fun getCharacter(characterUuid: String): Flow<ResponseState<List<ValorantModel>>> {
        return flow {
            emit(ResponseState.Loading)
            val response = RemoteSource().getAgentById(characterUuid).body()?.data
            emit(ResponseState.Success(response!!.toValorantModelList()))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

}
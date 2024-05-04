package com.mertozan.androbuddyproject.data.source

import com.mertozan.androbuddyproject.data.dto.ValorantResponse
import com.mertozan.androbuddyproject.data.remote.RetrofitObject.apiService
import retrofit2.Response

class RemoteSource {

    suspend fun getAllAgents() : Response<ValorantResponse> = apiService.getAllAgents()

    suspend fun getAgentById(agentUuid : String) : Response<ValorantResponse> {
        return apiService.getAgentById(agentUuid)
    }

}
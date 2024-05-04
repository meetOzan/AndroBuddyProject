package com.mertozan.androbuddyproject.data.remote

import com.mertozan.androbuddyproject.data.dto.ValorantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantApi {

    @GET("agents")
    suspend fun getAllAgents() : Response<ValorantResponse>

    @GET("agents/{agentUuid}")
    suspend fun getAgentById(@Path("agentUuid") agentUuid: String) : Response<ValorantResponse>

}
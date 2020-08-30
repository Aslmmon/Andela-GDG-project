package com.example.pluralsightcourse.data.api

import com.example.pluralsightcourse.data.model.LeadersResponse
import retrofit2.http.GET

interface MainLeadersApi {
    @GET("/api/hours")
    suspend fun getLearningLeaders(): LeadersResponse

    @GET("/api/skilliq")
    suspend fun getSkillIQLeaders(): LeadersResponse
}
package com.example.pluralsightcourse.data.repo

import com.example.pluralsightcourse.data.api.GoogleFormApi
import com.example.pluralsightcourse.data.api.MainLeadersApi

class LeadersRepo(var api: MainLeadersApi,var googleFormApi: GoogleFormApi) {
    suspend fun getLearningLeaders() = api.getLearningLeaders()

    suspend fun getSkilledLeaders() = api.getSkillIQLeaders()

    suspend fun submit(name:String,email:String,lastName:String,linkToProject:String) = googleFormApi.submitProject(name =name ,emailAddress =email ,lastName =lastName ,linkToProject =linkToProject )

}
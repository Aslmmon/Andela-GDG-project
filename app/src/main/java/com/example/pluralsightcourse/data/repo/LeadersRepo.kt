package com.example.pluralsightcourse.data.repo

import com.example.pluralsightcourse.data.api.MainLeadersApi

class LeadersRepo(var api: MainLeadersApi) {
    suspend fun getLearningLeaders() = api.getLearningLeaders()

    suspend fun getSkilledLeaders() = api.getSkillIQLeaders()

}
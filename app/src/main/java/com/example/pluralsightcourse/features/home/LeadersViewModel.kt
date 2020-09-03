package com.example.pluralsightcourse.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pluralsightcourse.common.base.BaseViewModel
import com.example.pluralsightcourse.data.model.LeadersResponse
import com.example.pluralsightcourse.data.repo.LeadersRepo

class LeadersViewModel(var leadersRepo: LeadersRepo) : BaseViewModel() {

    private val _leaders = MutableLiveData<LeadersResponse>()
    val leaders: LiveData<LeadersResponse> get() = _leaders


    fun getLeaders() {
        getData({ leadersRepo.getLearningLeaders() }, _leaders)
    }

    fun getSkilledLeaders() {
        getData({ leadersRepo.getSkilledLeaders() }, _leaders)
    }
}
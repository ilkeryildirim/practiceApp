package com.ilkeryildirim.vitrinova.api

import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel
import com.ilkeryildirim.vitrinova.utils.ApiConstants
import retrofit2.http.GET


interface VitrinovaApi {
    @GET(ApiConstants.Endpoints.DISCOVER)
    suspend fun getDiscoverData(): ArrayList<DiscoverModel>
}


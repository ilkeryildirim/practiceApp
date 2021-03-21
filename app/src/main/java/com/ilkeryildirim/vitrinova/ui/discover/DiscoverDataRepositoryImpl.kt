package com.ilkeryildirim.vitrinova.ui.discover

import com.ilkeryildirim.vitrinova.api.VitrinovaApi
import com.ilkeryildirim.vitrinova.api.VitrinovaApiResult
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel
import javax.inject.Inject

class DiscoverDataRepositoryImpl @Inject constructor(private val vitrinovaApi: VitrinovaApi) : DiscoverDataRepository {

    override suspend fun getDiscoverData(): VitrinovaApiResult<ArrayList<DiscoverModel>> {
        return try {
            val response = vitrinovaApi.getDiscoverData()
            VitrinovaApiResult.Success(response)
        } catch (e: Exception) {
            VitrinovaApiResult.Error(e.localizedMessage)
        }
    }

}
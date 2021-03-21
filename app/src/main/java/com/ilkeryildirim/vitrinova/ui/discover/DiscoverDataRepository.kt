package com.ilkeryildirim.vitrinova.ui.discover

import com.ilkeryildirim.vitrinova.api.VitrinovaApiResult
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel

interface DiscoverDataRepository {
    suspend fun getDiscoverData() : VitrinovaApiResult<ArrayList<DiscoverModel>>
}
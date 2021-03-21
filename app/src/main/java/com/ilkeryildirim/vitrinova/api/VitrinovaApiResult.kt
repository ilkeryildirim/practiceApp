package com.ilkeryildirim.vitrinova.api

sealed class VitrinovaApiResult<out T : Any> {
  data class Success<out T : Any>(val data: T) : VitrinovaApiResult<T>()
  data class Error(val message: String?, val statusCode: Int? = null) : VitrinovaApiResult<Nothing>()
}
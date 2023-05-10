package com.books.app.service.impl

import com.books.app.service.ConfigurationService
import com.books.app.utils.trace
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.tasks.await

class ConfigurationServiceImpl :ConfigurationService {

    private val remoteConfig
        get() = Firebase.remoteConfig

    init {
//        if (BuildConfig.RELEASE) {
//            remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
//        }

        val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 0 }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    override suspend fun fetchConfiguration(): Boolean =
        trace(FETCH_CONFIG_TRACE) { remoteConfig.fetchAndActivate().await() }

    override val jsonData: String
        get() = remoteConfig[JSON_DATA_KEY].asString()

    override val detailsCarousel: String
        get() = remoteConfig[DETAILS_CAROUSEL_KEY].asString()

    companion object {
        private const val JSON_DATA_KEY = "json_data"
        private const val DETAILS_CAROUSEL_KEY = "details_carousel"
        private const val FETCH_CONFIG_TRACE = "fetchConfig"
    }
}
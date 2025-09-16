package com.frogobox.kickstart.domain.source.quran.repository

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AyatModel
import com.frogobox.kickstart.domain.model.SurahModel
import com.frogobox.kickstart.domain.source.quran.QuranDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class QuranRepositoryImpl @Inject constructor(
    private val dataSource: QuranDataSource,
) : QuranRepository {

    override fun getSurahs(surah: String?): Flow<Resource<MutableList<SurahModel>>> {
        return dataSource.getSurahs(surah).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: mutableListOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override fun getAyats(surah: String): Flow<Resource<MutableList<AyatModel>>> {
        return dataSource.getAyats(surah).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: mutableListOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

}
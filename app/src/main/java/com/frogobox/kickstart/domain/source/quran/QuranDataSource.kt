package com.frogobox.kickstart.domain.source.quran

import android.content.Context
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.ModelAyat
import com.frogobox.kickstart.domain.model.ModelSurah
import com.frogobox.kickstart.util.RawParser
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Singleton
class QuranDataSource @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    fun getSurahs(): Flow<Resource<MutableList<ModelSurah>>> =
        flow {
            try {
                emit(Resource.Loading())
                val response = RawParser.surah(context)
                if (response.isEmpty()) {
                    emit(Resource.Error("Data not found"))
                } else {
                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)


    fun getAyats(surah: String): Flow<Resource<MutableList<ModelAyat>>> =
        flow {
            try {
                emit(Resource.Loading())
                val response = RawParser.ayat(context).filter { it.surah == surah }.toMutableList()
                if (response.isEmpty()) {
                    emit(Resource.Error("Data not found"))
                } else {
                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

}
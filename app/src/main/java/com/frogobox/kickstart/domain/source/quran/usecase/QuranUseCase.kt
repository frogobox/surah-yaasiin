package com.frogobox.kickstart.domain.source.quran.usecase

import android.content.Context
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.ModelAyat
import com.frogobox.kickstart.domain.model.ModelSurah
import kotlinx.coroutines.flow.Flow

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface QuranUseCase {

    fun getSurahs(): Flow<Resource<MutableList<ModelSurah>>>

    fun getAyats(surah: String): Flow<Resource<MutableList<ModelAyat>>>

}
package com.frogobox.kickstart.domain.source.quran.usecase

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AyatModel
import com.frogobox.kickstart.domain.model.SurahModel
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

    fun getSurahs(surah: String? = null): Flow<Resource<MutableList<SurahModel>>>

    fun getAyats(surah: String): Flow<Resource<MutableList<AyatModel>>>

}
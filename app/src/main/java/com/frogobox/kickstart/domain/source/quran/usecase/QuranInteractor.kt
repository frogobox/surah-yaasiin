package com.frogobox.kickstart.domain.source.quran.usecase

import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AyatModel
import com.frogobox.kickstart.domain.model.SurahModel
import com.frogobox.kickstart.domain.source.quran.repository.QuranRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class QuranInteractor @Inject constructor(
    private val repository: QuranRepository,
) : QuranUseCase {

    override fun getSurahs(surah: String?): Flow<Resource<MutableList<SurahModel>>> {
        return repository.getSurahs(surah)
    }

    override fun getAyats(surah: String): Flow<Resource<MutableList<AyatModel>>> {
        return repository.getAyats(surah)
    }

}
package com.frogobox.kickstart.domain.source.quran.usecase

import android.content.Context
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.ModelAyat
import com.frogobox.kickstart.domain.model.ModelSurah
import com.frogobox.kickstart.domain.source.quran.repository.QuranRepository
import dagger.hilt.android.qualifiers.ApplicationContext
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

    override fun getSurahs(): Flow<Resource<MutableList<ModelSurah>>> {
        return repository.getSurahs()
    }

    override fun getAyats(surah: String): Flow<Resource<MutableList<ModelAyat>>> {
        return repository.getAyats(surah)
    }

}
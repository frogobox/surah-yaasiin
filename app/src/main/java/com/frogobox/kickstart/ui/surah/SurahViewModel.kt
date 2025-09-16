package com.frogobox.kickstart.ui.surah

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frogobox.kickstart.common.base.BaseViewModel
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.ModelSurah
import com.frogobox.kickstart.domain.source.quran.usecase.QuranUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@HiltViewModel
class SurahViewModel @Inject constructor(
    private val useCase: QuranUseCase,
) : BaseViewModel() {

    private var _surahState = MutableLiveData<Resource<MutableList<ModelSurah>>>()
    var surahState: LiveData<Resource<MutableList<ModelSurah>>> = _surahState

    fun getSurahs() {
        viewModelScope.launch {
            useCase.getSurahs().collect {
                _surahState.postValue(it)
            }
        }
    }

}
package com.frogobox.kickstart.ui.ayat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frogobox.kickstart.common.base.BaseViewModel
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.domain.model.AyatModel
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
class AyatViewModel @Inject constructor(
    private val useCase: QuranUseCase,
) : BaseViewModel() {

    private var _ayatState = MutableLiveData<Resource<MutableList<AyatModel>>>()
    var ayatState: LiveData<Resource<MutableList<AyatModel>>> = _ayatState

    fun getAyats(surah: String) {
        viewModelScope.launch {
            useCase.getAyats(surah).collect {
                _ayatState.postValue(it)
            }
        }
    }

}
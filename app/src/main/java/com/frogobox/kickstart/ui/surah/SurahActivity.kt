package com.frogobox.kickstart.ui.surah

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.databinding.ActivitySurahBinding
import com.frogobox.kickstart.domain.model.ModelSurah
import com.frogobox.kickstart.ui.ayat.AyatActivity
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.visible
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@AndroidEntryPoint
class SurahActivity : BaseActivity<ActivitySurahBinding>() {

    private val viewModel: SurahViewModel by viewModels()

    private val surahAdapter: SurahAdapter by lazy {
        SurahAdapter()
    }

    override fun setupViewBinding(): ActivitySurahBinding {
        return ActivitySurahBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)
        viewModel.getSurahs()
        binding.apply {
            rv.adapter = surahAdapter
            rv.layoutManager =
                LinearLayoutManager(this@SurahActivity, LinearLayoutManager.VERTICAL, false)


            surahAdapter.setOnItemCallBack(object : OnItemClickCallback {
                override fun onItemClick(
                    view: View,
                    objects: Any,
                    position: Int?,
                ) {
                    (objects as ModelSurah).let {
                        startActivityResultExt(AyatActivity.createIntent(this@SurahActivity, it))
                    }
                }
            })

        }
    }

    override fun setupViewModel() {
        super.setupViewModel()
        viewModel.surahState.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.progressView.gone()
                    showToast(it.message.toString())
                }

                is Resource.Loading -> {
                    binding.progressView.visible()
                }

                is Resource.Success -> {
                    binding.progressView.gone()
                    it.data?.let { items ->
                        surahAdapter.setItem(items)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onClearDisposable()
    }

}
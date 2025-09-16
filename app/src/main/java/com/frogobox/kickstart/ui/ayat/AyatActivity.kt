package com.frogobox.kickstart.ui.ayat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.kickstart.common.base.BaseActivity
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.common.callback.Resource
import com.frogobox.kickstart.databinding.ActivityAyatBinding
import com.frogobox.kickstart.domain.model.AyatModel
import com.frogobox.kickstart.domain.model.SurahModel
import com.frogobox.sdk.ext.getExtraExt
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.showToast
import com.frogobox.sdk.ext.toJson
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
class AyatActivity : BaseActivity<ActivityAyatBinding>() {

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"

        fun createIntent(context: Context, data: SurahModel): Intent {
            return Intent(context, AyatActivity::class.java).apply {
                putExtra(EXTRA_DATA, data.toJson())
            }
        }

        fun launch(context: Context, data: SurahModel) {
            context.startActivity(createIntent(context, data))
        }

    }

    private val viewModel : AyatViewModel by viewModels()

    private val AyatAdapter: AyatAdapter by lazy {
        AyatAdapter()
    }

    override fun setupViewBinding(): ActivityAyatBinding {
        return ActivityAyatBinding.inflate(layoutInflater)
    }

    override fun onCreateExt(savedInstanceState: Bundle?) {
        super.onCreateExt(savedInstanceState)

        setupDetailActivity("Yaa Siin")
        viewModel.getAyats("36")

        binding.apply {
            rv.adapter = AyatAdapter
            rv.layoutManager =
                LinearLayoutManager(this@AyatActivity, LinearLayoutManager.VERTICAL, false)


            AyatAdapter.setOnItemCallBack(object : OnItemClickCallback {
                override fun onItemClick(
                    view: View,
                    objects: Any,
                    position: Int?,
                ) {
                    (objects as AyatModel).let {

                    }
                }
            })

        }
    }

    override fun setupViewModel() {
        super.setupViewModel()
        viewModel.ayatState.observe(this) {
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
                        AyatAdapter.setItem(items)
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
package com.frogobox.kickstart.ui.surah

import android.view.LayoutInflater
import android.view.ViewGroup
import com.frogobox.kickstart.common.base.BaseAdapter
import com.frogobox.kickstart.common.base.BaseViewHolder
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.databinding.ItemSurahBinding
import com.frogobox.kickstart.domain.model.ModelSurah

/**
 * Created by faisalamircs on 10/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class SurahAdapter : BaseAdapter<ModelSurah, SurahAdapter.SurahHolder>() {

    override fun bindVH(
        holder: SurahHolder,
        position: Int,
    ) {
        holder.bindData(asyncListDiffer.currentList[position], position)
    }

    override fun adapterAreItemsTheSame(
        oldItem: ModelSurah,
        newItem: ModelSurah,
    ): Boolean {
        return oldItem.surah == newItem.surah
    }

    override fun adapterAreContentsTheSame(
        oldItem: ModelSurah,
        newItem: ModelSurah,
    ): Boolean {
        return oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SurahHolder {
        return SurahHolder(
            binding = ItemSurahBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClickCallback = onItemClickCallback
        )
    }

    inner class SurahHolder(
        private val binding: ItemSurahBinding,
        private val onItemClickCallback: OnItemClickCallback? = null,
    ) : BaseViewHolder<ModelSurah>(binding.root) {

        override fun bindData(model: ModelSurah, position: Int?) {
            binding.apply {
                rowSurah.text = model.surah
                rowAyat.text = model.ayat
                rowTerjemahanSurah.text = model.terjemahanIndonesia
                rowJumlahAyat.text = model.jumlahAyat.toString()

                root.setOnClickListener { v ->
                    onItemClickCallback?.onItemClick(v, model, position)
                }
            }
        }
    }
}
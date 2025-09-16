package com.frogobox.kickstart.ui.ayat

import android.view.LayoutInflater
import android.view.ViewGroup
import com.frogobox.kickstart.common.base.BaseAdapter
import com.frogobox.kickstart.common.base.BaseViewHolder
import com.frogobox.kickstart.common.callback.OnItemClickCallback
import com.frogobox.kickstart.databinding.ItemAyatBinding
import com.frogobox.kickstart.domain.model.ModelAyat

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class AyatAdapter : BaseAdapter<ModelAyat, AyatAdapter.AyatHolder>() {

    override fun bindVH(
        holder: AyatHolder,
        position: Int,
    ) {
        holder.bindData(asyncListDiffer.currentList[position], position)
    }

    override fun adapterAreItemsTheSame(
        oldItem: ModelAyat,
        newItem: ModelAyat,
    ): Boolean {
        return oldItem.ayat == newItem.ayat
    }

    override fun adapterAreContentsTheSame(
        oldItem: ModelAyat,
        newItem: ModelAyat,
    ): Boolean {
        return oldItem == newItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AyatHolder {
        return AyatHolder(
            binding = ItemAyatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClickCallback = onItemClickCallback
        )
    }

    inner class AyatHolder(
        private val binding: ItemAyatBinding,
        private val onItemClickCallback: OnItemClickCallback? = null,
    ) : BaseViewHolder<ModelAyat>(binding.root) {

        override fun bindData(model: ModelAyat, position: Int?) {
            binding.apply {
                rowAyat.text = model.ayat
                rowArabic.text = model.arab
                rowTerjemahan.text = model.terjemahanIndonesia

                root.setOnClickListener { v ->
                    onItemClickCallback?.onItemClick(v, model, position)
                }
            }
        }
    }
}
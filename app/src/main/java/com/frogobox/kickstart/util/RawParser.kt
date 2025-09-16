package com.frogobox.kickstart.util

import android.content.Context
import com.frogobox.kickstart.R
import com.frogobox.kickstart.common.ext.getRawResources
import com.frogobox.kickstart.domain.model.AyatModel
import com.frogobox.kickstart.domain.model.SurahModel


/**
 * Created by jonesrandom on 2/22/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */
object RawParser {

    fun ayat(context: Context): MutableList<AyatModel> {
        val reader = context.getRawResources(R.raw.ayat)
        val ayatList: MutableList<AyatModel> = ArrayList()

        var rawAyat: String?

        while ((reader.readLine().also { rawAyat = it }) != null) {
            val rawAyats: Array<String?> =
                rawAyat!!.split("//".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            ayatList.add(
                AyatModel(
                    rawAyats[0],
                    rawAyats[1],
                    rawAyats[2],
                    rawAyats[3],
                    rawAyats[4]
                )
            )
        }

        return ayatList
    }

    fun surah(context: Context): MutableList<SurahModel> {
        val reader = context.getRawResources(R.raw.surah)
        val surahList: MutableList<SurahModel> = ArrayList()

        var rawSurah: String?
        while ((reader.readLine().also { rawSurah = it }) != null) {
            val rawSurahs: Array<String> =
                rawSurah!!.split("//".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (rawSurahs.size < 5) {
                continue
            }
            surahList.add(
                SurahModel(
                    rawSurahs[0],
                    rawSurahs[1],
                    rawSurahs[2],
                    rawSurahs[3],
                    rawSurahs[4],
                )
            )
        }

        return surahList
    }
}

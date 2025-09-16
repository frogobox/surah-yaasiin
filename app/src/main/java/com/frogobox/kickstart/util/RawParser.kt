package com.frogobox.kickstart.util

import android.content.Context
import com.frogobox.kickstart.R
import com.frogobox.kickstart.common.ext.getRawResources
import com.frogobox.kickstart.domain.model.ModelAyat
import com.frogobox.kickstart.domain.model.ModelSurah


/**
 * Created by jonesrandom on 2/22/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */
object RawParser {

    fun ayat(context: Context): MutableList<ModelAyat> {
        val reader = context.getRawResources(R.raw.ayat)
        val ayatList: MutableList<ModelAyat> = ArrayList()

        var rawAyat: String?

        while ((reader.readLine().also { rawAyat = it }) != null) {
            val rawAyats: Array<String?> =
                rawAyat!!.split("//".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            ayatList.add(
                ModelAyat(
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

    fun surah(context: Context): MutableList<ModelSurah> {
        val reader = context.getRawResources(R.raw.surah)
        val surahList: MutableList<ModelSurah> = ArrayList()

        var rawSurah: String?
        while ((reader.readLine().also { rawSurah = it }) != null) {
            val rawSurahs: Array<String> =
                rawSurah!!.split("//".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (rawSurahs.size < 5) {
                continue
            }
            surahList.add(
                ModelSurah(
                    rawSurahs[0],
                    rawSurahs[1],
                    rawSurahs[2],
                    rawSurahs[3],
                    rawSurahs[4]
                )
            )
        }

        return surahList
    }
}

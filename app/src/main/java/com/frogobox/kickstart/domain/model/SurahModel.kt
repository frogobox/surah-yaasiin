package com.frogobox.kickstart.domain.model


data class SurahModel(
    var surah: String? = null,
    var ayat: String? = null,
    var terjemahanIndonesia: String? = null,
    var terjemahanEnglish: String? = null,
    var jumlahAyat: String? = null,
)


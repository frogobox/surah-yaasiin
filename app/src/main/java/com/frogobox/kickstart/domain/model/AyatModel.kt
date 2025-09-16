package com.frogobox.kickstart.domain.model


data class AyatModel(
    val surah: String? = null,
    val ayat: String? = null,
    val arab: String? = null,
    var terjemahan: String? = null,
    var terjemahanIndonesia: String? = null,
    var terjemahanEnglish: String? = null,
)

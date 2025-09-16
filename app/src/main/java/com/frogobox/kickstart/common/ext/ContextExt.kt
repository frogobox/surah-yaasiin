package com.frogobox.kickstart.common.ext

import android.content.Context
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by faisalamircs on 16/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


fun Context.getRawResources(res: Int): BufferedReader {
    val streamReader: InputStream = resources.openRawResource(res)
    return BufferedReader(InputStreamReader(streamReader))
}
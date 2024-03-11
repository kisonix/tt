/*
 * Copyright 2022 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keygenqt.tvgram.extensions

import android.content.Context
import android.graphics.Bitmap
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

/**
 * Loading image
 */
fun Context.loadingImage(
    path: String?,
    round: Boolean = false,
    loading: (Bitmap) -> Unit
) {
    ImageLoader(this).enqueue(ImageRequest.Builder(this)
        .data(path)
        .apply { if (round) transformations(CircleCropTransformation()) }
        .allowHardware(false)
        .target { loading.invoke(it.toBitmap()) }
        .build())
}
package org.test.hackernews.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable
@JsonClass(generateAdapter = true)
data class NewsResponse(
    val hits: List<Hits> = listOf<Hits>(),
    val nbHits: Int,
    val page: Int,
    val nbPages: Int,
    val hitsPerPage: Int,
    val exhaustiveNbHits: Boolean,
    val query: String,
    val params: String,
    val processingTimeMS: Int
)
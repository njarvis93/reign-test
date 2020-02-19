package org.test.hackernews.models

import com.squareup.moshi.JsonClass
import java.io.Serializable
@JsonClass(generateAdapter = true)
data class NewsResponse(
    val hits: List<Hits> = listOf<Hits>(),
    val nbHits: Int?=0,
    val page: Int?=0,
    val nbPages: Int?=0,
    val hitsPerPage: Int?=0,
    val exhaustiveNbHits: Boolean?=false,
    val query: String?="",
    val params: String?="",
    val processingTimeMS: Int?=0
):Serializable
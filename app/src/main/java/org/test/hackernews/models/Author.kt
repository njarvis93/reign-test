package org.test.hackernews.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Author (
	val value : String?="Unknow",
	val matchLevel : String?="",
	val matchedWords : List<String>?= listOf()
)
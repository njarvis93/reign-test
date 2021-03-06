package org.test.hackernews.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoryTitle (

	val value : String?="",
	val matchLevel : String?="",
	val matchedWords : List<String>?= listOf()
)
package org.test.hackernews.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentText (
	val value : String?="",
	val matchLevel : String?="",
	val fullyHighlighted : Boolean?=false,
	val matchedWords : List<String>?= listOf()
)
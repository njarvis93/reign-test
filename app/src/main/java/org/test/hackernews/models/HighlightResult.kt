package org.test.hackernews.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HighlightResult (
	val author : Author?=null,
	@Json(name ="comment_text") val commentText : CommentText ? = null,
	@Json(name ="story_title") val storyTitle : StoryTitle ?= null,
	@Json(name ="story_url") val storyUrl : StoryUrl ?= null
)
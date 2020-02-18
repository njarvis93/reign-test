package org.test.hackernews.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Hits (
	val created_at : String,
	@Json(name="title") val title : String ? = "",
	@Json(name="url") val url : String ? = "",
	@Json(name="author") val author : String ? = "",
	@Json(name="points") val points : String ? = "",
	@Json(name="story_text") val storyText : String ? ="",
	@Json(name="comment_text") val commentText : String ? = "",
	@Json(name="num_comments") val numComments : Int ? = 0,
	@Json(name="story_id") val storyId : Int ? = -1,
	@Json(name="story_title") val storyTitle : String ? = "",
	@Json(name="story_url") val storyUrl : String ? ="",
	@Json(name="parent_id") val parentId : Int ? =-1,
	val created_at_i : Int,
	val _tags : List<String>,
	val objectID : Int,
	@Json(name = "_highlightResult")val highlightResult : HighlightResult

):Serializable
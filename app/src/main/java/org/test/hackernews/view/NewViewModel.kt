package org.test.hackernews.view

import androidx.lifecycle.MutableLiveData
import org.test.hackernews.base.BaseViewModel
import org.test.hackernews.models.Hits
import org.test.hackernews.utils.Converter

class NewViewModel:BaseViewModel() {

    private val title  = MutableLiveData<String>()
    private val createdAt = MutableLiveData<String>()
    private val author = MutableLiveData<String>()
    private val url = MutableLiveData<String>()

    fun bind(news:Hits){
        title.value =  news.storyTitle
        createdAt.value = Converter.convertLongToTime(news.created_at_i.toLong())
        author.value = news.author
        url.value = news.storyUrl
    }

    fun  getTitle():MutableLiveData<String>{
        return title
    }

    fun getCreatedAt():MutableLiveData<String>{
        return createdAt
    }

    fun getAuthor():MutableLiveData<String>{
        return author
    }

    fun getURL():MutableLiveData<String>{
        return url
    }
}
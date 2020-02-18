package org.test.hackernews.view

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.test.hackernews.R
import org.test.hackernews.base.BaseViewModel
import org.test.hackernews.models.Hits
import org.test.hackernews.network.ApiError
import org.test.hackernews.network.INewsService
import javax.inject.Inject

class NewsListViewModel:BaseViewModel(){
    @Inject
    lateinit var newsService: INewsService

    private lateinit var subscription: Disposable

    val newsListAdapter: NewsListAdapter = NewsListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadNews() }

    init{
        loadNews()
    }

    private fun loadNews(){
        subscription = newsService.getHackerNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveNewsListStart() }
            .doOnTerminate { onRetrieveNewsListFinish() }
            .subscribe(
                { result -> onRetrieveNewsListSuccess(result.hits) },
                { error -> onRetrieveNewsListError(error) }
            )
    }

    private fun onRetrieveNewsListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveNewsListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveNewsListSuccess(newsList:List<Hits>){
        newsListAdapter.updateNewsList(newsList)
    }

    private fun onRetrieveNewsListError(error:Throwable){
        Log.e("fail", error.localizedMessage+"__"+error.cause+"__"+error.message)
        errorMessage.value = R.string.news_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
package org.test.hackernews.view

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_new.*
import org.test.hackernews.R

class NewDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_new)
        var url:String = intent.getStringExtra("newUrl")?:"empty url"
        Log.e("URL:", url)
        webview_page.loadUrl(url)

    }
}
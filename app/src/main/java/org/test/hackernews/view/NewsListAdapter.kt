package org.test.hackernews.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.test.hackernews.R
import org.test.hackernews.databinding.ItemNewBinding
import org.test.hackernews.models.Hits

class NewsListAdapter:RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    private lateinit var newsList:List<Hits>
    private lateinit var activity:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemNewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_new, parent, false)
        activity = parent.context
        return ViewHolder(binding, activity)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    fun updateNewsList(newsList:List<Hits>){
        this.newsList= newsList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemNewBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {
        private val viewModel = NewViewModel()
        fun bind(new:Hits){
            viewModel.bind(new)
            binding.viewModel = viewModel
            binding.newCard.setOnClickListener{
                Log.d("Debug", "estoy dando click")
                val intent= Intent(context, NewDetaiilActivity::class.java)
                Log.e("object intent", intent.toString())
                val bundle = intent.extras
                Log.e("Object bundle", bundle.toString())
                bundle!!.putString("newUrl",new.url)
                intent.putExtras(bundle)
                context.startActivity(intent)
            }
        }
    }
}
package dev.bakhita.postcomments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
class PostsRVAdapter(var context: Context, var post: List<Post>):
    RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=PostsViewHolder

            .inflate(LayoutInflater.from(context),parent,false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var posts= post.get(position)
        with(holder.binding){
            tvUserid.text=posts.userId.toString()
            tvId.text=posts.id.toString()
            tvTitle.text=posts.title
            tvBody.text=posts.body

        }
    }

    override fun getItemCount(): Int {
        return post.size

    }
}

class RetrofitViewHolder(var binding:PostsViewHolder):RecyclerView.ViewHolder(binding.root)


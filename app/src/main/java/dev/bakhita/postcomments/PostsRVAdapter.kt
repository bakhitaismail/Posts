package dev.bakhita.postcomments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bakhita.postcomments.databinding.PostBinding

class PostsRVAdapter(var context: Context, var post: List<Post>):
    RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding=PostBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
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
class PostViewHolder(var binding: PostBinding):RecyclerView.ViewHolder(binding.root)


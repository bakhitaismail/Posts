package dev.bakhita.postcomments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bakhita.postcomments.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Comments : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPost(){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPostById(postId)

        request.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post!=null){
                    binding.tvTitles.text=post.title
                    binding.tvBodies.text=post.title
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        })
    }
}
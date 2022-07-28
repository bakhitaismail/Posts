package dev.bakhita.postcomments

data class Post(
    var userId: Int,
    var title:String,
    var id: Int,
    var body:String)

data class Comment(
    var postId: Int,
    var name:String,
    var email:String,
    var body:String)



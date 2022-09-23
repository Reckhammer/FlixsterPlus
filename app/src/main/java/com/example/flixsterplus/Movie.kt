package com.example.flixsterplus

import com.google.gson.annotations.SerializedName

class Movie
{
    @JvmField
    @SerializedName( "title" )
    var title: String? = null

    @JvmField
    @SerializedName( "overview" )
    var description: String? = null

    @SerializedName( "poster_path" )
    var movieImageUrl: String? = null
}
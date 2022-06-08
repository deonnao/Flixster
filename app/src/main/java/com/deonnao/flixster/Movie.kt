package com.deonnao.flixster

import org.json.JSONArray

//represent one movie item
data class Movie(
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
) {
    val posterImageUrl ="https://image.tmdb.org/t/p/w342/$posterPath"

    //will allow us to call methods on the movie class w/o having an instance of movie
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>() //what we will return

            //populate the movie list
            for(i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                //add a movie
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}
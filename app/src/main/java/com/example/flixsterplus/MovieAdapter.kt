package com.example.flixsterplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixsterplus.R.id

class MovieAdapter(
    private val movies : List<Movie>,
    private val mListener : OnListFragmentInteractionListener?
    ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
    {
        val view = LayoutInflater.from( parent.context ).inflate( R.layout.movie, parent, false )
        return MovieViewHolder( view )
    }

    inner class MovieViewHolder( val mView: View ) : RecyclerView.ViewHolder(mView)
    {
        var mItem : Movie? = null
        var mMovieTitle : TextView = mView.findViewById<View>( id.MovieTitle ) as TextView
        var mMovieDescription : TextView = mView.findViewById<View>( id.MovieDescription ) as TextView
        var mMovieImage : ImageView = mView.findViewById<View>( id.MoviePic ) as ImageView

        override fun toString(): String {
            return mMovieTitle.toString() + " " + mMovieDescription.text
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description

        Glide.with( holder.mView )
            .load( "https://image.tmdb.org/t/p/w500${movie.movieImageUrl}" )
            .centerInside()
            .into( holder.mMovieImage )

        holder.mView.setOnClickListener{
            holder.mItem?.let{ movie ->
                mListener?.onItemClick( movie )
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
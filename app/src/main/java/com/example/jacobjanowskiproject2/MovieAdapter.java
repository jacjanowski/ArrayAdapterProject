package com.example.jacobjanowskiproject2;


import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ProjectViewHolder> {


    private Movie[] movies;

    //Assign values for Movie class to our array of Movies
    public MovieAdapter(Movie[] projects) {
        this.movies = projects;
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflate takes our singular item_project.xml item and gives that layout to
        //every item in our array.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);

        return new ProjectViewHolder(view);
    }


    //onBindViewHolder  - applying methods and functions to particular items within our array.
    //In this case, create a clickListener that handles a redirect to YouTube's movie trailer.
    //This is for a simple click.
    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {

        holder.bind(movies[position]);

        //Handle intent to redirect to the movie's trailer link.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri urlstr = Uri.parse((String) holder.movieLink.getText() );
                Intent urlintent = new Intent();
                urlintent.setData(urlstr);
                urlintent.setAction(Intent.ACTION_VIEW);
                view.getContext().startActivity(urlintent);
            }
        });

        //Upon doing a longClick, the user will be displayed a context menu. More on that below.
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                holder.itemView.showContextMenu();

                return true;
            }


        });

        //Create Context Menu for each Movie in the list that is clicked. Once clicked,
        //display that movie's information. That includes a link to the trailer, an IMDb page,
        //and the Rotten Tomatoes director's page. Applies click listener to every item that's clicked.

        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("View information about movie");
                menu.add("View Trailer for " + holder.movieTitle.getText()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    //For Movie link
                    public boolean onMenuItemClick(MenuItem item) {

                        //Create URL intent using the link associated with each Movie.
                        Uri urlstr = Uri.parse((String) holder.movieLink.getText());
                        Intent urlintent = new Intent();
                        urlintent.setData(urlstr);
                        urlintent.setAction(Intent.ACTION_VIEW);
                        holder.itemView.getContext().startActivity(urlintent);
                        return true;
                    }
                });

                //For Movie name
                menu.add("IMDb for " + holder.movieTitle.getText()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        //Create URL intent using the link associated with each Movie.
                        Uri urlstr = Uri.parse((String) holder.wikiMovie.getText());
                        Intent urlintent = new Intent();
                        urlintent.setData(urlstr);
                        urlintent.setAction(Intent.ACTION_VIEW);
                        holder.itemView.getContext().startActivity(urlintent);
                        return true;
                    }
                });

                // For Director name
                menu.add("Rotten Tomatoes for " + holder.movieDirector.getText()).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        //Create URL intent using the link associated with each Movie.
                        Uri urlstr = Uri.parse((String) holder.wikiDirector.getText());
                        Intent urlintent = new Intent();
                        urlintent.setData(urlstr);
                        urlintent.setAction(Intent.ACTION_VIEW);
                        holder.itemView.getContext().startActivity(urlintent);
                        return true;
                    }
                });
            }
        });
    }


    //Extend to RecyclerView.ViewHolder to be able to assign the movie's values to the layout dynamically.
    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        TextView movieTitle;
        TextView movieDirector;
        TextView movieLink;
        TextView wikiMovie;
        TextView wikiDirector;



        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            movieThumbnail = itemView.findViewById(R.id.image_view_project_icon);
            movieTitle = itemView.findViewById(R.id.text_view_project_title);
            movieDirector = itemView.findViewById(R.id.text_view_project_description);
            movieLink = itemView.findViewById(R.id.text_view_link);
            wikiMovie = itemView.findViewById(R.id.text_view_wiki_movie);
            wikiDirector = itemView.findViewById(R.id.text_view_wiki_director);


        }


        //Function that sets the text and images to each movie in the layout.
        public void bind(Movie project) {
            movieLink.setText(project.link);
            movieTitle.setText(project.name);
            movieDirector.setText(project.description);
            movieThumbnail.setImageResource(project.image);
            wikiMovie.setText(project.wikiMovie);
            wikiDirector.setText(project.wikiDirector);

        }



    }


}

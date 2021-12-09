package com.example.jacobjanowskiproject2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Boolean grid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign values from layout to Activity.
        RecyclerView list = findViewById(R.id.recycler_view_projects);
        Button gridView = findViewById(R.id.gridView);




        //Array of movies: consisting of the following:
        //- Movie Name
        //- Director Name
        //- Link to trailer
        //- Link to IMDb
        //-Link to Rotten Tomatoes
        //- Movie Image
        Movie[] projects = {
                new Movie("Casino", "Martin Scorsese", "https://www.youtube.com/watch?v=EJXDMwGWhoA", "https://www.imdb.com/title/tt0112641/?ref_=fn_al_tt_1", "https://www.rottentomatoes.com/celebrity/martin_scorsese", R.drawable.casino),
                new Movie("Taken", "Pierre Morel", "https://www.youtube.com/watch?v=XK9zL0ze9O4","https://www.imdb.com/title/tt0936501/?ref_=nv_sr_srsg_0", "https://www.rottentomatoes.com/celebrity/pierre-morel", R.drawable.taken),
                new Movie("Forrest Gump", "Robert Zemeckis","https://www.youtube.com/watch?v=bLvqoHBptjg","https://www.imdb.com/title/tt0109830/", "https://www.rottentomatoes.com/celebrity/robertzemickis", R.drawable.forrest_gump),
                new Movie("Dirty Harry", "Don Siegel","https://www.youtube.com/watch?v=YgRjIEwMYQ4","https://www.imdb.com/title/tt0066999/?ref_=fn_al_tt_1", "https://www.rottentomatoes.com/celebrity/don_siegel", R.drawable.dirty_harry),
                new Movie("Salt", "Phillip Noyce","https://www.youtube.com/watch?v=QZ40WlshNwU","https://www.imdb.com/title/tt0944835/?ref_=nv_sr_srsg_0", "https://www.rottentomatoes.com/celebrity/phillip_noyce", R.drawable.salt),
                new Movie("I Am Legend", "Francis Lawrence","https://www.youtube.com/watch?v=dtKMEAXyPkg","https://www.imdb.com/title/tt0480249/?ref_=fn_al_tt_1", "https://www.rottentomatoes.com/celebrity/francis_lawrence", R.drawable.legend),
                new Movie("Grease", "Randal Kleiser","https://www.youtube.com/watch?v=qDKo8DNpwOw","https://www.imdb.com/title/tt0077631/?ref_=nv_sr_srsg_0", "https://www.rottentomatoes.com/celebrity/randal_kleiser", R.drawable.grease),
                new Movie("Insidious", "James Wan","https://www.youtube.com/watch?v=zuZnRUcoWos","https://www.imdb.com/title/tt1591095/?ref_=fn_al_tt_1", "https://www.rottentomatoes.com/celebrity/james_wan ", R.drawable.insidious)


        };

        //Create and use adapter. Assign the adapter the values of the 'projects' array made above.
        MovieAdapter adapter = new MovieAdapter(projects);


        //set layout to grid
        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Upon clicking, display the contents as a grid view our linear layout view.
                if (!grid){
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    list.setLayoutManager(gridLayoutManager);
                    grid = true;
                }
                else {
                    list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    grid = false;
                }
            }
        });



        list.setAdapter(adapter);
        registerForContextMenu(list);


    }





}
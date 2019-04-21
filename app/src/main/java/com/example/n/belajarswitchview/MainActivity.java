package com.example.n.belajarswitchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "Mode List";
    private int language = 1;
    private int layout = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        changeLanguage();

    }

    public void changeLanguage() {

        list.clear();
        list.addAll(HeroesData.getListData(language));

        if (layout == 1){
            showRecyclerList();
        }
        else if (layout == 2){
            showRecyclerGrid();
        }
        else {
            showRecyclerCardView();
        }

    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
        listHeroAdapter.setListHero(list);
        rvCategory.setAdapter(listHeroAdapter);
    }

    private void  showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(this);
        gridHeroAdapter.setListHero(list);
        rvCategory.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(this);
        cardViewHeroAdapter.setListHero(list);
        rvCategory.setAdapter(cardViewHeroAdapter);
    }


    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_list:
                setActionBarTitle("Mode List");
                layout = 1;
                showRecyclerList();
                break;

            case R.id.action_grid:
                setActionBarTitle("Mode Grid");
                layout = 2;
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                setActionBarTitle("With CardView");
                layout = 3;
                showRecyclerCardView();
                break;

            case R.id.indonesia:
                language = 1;
                changeLanguage();
                break;

            case R.id.english:
                language = 2;
                changeLanguage();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}


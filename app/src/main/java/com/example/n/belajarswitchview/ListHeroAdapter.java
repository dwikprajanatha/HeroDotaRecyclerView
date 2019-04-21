package com.example.n.belajarswitchview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Hero> listHero;

    private ArrayList<Hero> getListHero() {
        return listHero;
    }

    public void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    public ListHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero,parent,false);

        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {

        holder.tvName.setText(getListHero().get(position).getName());
        holder.tvFrom.setText(getListHero().get(position).getFrom());

        Glide.with(context)
                .load(getListHero().get(position).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailHeroes.class);

                intent.putExtra("hero_name",getListHero().get(position).getName());
                intent.putExtra("hero_bio",getListHero().get(position).getFrom());
                intent.putExtra("hero_pic",getListHero().get(position).getPhoto());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvFrom;
        ImageView imgPhoto;
        ConstraintLayout parent;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            parent = itemView.findViewById(R.id.list_parent);

        }
    }
}

package com.example.transhealthdemo.ui.diet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transhealthdemo.R;
import com.example.transhealthdemo.ui.healthplug.HpActivity;

public class DietRecAdapter extends RecyclerView.Adapter<DietRecAdapter.ViewHolder>{
    View view;
    Context context;

    public DietRecAdapter (Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public DietRecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diet_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietRecAdapter.ViewHolder holder, int position) {
        Resources res = context.getResources();

        String[] allDietTitle = res.getStringArray(R.array.diet_title);
        String[] allDietDesc = res.getStringArray(R.array.diet_desc);
        String[] allDietCat = res.getStringArray(R.array.diet_cat);
        String[] allDietAuthor = res.getStringArray(R.array.diet_auth);
        String[] allDietDate = res.getStringArray(R.array.hp_date);
        int pos;
        for (pos = 0; pos <= 5; pos++){
            holder.dietTextView.setText("Diet  " +String.valueOf(position+1));
            //holder.imageView.setImageResource(R.drawable.ic_hymn_book);
        }

        holder.dietCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "you clicked on " + position,  Toast.LENGTH_SHORT).show();

                Intent gotoHpActivity = new Intent(context, DietActivity.class);
                gotoHpActivity.putExtra("position", position);
                gotoHpActivity.putExtra("allDietTitle", allDietTitle);
                gotoHpActivity.putExtra("allDietDesc", allDietDesc);
                gotoHpActivity.putExtra("allDietCat", allDietCat);
                gotoHpActivity.putExtra("allDietAuthor", allDietAuthor);
                gotoHpActivity.putExtra("allDietDate", allDietDate);
                context.startActivity(gotoHpActivity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView dietCardView;
        TextView dietTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.dietCardView = itemView.findViewById(R.id.diet_cardview);
            this.dietTextView = itemView.findViewById(R.id.diet_no);
        }
    }
}

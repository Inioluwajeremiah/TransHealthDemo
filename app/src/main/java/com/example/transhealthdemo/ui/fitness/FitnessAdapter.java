package com.example.transhealthdemo.ui.fitness;

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

public class FitnessAdapter extends RecyclerView.Adapter<FitnessAdapter.ViewHolder> {
    View view;
    Context context;
    public  FitnessAdapter (Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public FitnessAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessAdapter.ViewHolder holder, int position) {
        Resources res = context.getResources();

        String[] allFitTitle = res.getStringArray(R.array.fit_title);
        String[] allFitDesc = res.getStringArray(R.array.fit_desc);
        String[] allFitCat = res.getStringArray(R.array.fit_cat);
        String[] allFitAuthor = res.getStringArray(R.array.fit_auth);
        String[] allFitDate = res.getStringArray(R.array.fit_date);
        int pos;
        for (pos = 0; pos <= 5; pos++){
            holder.fitTextView.setText("Fitness \n note " +String.valueOf(position+1));
            //holder.imageView.setImageResource(R.drawable.ic_hymn_book);
        }

        holder.fitCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "you clicked on " + position,  Toast.LENGTH_SHORT).show();

                Intent gotoFitnessActivity = new Intent(context, FitnessActivity.class);
                gotoFitnessActivity.putExtra("position", position);
                gotoFitnessActivity.putExtra("allFitTitle", allFitTitle);
                gotoFitnessActivity.putExtra("allFitDesc", allFitDesc);
                gotoFitnessActivity.putExtra("allFitCat", allFitCat);
                gotoFitnessActivity.putExtra("allFitAuthor", allFitAuthor);
                gotoFitnessActivity.putExtra("allFitDate", allFitDate);
                context.startActivity(gotoFitnessActivity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView fitTextView;
        CardView fitCardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fitCardview = itemView.findViewById(R.id.fit_cardview);
            fitTextView = itemView.findViewById(R.id.fit_no);

        }
    }
}

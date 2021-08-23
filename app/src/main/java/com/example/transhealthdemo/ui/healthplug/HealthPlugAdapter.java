package com.example.transhealthdemo.ui.healthplug;

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

import java.util.ArrayList;

public class HealthPlugAdapter extends RecyclerView.Adapter<HealthPlugAdapter.ViewHolder> {

    Context context;

    public Context getContext() {
        return context;
    }

    public ArrayList<HealthPlugArray> healthPlugArrayArrayList;

    public HealthPlugAdapter(Context mcontext) {
        this.context = mcontext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView HptextView;
        public CardView HpcardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.HptextView = itemView.findViewById(R.id.hp_no);
            this.HpcardView = itemView.findViewById(R.id.hp_cardview);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.healthplug_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Resources res = getContext().getResources();

        String[] allHpTitle = res.getStringArray(R.array.hp_title);
        String[] allHpDesc = res.getStringArray(R.array.hp_desc);
        String[] allHpCat = res.getStringArray(R.array.hp_cat);
        String[] allHpAuthor = res.getStringArray(R.array.hp_author);
        String[] allHpDate = res.getStringArray(R.array.hp_date);
        int pos;
        for (pos = 0; pos <= 5; pos++){
            holder.HptextView.setText("Health \n plug " +String.valueOf(position+1));
            //holder.imageView.setImageResource(R.drawable.ic_hymn_book);
        }

        holder.HpcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "you clicked on " + position,  Toast.LENGTH_SHORT).show();

                Intent gotoHpActivity = new Intent(getContext(), HpActivity.class);
                gotoHpActivity.putExtra("position", position);
                gotoHpActivity.putExtra("allHpTitle", allHpTitle);
                gotoHpActivity.putExtra("allHpDesc", allHpDesc);
                gotoHpActivity.putExtra("allHpCat", allHpCat);
                gotoHpActivity.putExtra("allHpAuthor", allHpAuthor);
                gotoHpActivity.putExtra("allHpDate", allHpDate);
                getContext().startActivity(gotoHpActivity);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private void addHealthPlugList(String[] allhealthPlugTitle, String[] allhealthplugDesc, String[] allhealthplugCategory,
                               String[] allhealthplugAuthor, String[] allhealthplugDate) {
        for (int i =0; i< allhealthPlugTitle.length; i++) {
            String HpTitle = allhealthPlugTitle[i];
            String HpDesc = allhealthplugDesc[i];
            String HpCat = allhealthplugCategory[i];
            String HpAuthor = allhealthplugAuthor[i];
            String HpDate = allhealthplugDate[i];
            HealthPlugArray healthPlugArray = new HealthPlugArray(HpTitle, HpDesc, HpCat, HpAuthor, HpDate);
            healthPlugArrayArrayList.add(healthPlugArray);
        }
    }

    //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
}

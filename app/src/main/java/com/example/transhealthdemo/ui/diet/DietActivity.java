package com.example.transhealthdemo.ui.diet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.transhealthdemo.R;

public class DietActivity extends AppCompatActivity {

    ImageButton diet_next_img_btn, diet_prev_img_btn;
    String title, desc, cat, author, date;
    String[] allDietTitle, allDietDesc, allDietCat, allDietAuthor, allDietDate;
    int[] allDietImage = {R.drawable.diet_image1, R.drawable.diet_image2,R.drawable.diet_image3, R.drawable.diet_image4,
            R.drawable.diet_image5};
    int position;
    TextView title_tv, desc_tv, cat_tv, author_tv, date_tv;
    Animation slide_in_right, slide_out_left;
    LinearLayout relativeLayout;
    LinearLayout llheader;
    RelativeLayout bottom_layout;
    ImageView dietImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        diet_next_img_btn = findViewById(R.id.diet_next_btn);
        diet_prev_img_btn = findViewById(R.id.diet_prev_btn);
        title_tv = findViewById(R.id.diet_title);
        desc_tv = findViewById(R.id.diet_desc);
        cat_tv = findViewById(R.id.diet_cat);
        author_tv = findViewById(R.id.diet_author);
        date_tv = findViewById(R.id.diet_date);
        relativeLayout = findViewById(R.id.diet_main_linearlayout);
        llheader = findViewById(R.id.diet_header);
        bottom_layout = findViewById(R.id.diet_bottom_nav_layout);
        dietImageview = findViewById(R.id.diet_imageview);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        allDietTitle = intent.getStringArrayExtra("allDietTitle");
        allDietDesc = intent.getStringArrayExtra("allDietDesc");
        allDietCat = intent.getStringArrayExtra("allDietCat");
        allDietAuthor = intent.getStringArrayExtra("allDietAuthor");
        allDietDate = intent.getStringArrayExtra("allDietDate");

        title_tv.setText(allDietTitle[position]);
        desc_tv.setText(allDietDesc[position]);
        cat_tv.setText(allDietCat[position]);
        author_tv.setText(allDietAuthor[position]);
        date_tv.setText(allDietDate[position]);
        dietImageview.setImageResource(allDietImage[position]);

        if (position == 0) {
            diet_prev_img_btn.setVisibility(View.GONE);
            diet_next_img_btn.setVisibility(View.VISIBLE);
        } else if (position == 4) {
            diet_next_img_btn.setVisibility(View.GONE);
            diet_prev_img_btn.setVisibility(View.VISIBLE);
        } else {
            diet_prev_img_btn.setVisibility(View.VISIBLE);
            diet_next_img_btn.setVisibility(View.VISIBLE);
        }

        diet_next_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position + 1) % allDietTitle.length;

                slide_in_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                relativeLayout.setAnimation(slide_in_right);
                slide_in_right.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();


                title_tv.setText(allDietTitle[position]);
                desc_tv.setText(allDietDesc[position]);
                cat_tv.setText(allDietCat[position]);
                author_tv.setText(allDietAuthor[position]);
                date_tv.setText(allDietDate[position]);
                dietImageview.setImageResource(allDietImage[position]);


                if (position <= 0) {
                    diet_prev_img_btn.setVisibility(View.GONE);
                } else {
                    diet_prev_img_btn.setVisibility(View.VISIBLE);
                }

                if (position >= 4) {
                    diet_next_img_btn.setVisibility(View.GONE);
                }else {
                    diet_prev_img_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        diet_prev_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position - 1) % allDietTitle.length;

//                if (position <= 0) {
//                    prev_img_btn.setVisibility(View.GONE);
//                } else {
//                    prev_img_btn.setVisibility(View.VISIBLE);
//                }
//
//                if (position >= 4) {
//                    next_img_btn.setVisibility(View.GONE);
//                }else {
//                    prev_img_btn.setVisibility(View.VISIBLE);
//                }

                if (position == 0) {
                    diet_prev_img_btn.setVisibility(View.GONE);
                    diet_next_img_btn.setVisibility(View.VISIBLE);
                } else if (position == 4) {
                    diet_next_img_btn.setVisibility(View.GONE);
                    diet_prev_img_btn.setVisibility(View.VISIBLE);
                } else {
                    diet_prev_img_btn.setVisibility(View.VISIBLE);
                    diet_next_img_btn.setVisibility(View.VISIBLE);
                }

                slide_out_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_left);
                relativeLayout.setAnimation(slide_out_left);
                slide_out_left.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();


                title_tv.setText(allDietTitle[position]);
                desc_tv.setText(allDietDesc[position]);
                cat_tv.setText(allDietCat[position]);
                author_tv.setText(allDietAuthor[position]);
                date_tv.setText(allDietDate[position]);
                dietImageview.setImageResource(allDietImage[position]);

            }
        });
    }
}
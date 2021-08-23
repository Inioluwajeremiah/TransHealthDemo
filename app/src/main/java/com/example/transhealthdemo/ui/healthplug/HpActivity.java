package com.example.transhealthdemo.ui.healthplug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transhealthdemo.R;

import java.util.ArrayList;

public class HpActivity extends AppCompatActivity {

    ArrayList<String> hymnsArrayList;
    ImageButton next_img_btn, prev_img_btn;
    String title, desc, cat, author, date;
    String[] allHpTitle, allHpDesc, allHpCat, allHpAuthor, allHpDate;
    int position;
    TextView title_tv, desc_tv, cat_tv, author_tv, date_tv;
    Animation slide_in_right, slide_out_left;
    LinearLayout relativeLayout;
    LinearLayout llheader;
    RelativeLayout bottom_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);

        next_img_btn = findViewById(R.id.hp_next_btn);
        prev_img_btn = findViewById(R.id.hp_prev_btn);
        title_tv = findViewById(R.id.hp_title);
        desc_tv = findViewById(R.id.hp_desc);
        cat_tv = findViewById(R.id.hp_cat);
        author_tv = findViewById(R.id.hp_author);
        date_tv = findViewById(R.id.hp_date);
        relativeLayout = findViewById(R.id.hp_main_linearlayout);
        llheader = findViewById(R.id.hp_header);
        bottom_layout = findViewById(R.id.bottom_nav_layout);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        allHpTitle = intent.getStringArrayExtra("allHpTitle");
        allHpDesc = intent.getStringArrayExtra("allHpDesc");
        allHpCat = intent.getStringArrayExtra("allHpCat");
        allHpAuthor = intent.getStringArrayExtra("allHpAuthor");
        allHpDate = intent.getStringArrayExtra("allHpDate");

        title_tv.setText(allHpTitle[position]);
        desc_tv.setText(allHpDesc[position]);
        cat_tv.setText(allHpCat[position]);
        author_tv.setText(allHpAuthor[position]);
        date_tv.setText(allHpDate[position]);

        if (position == 0) {
            prev_img_btn.setVisibility(View.GONE);
            next_img_btn.setVisibility(View.VISIBLE);
        } else if (position == 4) {
           next_img_btn.setVisibility(View.GONE);
            prev_img_btn.setVisibility(View.VISIBLE);
        } else {
            prev_img_btn.setVisibility(View.VISIBLE);
            next_img_btn.setVisibility(View.VISIBLE);
        }

        next_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position + 1) % allHpTitle.length;

                slide_in_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                relativeLayout.setAnimation(slide_in_right);
                slide_in_right.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();


                title_tv.setText(allHpTitle[position]);
                desc_tv.setText(allHpDesc[position]);
                cat_tv.setText(allHpCat[position]);
                author_tv.setText(allHpAuthor[position]);
                date_tv.setText(allHpDate[position]);

                if (position <= 0) {
                    prev_img_btn.setVisibility(View.GONE);
                } else {
                    prev_img_btn.setVisibility(View.VISIBLE);
                }

                if (position >= 4) {
                    next_img_btn.setVisibility(View.GONE);
                }else {
                    prev_img_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        prev_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position - 1) % allHpTitle.length;

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
                    prev_img_btn.setVisibility(View.GONE);
                    next_img_btn.setVisibility(View.VISIBLE);
                } else if (position == 4) {
                    next_img_btn.setVisibility(View.GONE);
                    prev_img_btn.setVisibility(View.VISIBLE);
                } else {
                    prev_img_btn.setVisibility(View.VISIBLE);
                    next_img_btn.setVisibility(View.VISIBLE);
                }

                slide_out_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_left);
                relativeLayout.setAnimation(slide_out_left);
                slide_out_left.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();


                title_tv.setText(allHpTitle[position]);
                desc_tv.setText(allHpDesc[position]);
                cat_tv.setText(allHpCat[position]);
                author_tv.setText(allHpAuthor[position]);
                date_tv.setText(allHpDate[position]);


            }
        });
    }
}
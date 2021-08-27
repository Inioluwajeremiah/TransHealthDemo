package com.example.transhealthdemo.ui.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transhealthdemo.R;


public class FitnessActivity extends AppCompatActivity {

    ImageButton fit_next_img_btn, fit_prev_img_btn;
    String title, desc, cat, author, date;
    String[] allFitTitle, allFitDesc, allFitCat, allFitAuthor, allFitDate;
    int[] allFitVid = {R.raw.vid1, R.raw.vid2, R.raw.vid3, R.raw.vid4, R.raw.vid5};
    int position;
    TextView fit_title_tv, fit_desc_tv, fit_cat_tv, fit_author_tv, fit_date_tv;
    Animation slide_in_right, slide_out_left;
    LinearLayout relativeLayout;
    LinearLayout llheader;
    RelativeLayout bottom_layout;
    VideoView fit_videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        fit_next_img_btn = findViewById(R.id.fit_next_btn);
        fit_prev_img_btn = findViewById(R.id.fit_prev_btn);
        fit_title_tv = findViewById(R.id.fit_title);
        fit_desc_tv = findViewById(R.id.fit_desc);
        fit_cat_tv = findViewById(R.id.fit_cat);
        fit_author_tv = findViewById(R.id.fit_author);
        fit_date_tv = findViewById(R.id.fit_date);
        relativeLayout = findViewById(R.id.fit_main_linearlayout);
        llheader = findViewById(R.id.fit_header);
        bottom_layout = findViewById(R.id.fit_bottom_nav_layout);
        fit_videoview = findViewById(R.id.fit_videoview);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        allFitTitle = intent.getStringArrayExtra("allFitTitle");
        allFitDesc = intent.getStringArrayExtra("allFitDesc");
        allFitCat = intent.getStringArrayExtra("allFitCat");
        allFitAuthor = intent.getStringArrayExtra("allFitAuthor");
        allFitDate = intent.getStringArrayExtra("allFitDate");

        fit_title_tv.setText(allFitTitle[position]);
        fit_desc_tv.setText(allFitDesc[position]);
        fit_cat_tv.setText(allFitCat[position]);
        fit_author_tv.setText(allFitAuthor[position]);
        fit_date_tv.setText(allFitDate[position]);


        if (position == 0) {
            fit_prev_img_btn.setVisibility(View.GONE);
            fit_next_img_btn.setVisibility(View.VISIBLE);
        } else if (position == 4) {
            fit_next_img_btn.setVisibility(View.GONE);
            fit_prev_img_btn.setVisibility(View.VISIBLE);
        } else {
            fit_prev_img_btn.setVisibility(View.VISIBLE);
            fit_next_img_btn.setVisibility(View.VISIBLE);
        }

        // set mediacontroller
        fit_videoview.setVideoPath("android.resource://" + getPackageName() + "/" + allFitVid[position]);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(fit_videoview);
        fit_videoview.setMediaController(mediaController);
        fit_videoview.requestFocus();
        fit_videoview.start();

        fit_next_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position + 1) % allFitTitle.length;

                slide_in_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                relativeLayout.setAnimation(slide_in_right);
                slide_in_right.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();

                fit_title_tv.setText(allFitTitle[position]);
                fit_desc_tv.setText(allFitDesc[position]);
                fit_cat_tv.setText(allFitCat[position]);
                fit_author_tv.setText(allFitAuthor[position]);
                fit_date_tv.setText(allFitDate[position]);
                fit_videoview.setVideoPath("android.resource://" + getPackageName() + "/" + allFitVid[position]);
                MediaController mediaController = new MediaController(getApplicationContext());
                mediaController.setAnchorView(fit_videoview);
                fit_videoview.setMediaController(mediaController);
                fit_videoview.requestFocus();
                fit_videoview.start();


                if (position <= 0) {
                    fit_prev_img_btn.setVisibility(View.GONE);
                } else {
                    fit_prev_img_btn.setVisibility(View.VISIBLE);
                }

                if (position >= 4) {
                    fit_next_img_btn.setVisibility(View.GONE);
                }else {
                    fit_prev_img_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        fit_prev_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (position - 1) % allFitTitle.length;

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
                    fit_prev_img_btn.setVisibility(View.GONE);
                    fit_next_img_btn.setVisibility(View.VISIBLE);
                } else if (position == 4) {
                    fit_next_img_btn.setVisibility(View.GONE);
                    fit_prev_img_btn.setVisibility(View.VISIBLE);
                } else {
                    fit_prev_img_btn.setVisibility(View.VISIBLE);
                    fit_next_img_btn.setVisibility(View.VISIBLE);
                }

                slide_out_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_left);
                relativeLayout.setAnimation(slide_out_left);
                slide_out_left.setDuration(1000);
                //mediaPlayer = MediaPlayer.create(getApplicationContext(), audio_files[position]);
                llheader.requestFocus();


                fit_title_tv.setText(allFitTitle[position]);
                fit_desc_tv.setText(allFitDesc[position]);
                fit_cat_tv.setText(allFitCat[position]);
                fit_author_tv.setText(allFitAuthor[position]);
                fit_date_tv.setText(allFitDate[position]);
                fit_videoview.setVideoPath("android.resource://" + getPackageName() + "/" + allFitVid[position]);
                MediaController mediaController = new MediaController(getApplicationContext());
                mediaController.setAnchorView(fit_videoview);
                fit_videoview.setMediaController(mediaController);
                fit_videoview.requestFocus();
                fit_videoview.start();

            }
        });
    }
}
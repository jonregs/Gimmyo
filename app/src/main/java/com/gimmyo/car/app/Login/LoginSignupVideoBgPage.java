package com.gimmyo.car.app.Login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.gimmyo.car.app.R;

/**
 * Created by jonegalado on 7/19/17, Gimmyo Project.
 */

public class LoginSignupVideoBgPage extends AppCompatActivity implements View.OnClickListener{

    private VideoView mVideoView;
    //Button gimmyoImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_bg_page_login_signup);

        mVideoView = (VideoView) findViewById(R.id.bgVideoView);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bg_video);

        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        Button loginButton = (Button) findViewById(R.id.gimmyLoginButton);
        loginButton.setOnClickListener(this);

        Button signupButton = (Button) findViewById(R.id.signupGimmyoButton);
        signupButton.setOnClickListener(this);

    }

    /*public void addListenerOnButton() {

        gimmyoImageButton = (Button) findViewById(R.id.gimmyLoginButton);
        gimmyoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginSignupVideoBgPage.this, Login.class);
                startActivity(intent);

                gimmyoImageButton.setFocusableInTouchMode(false);
                gimmyoImageButton.setFocusable(false);
            }
        });

    }*/

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.gimmyLoginButton:
                Intent loginIntent = new Intent(LoginSignupVideoBgPage.this, Login.class);
                startActivity(loginIntent);
                break;
            case R.id.signupGimmyoButton:
                Intent signupIntent = new Intent(LoginSignupVideoBgPage.this, Signup.class);
                startActivity(signupIntent);
                break;
        }
    }
}

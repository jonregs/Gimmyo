package com.gimmyo.car.app.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.gimmyo.car.app.R;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by jonegalado on 7/12/17, Gimmyo Project.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "LoginGimmyo";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //Enable Local Data Store.
        Parse.enableLocalDatastore(this);

        /*
         Parse Login Credentials
         URL: http://ec2-18-220-7-92.us-east-2.compute.amazonaws.com/apps/My%20Bitnami%20Parse%20API/browser/_User
         Login to Parse Server
         username: user
         password: j8yiiNOCeurK
        */

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("8812ae35cb75fe6d52f018ec0a8add5339b999e8")
                .clientKey("dc0190dd5f7ca905b849a6ab18d292c4602dec93")
                .server("http://ec2-18-220-7-92.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );

        Button signinButton = (Button) findViewById(R.id.login_to_gimmyo);
        signinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login_to_gimmyo:
                signIn();

        }

    }

    private void signIn() {
        if(!validate()){
            onSignInFailed();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(Login.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating your account...");
        progressDialog.show();

        new Runnable() {
            @Override
            public void run() {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

                query.getInBackground("lhPdEne3nI", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if (e == null && object != null) {

                            Log.v(TAG, "test");
                            Log.v(TAG, object.getString("username"));
                            Log.v(TAG, Integer.toString(object.getInt("score")));
                        }
                    }
                });
            }
        };
    }

    private void onSignInFailed() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }

    private boolean validate() {
        boolean valid = true;

        EditText userName = (EditText) findViewById(R.id.input_email);
        String _userName = userName.getText().toString();

        EditText password = (EditText) findViewById(R.id.input_password);
        String _password = password.getText().toString();

        if (_userName.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(_userName).matches()){
            userName.setError("enter a valid email address");
            valid = false;
        } else {
            userName.setError(null);
        }

        if (_password.isEmpty() || _password.length() < 4 || password.length() > 15) {
            password.setError("between 4 and 15 alphanumeric characters required");
            valid = false;
        } else {
            password.setError(null);
        }
        return valid;
    }
}

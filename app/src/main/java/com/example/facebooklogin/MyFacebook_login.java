package com.example.facebooklogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.Arrays;

public class MyFacebook_login extends AppCompatActivity {

    CallbackManager callbackManager;
    TextView text;

    private static final String EMAIL = "email";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_facebook_login);
        text=findViewById(R.id.text_facebook);

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions(MyFacebook_login.this, Arrays.asList(
                "email", "public_profile"
                ));


        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {


                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                (object, graphResponse) -> {

                                    if (object != null) {
                                        try {
                                            String name = object.getString("name");
                                            String email = object.getString("email");
                                            String fbUserID = object.getString("id");

                                            Toast.makeText(MyFacebook_login.this, ""+fbUserID
                                                    , Toast.LENGTH_SHORT).show();





                                            // do action after Facebook login success
                                            // or call your API
                                        } catch (JSONException | NullPointerException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                });

                        Bundle parameters = new Bundle();
                        parameters.putString(
                                "fields",
                                "id, name, email");
                        request.setParameters(parameters);
                        request.executeAsync();



                                           }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
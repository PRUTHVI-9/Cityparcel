package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageView;
    TextView username,mail;
    FirebaseAuth auth;
    Button logout;
    GoogleSignInClient googleSignInClient;
    private String TAG=getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.profile);
        username = findViewById(R.id.tv_username);
        mail = findViewById(R.id.tv_mailid);
        logout = findViewById(R.id.logout);
        googleSignInClient = GoogleSignIn.getClient(ProfileActivity.this, GoogleSignInOptions.DEFAULT_SIGN_IN);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        Log.e(TAG, "user: "+user.getDisplayName() );

        username.setText(user.getDisplayName());
        mail.setText(user.getEmail());
        Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(imageView);

//        SharedPreferences preferences = getSharedPreferences("com.google.android.gms.signin",MODE_PRIVATE);
//        String googleAccount = preferences.getString("defaultGoogleSignInAccount","");
//        String googleSignInAccount = preferences.getString("googleSignInAccount:FD35E72C9317A6C5289AE856B15AE249","");
//
//        Log.e(TAG, "onCreate: "+googleAccount );
//        Log.e(TAG, "onCreate: "+googleSignInAccount );
//
//        try {
//            JSONObject googlesigninacount = new JSONObject(googleSignInAccount);
//            String displayName = googlesigninacount.getString("displayName");
//            username.setText(displayName);
//            String photoUrl = googlesigninacount.getString("photoUrl");
//            Glide.with(ProfileActivity.this).load(photoUrl).into(imageView);
//            String Mail = googlesigninacount.getString("Mail");
//            mail.setText(user.getEmail());
//            Log.e(TAG, "onCreate: "+displayName );
//            Log.e(TAG, "onCreate: "+photoUrl );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        if (auth!=null){
//            Glide.with(ProfileActivity.this).load(user.getPhotoUrl()).into(imageView);
//            username.setText(user.getDisplayName());
//            mail.setText(user.getEmail());
//        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        auth.signOut();
                        finish();
                    }
                });
            }
        });

    }
}
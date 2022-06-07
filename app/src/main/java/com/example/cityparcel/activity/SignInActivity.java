package com.example.cityparcel.activity;

import static com.facebook.appevents.UserDataStore.EMAIL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityparcel.CheckoutActivity;
import com.example.cityparcel.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class SignInActivity extends AppCompatActivity {
    SignInButton google_login;
    LoginButton fblogin;
    private FirebaseAuth mAuth;
    GoogleSignInClient googleApiClient;
    private String TAG = getClass().getSimpleName();
    CallbackManager callbackManager;
    Button button;
    TextView app_logo;
    EditText mobile, username;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        google_login = findViewById(R.id.google_login);
        fblogin = findViewById(R.id.fb_login);
        fblogin.setReadPermissions(Arrays.asList(EMAIL));
        callbackManager = CallbackManager.Factory.create();
        button = findViewById(R.id.get_up);
        app_logo = findViewById(R.id.app_logo);
        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        preferences = getSharedPreferences("MyApp", MODE_PRIVATE);
        editor = preferences.edit();

        setTextViewColor(app_logo, getResources().getColor(R.color.violet),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.orangee),
                getResources().getColor(R.color.red));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("username", username.getText().toString());
                editor.putString("mobile", mobile.getText().toString());
                editor.commit();

                Intent intent = new Intent(SignInActivity.this, OtpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //configure fb signin
        fblogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e(TAG, "onSuccess: " + loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.e(TAG, "onCancel: ");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "onError: " + error.toString());
            }
        });
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        // configure google signin
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleApiClient = GoogleSignIn.getClient(SignInActivity.this, gso);
        mAuth = FirebaseAuth.getInstance();


        google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = googleApiClient.getSignInIntent();
                startActivityForResult(intent, 101);
            }
        });
    }

    private void setTextViewColor(TextView app_logo,int...color){
        TextPaint paint = app_logo.getPaint();
        float width = paint.measureText(app_logo.getText().toString());

        Shader shader= new LinearGradient(0,0,width,app_logo.getTextSize(),color,null,Shader.TileMode.CLAMP);
        app_logo.getPaint().setShader(shader);
        app_logo.setTextColor(color[0]);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case 101:
//                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                    handleSignInResult(task);
//
//
//                break;
        if (requestCode == 101) {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                if (signInAccountTask.isSuccessful()) {
                    Toast.makeText(SignInActivity.this, "Google LogIn Successfull .", Toast.LENGTH_SHORT).show();
                    try {
                        GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                        if (googleSignInAccount != null) {
                            AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);

                            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.e(TAG, "onComplete: login success ");
                                        startActivity(new Intent(SignInActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                    }
                                }
                            });
                        }
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "onActivityResult: " + e.getMessage());
            }
        }
    }

}

//    private void handleSignInResult boolean completedTask;
//                (Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//            // Signed in successfully, show authenticated UI.
//            updateUI(account);
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
//        }
//    }

//    private void updateUI(GoogleSignInAccount account) {
/*
        if (account!=null){

            Log.e(TAG, "updateUI: "+account.getId() );
            Log.e(TAG, "updateUI: "+account.getIdToken());
            Log.e(TAG, "updateUI: "+account.getEmail() );
            Log.e(TAG, "updateUI: "+account.getDisplayName() );
            Log.e(TAG, "updateUI: "+account.getPhotoUrl() );
        }
*/





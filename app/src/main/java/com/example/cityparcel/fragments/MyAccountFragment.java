package com.example.cityparcel.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.cityparcel.R;
import com.example.cityparcel.activity.SignInActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyAccountFragment extends Fragment {
    ImageView imageView;
    TextView username,mail;
    FirebaseAuth auth;
    Button logout;
    GoogleSignInClient googleSignInClient;
    private String TAG=getClass().getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile,container,false);

        imageView = view.findViewById(R.id.profile);
        username = view.findViewById(R.id.tv_username);
        mail = view.findViewById(R.id.tv_mailid);
        logout = view.findViewById(R.id.logout);
        googleSignInClient = GoogleSignIn.getClient(getActivity(), GoogleSignInOptions.DEFAULT_SIGN_IN);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        Log.e(TAG, "user: "+user.getDisplayName() );

        username.setText(user.getDisplayName());
        mail.setText(user.getEmail());
        Glide.with(MyAccountFragment.this).load(user.getPhotoUrl()).into(imageView);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        auth.signOut();

                        startActivity(new Intent(getContext(), SignInActivity.class));
                        getActivity().finish();
                    }
                });
            }
        });


        return view;
    }
}

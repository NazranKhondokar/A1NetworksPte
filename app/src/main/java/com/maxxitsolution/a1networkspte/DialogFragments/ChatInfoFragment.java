package com.maxxitsolution.a1networkspte.DialogFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.maxxitsolution.a1networkspte.JivoActivity;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatInfoFragment extends DialogFragment {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private EditText email, contact;
    private Button okay;

    public ChatInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_chat_info, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        email = view.findViewById(com.maxxitsolution.a1networkspte.R.id.ed_email);
        contact = view.findViewById(com.maxxitsolution.a1networkspte.R.id.ed_contact_number);
        okay = view.findViewById(com.maxxitsolution.a1networkspte.R.id.btn_okay);

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("email", email.getText().toString());
                editor.putInt("contact", Integer.parseInt(contact.getText().toString()));
                editor.apply();

                dataSaveFireBase();

                Intent myIntent = new Intent(getActivity(), JivoActivity.class);
                startActivity(myIntent);

                getDialog().dismiss();
            }
        });

        return view;
    }

    private void dataSaveFireBase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        Map<String, String> values = new HashMap<>();
        values.put("email", email.getText().toString());
        values.put("contact", contact.getText().toString());

        myRef.push().setValue(values);
    }
}

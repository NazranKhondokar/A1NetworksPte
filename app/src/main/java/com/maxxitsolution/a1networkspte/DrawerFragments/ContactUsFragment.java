package com.maxxitsolution.a1networkspte.DrawerFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maxxitsolution.a1networkspte.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    private Button btn_contact_us;
    private EditText ed_name, ed_email, ed_message;
    private String name, email, message;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        btn_contact_us = view.findViewById(R.id.btn_contact_us);
        ed_name = view.findViewById(R.id.ed_name);
        ed_email = view.findViewById(R.id.ed_email);
        ed_message = view.findViewById(R.id.ed_message);

        btn_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ed_name.getText().toString();
                email = ed_email.getText().toString();
                message = ed_message.getText().toString();

                sendMail();
            }
        });

        return view;
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "Customer Query");
        i.putExtra(Intent.EXTRA_TEXT,
                name + "\n\n" +
                        email + "\n\n" +
                        message);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

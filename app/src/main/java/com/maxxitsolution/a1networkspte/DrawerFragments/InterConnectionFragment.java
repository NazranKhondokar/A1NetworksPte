package com.maxxitsolution.a1networkspte.DrawerFragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterConnectionFragment extends Fragment {

    private String message;
    private static final String TAG = InterConnectionFragment.class.getSimpleName();
    private String timeZoneSelection;
    private Spinner timeZoneSpinner;
    private static ArrayList<String> timeZoneArrayList = new ArrayList();
    private Button sendInfo;
    private TextView billing, rate, company, softSwitch;
    private TextInputEditText companyName, companyContactPersonName, companyEmail, companyMobile,
            companySkype, companyAddress, billingContactPersonName, billingEmail, billingMobile,
            billingSkype, rateContactPersonName, rateEmail, rateMobile, rateSkype, switchName, ip;

    public InterConnectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_inter_connection, container, false);
        billing = view.findViewById(com.maxxitsolution.a1networkspte.R.id.billing);
        rate = view.findViewById(com.maxxitsolution.a1networkspte.R.id.rate);
        company = view.findViewById(com.maxxitsolution.a1networkspte.R.id.company);
        softSwitch = view.findViewById(com.maxxitsolution.a1networkspte.R.id.softSwitch);
        companyName = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companyName);
        companyContactPersonName = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companyContactPersonName);
        companyEmail = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companyEmail);
        companyMobile = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companyMobile);
        companySkype = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companySkype);
        companyAddress = view.findViewById(com.maxxitsolution.a1networkspte.R.id.companyAddress);
        billingContactPersonName = view.findViewById(com.maxxitsolution.a1networkspte.R.id.billingContactPersonName);
        billingEmail = view.findViewById(com.maxxitsolution.a1networkspte.R.id.billingEmail);
        billingMobile = view.findViewById(com.maxxitsolution.a1networkspte.R.id.billingMobile);
        billingSkype = view.findViewById(com.maxxitsolution.a1networkspte.R.id.billingSkype);
        rateContactPersonName = view.findViewById(com.maxxitsolution.a1networkspte.R.id.rateContactPersonName);
        rateEmail = view.findViewById(com.maxxitsolution.a1networkspte.R.id.rateEmail);
        rateMobile = view.findViewById(com.maxxitsolution.a1networkspte.R.id.rateMobile);
        rateSkype = view.findViewById(com.maxxitsolution.a1networkspte.R.id.rateSkype);
        switchName = view.findViewById(com.maxxitsolution.a1networkspte.R.id.switchName);
        ip = view.findViewById(com.maxxitsolution.a1networkspte.R.id.ip);
        timeZoneSpinner = view.findViewById(com.maxxitsolution.a1networkspte.R.id.timeZone);
        sendInfo = view.findViewById(com.maxxitsolution.a1networkspte.R.id.sendInfo);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/CONA.ttf");
        billing.setTypeface(type);
        rate.setTypeface(type);
        company.setTypeface(type);
        sendInfo.setTypeface(type);
        softSwitch.setTypeface(type);

        String[] ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            //System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
            displayTimeZone(TimeZone.getTimeZone(id));
        }
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, timeZoneArrayList);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        timeZoneSpinner.setAdapter(adapter);
        System.out.println("\nTotal TimeZone ID " + ids.length);

        timeZoneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timeZoneSelection = timeZoneArrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyDataForMail();
                sendMail();
            }
        });

        return view;
    }

    private void readyDataForMail() {
        message = "<< Company Information >>\n\n" +
                "Company Name: " + companyName.getText() + "\n" +
                "Contact Person Name: " + companyContactPersonName.getText() + "\n" +
                "Email: " + companyEmail.getText() + "\n" +
                "Mobile: " + companyMobile.getText() + "\n" +
                "Skype: " + companySkype.getText() + "\n" +
                "Address: " + companyAddress.getText() + "\n\n" +
                "<< Billing Information >>\n\n" +
                "Contact Person Name: " + billingContactPersonName.getText() + "\n" +
                "Email: " + billingEmail.getText() + "\n" +
                "Mobile: " + billingMobile.getText() + "\n" +
                "Skype: " + billingSkype.getText() + "\n\n" +
                "<< Rate Information >>\n\n" +
                "Contact Person Name: " + rateContactPersonName.getText() + "\n" +
                "Email: " + rateEmail.getText() + "\n" +
                "Mobile: " + rateMobile.getText() + "\n" +
                "Skype: " + rateSkype.getText() + "\n\n" +
                "<< Soft Switch Details >>\n\n" +
                "Switch Name: " + switchName.getText() + "\n" +
                "IP: " + ip.getText() + "\n" +
                "Time Zone: " + timeZoneSelection + "\n";
        Log.e(TAG, message);
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"maxit.exe@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Inter Connection Form");
        i.putExtra(Intent.EXTRA_TEXT, message);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
            timeZoneArrayList.add(result);
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
            timeZoneArrayList.add(result);
        }

        return result;

    }
}

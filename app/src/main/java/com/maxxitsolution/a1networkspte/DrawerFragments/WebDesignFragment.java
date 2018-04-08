package com.maxxitsolution.a1networkspte.DrawerFragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebDesignFragment extends Fragment {

    private View view;
    private Button basicOrder, standardOrder, premiumOrder;

    public WebDesignFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(com.maxxitsolution.a1networkspte.R.layout.fragment_web_design, container, false);

        initialization();
        basicOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBasicOrder();
            }
        });
        standardOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStandardOrder();
            }
        });
        premiumOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPremiumOrder();
            }
        });

        return view;
    }

    private void sendPremiumOrder() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(com.maxxitsolution.a1networkspte.R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "Web Design Premium Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "E-commerce Website" + "\n\n" +
                "Number of Pages 10" + "\n\n" +
                "Responsive Design" + "\n\n" +
                "E-Commerce Functionality" + "\n\n" +
                "Revision 20 Times" + "\n\n" +
                "Delivery Time 15-20 Days" + "\n\n" +
                "Price: 600$");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendStandardOrder() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(com.maxxitsolution.a1networkspte.R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "Web Design Standard Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "Small Business Website" + "\n\n" +
                "Number of Pages 10" + "\n\n" +
                "Responsive Design" + "\n\n" +
                "Revision 10 Times" + "\n\n" +
                "Delivery Time 5-7 Days" + "\n\n" +
                "Price: 200$");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendBasicOrder() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(com.maxxitsolution.a1networkspte.R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "Web Design Basic Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "Blog Website" + "\n\n" +
                "Number of Pages 5" + "\n\n" +
                "Responsive Design" + "\n\n" +
                "Revision 2 Times" + "\n\n" +
                "Delivery Time 3 Days" + "\n\n" +
                "Price: 100$");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void initialization() {
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Salmela.ttf");
        Typeface typeCONA = Typeface.createFromAsset(getActivity().getAssets(), "fonts/CONA.ttf");
        TextView basic = view.findViewById(com.maxxitsolution.a1networkspte.R.id.basic);
        TextView standard = view.findViewById(com.maxxitsolution.a1networkspte.R.id.standard);
        TextView premium = view.findViewById(com.maxxitsolution.a1networkspte.R.id.premium);
        basicOrder = view.findViewById(com.maxxitsolution.a1networkspte.R.id.basicOrder);
        standardOrder = view.findViewById(com.maxxitsolution.a1networkspte.R.id.standardOrder);
        premiumOrder = view.findViewById(com.maxxitsolution.a1networkspte.R.id.premiumOrder);
        basicOrder.setTypeface(typeCONA);
        standardOrder.setTypeface(typeCONA);
        premiumOrder.setTypeface(typeCONA);
        basic.setTypeface(type);
        standard.setTypeface(type);
        premium.setTypeface(type);
    }
}

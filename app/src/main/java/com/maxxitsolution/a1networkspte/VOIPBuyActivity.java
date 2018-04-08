package com.maxxitsolution.a1networkspte;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.maxxitsolution.a1networkspte.ModelClass.VOIP;

public class VOIPBuyActivity extends AppCompatActivity {

    private final String TAG = VOIPBuyActivity.this.getClass().getSimpleName();
    private VOIP voip;
    private TextView Code, Destination, Country, Premium, Silver, Special;
    private Button voipOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voip_buy);

        getSupportActionBar().setTitle("VOIP Termination");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initialization();
        voip = (VOIP) getIntent().getSerializableExtra("VOIP");
        Log.e(TAG, voip.getmCode());
        Code.setText(voip.getmCode());
        Destination.setText(voip.getmDestination());
        Country.setText(voip.getmCountry());
        Premium.setText(voip.getmPremium());
        Silver.setText(voip.getmSilver());
        Special.setText(voip.getmSpecial());

        voipOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void initialization() {
        Code = findViewById(R.id.Code);
        Destination = findViewById(R.id.Destination);
        Country = findViewById(R.id.Country);
        Premium = findViewById(R.id.Premium);
        Silver = findViewById(R.id.Silver);
        Special = findViewById(R.id.Special);
        voipOrder = findViewById(R.id.voipOrder);
        Typeface type = Typeface.createFromAsset(VOIPBuyActivity.this.getAssets(), "fonts/CONA.ttf");
        voipOrder.setTypeface(type);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "VOIP Termination Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "Code: " + voip.getmCode() + "\n\n" +
                "Destination: " + voip.getmDestination() + "\n\n" +
                "Country: " + voip.getmCountry() + "\n\n" +
                "Premium: " + voip.getmPremium() + "\n\n" +
                "Silver: " + voip.getmSilver() + "\n\n" +
                "Special: " + voip.getmSpecial());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

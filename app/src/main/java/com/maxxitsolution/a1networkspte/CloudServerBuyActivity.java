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

import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;

public class CloudServerBuyActivity extends AppCompatActivity {

    private final String TAG = CloudServerBuyActivity.this.getClass().getSimpleName();
    private CloudServer cloudServer;
    private TextView model, cpu, freq, ram, disk, network, ip, collocation, price;
    private Button cloudOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_server_buy);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Cloud Server");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initialization();
        cloudServer = (CloudServer) getIntent().getSerializableExtra("CloudServer");
        Log.e(TAG, cloudServer.getModel());
        model.setText(cloudServer.getModel());
        cpu.setText(cloudServer.getCpu());
        freq.setText(cloudServer.getFreq());
        ram.setText(cloudServer.getRam());
        disk.setText(cloudServer.getDisk());
        network.setText(cloudServer.getNetwork());
        ip.setText(cloudServer.getIp());
        collocation.setText(cloudServer.getCollocation());
        price.setText(cloudServer.getPrice());
        cloudOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void initialization() {
        model = findViewById(R.id.model);
        cpu = findViewById(R.id.cpu);
        freq = findViewById(R.id.freq);
        ram = findViewById(R.id.ram);
        disk = findViewById(R.id.disk);
        network = findViewById(R.id.network);
        ip = findViewById(R.id.ip);
        collocation = findViewById(R.id.collocation);
        price = findViewById(R.id.price);
        cloudOrder = findViewById(R.id.cloudOrder);
        Typeface type = Typeface.createFromAsset(CloudServerBuyActivity.this.getAssets(), "fonts/CONA.ttf");
        cloudOrder.setTypeface(type);
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
        i.putExtra(Intent.EXTRA_SUBJECT, "Cloud Server Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "Model: " + cloudServer.getModel() + "\n\n" +
                "CPU: " + cloudServer.getCpu() + "\n\n" +
                "Freq: " + cloudServer.getFreq() + "\n\n" +
                "RAM: " + cloudServer.getRam() + "\n\n" +
                "Disk: " + cloudServer.getDisk() + "\n\n" +
                "Network: " + cloudServer.getNetwork() + "\n\n" +
                "IP: " + cloudServer.getIp() + "\n\n" +
                "Collocation: " + cloudServer.getCollocation() + "\n\n" +
                "Price: " + cloudServer.getPrice());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.maxxitsolution.a1networkspte;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.maxxitsolution.a1networkspte.ModelClass.VOS3000;

public class VOSBuyActivity extends AppCompatActivity {
    private VOS3000 vos3000;
    private TextView concurrentCalls, processor, cores, memory, hardDisk, price;
    private Button vosOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vos_buy);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("VOS3000");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initialization();
        vos3000 = (VOS3000) getIntent().getSerializableExtra("VOS3000");
        concurrentCalls.setText(vos3000.getConcurrent_calls());
        processor.setText(vos3000.getProcessor());
        cores.setText(vos3000.getCores());
        memory.setText(vos3000.getMemory());
        hardDisk.setText(vos3000.getHard_disk());
        price.setText(vos3000.getPrice());
        vosOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void initialization() {
        concurrentCalls = findViewById(R.id.concurrentCalls);
        processor = findViewById(R.id.processor);
        cores = findViewById(R.id.cores);
        memory = findViewById(R.id.memory);
        hardDisk = findViewById(R.id.hardDisk);
        price = findViewById(R.id.price);
        vosOrder = findViewById(R.id.vosOrder);
        Typeface type = Typeface.createFromAsset(VOSBuyActivity.this.getAssets(), "fonts/CONA.ttf");
        vosOrder.setTypeface(type);
    }

    private void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.send_email)});
        i.putExtra(Intent.EXTRA_SUBJECT, "VOS3000 Order");
        i.putExtra(Intent.EXTRA_TEXT, "I am interested to buy" + "\n\n" +
                "Concurrent Calls: " + vos3000.getConcurrent_calls() + "\n\n" +
                "Processor: " + vos3000.getProcessor() + "\n\n" +
                "Num of Cores: " + vos3000.getCores() + "\n\n" +
                "Memory: " + vos3000.getMemory() + "\n\n" +
                "Hard Disk: " + vos3000.getHard_disk() + "\n\n" +
                "Price: " + vos3000.getPrice());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}

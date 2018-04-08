package com.maxxitsolution.a1networkspte;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.maxxitsolution.a1networkspte.DrawerFragments.ContactUsFragment;
import com.maxxitsolution.a1networkspte.DrawerFragments.DedicatedServerFragment;
import com.maxxitsolution.a1networkspte.DrawerFragments.InterConnectionFragment;
import com.maxxitsolution.a1networkspte.DrawerFragments.WebDesignFragment;
import com.maxxitsolution.a1networkspte.Adapter.DataAdapter;
import com.maxxitsolution.a1networkspte.DialogFragments.ChatInfoFragment;
import com.maxxitsolution.a1networkspte.DrawerFragments.HomeFragment;
import com.maxxitsolution.a1networkspte.ModelClass.CloudServer;
import com.maxxitsolution.a1networkspte.ModelClass.SearchModel;
import com.maxxitsolution.a1networkspte.Utilities.CSVFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private ArrayList<CloudServer> mArrayList = new ArrayList<>();
    private ArrayList<SearchModel> searchArrayList = new ArrayList<>();
    private DataAdapter mAdapter;
    private CloudServer cellModel = new CloudServer();
    private FrameLayout container;
    private MyTask myTask;
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

        myTask = new MyTask();
        myTask.execute();

        //Collect user email and contact number before chatting
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isNetworkAvailable(MainActivity.this)) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Internet connection not available check your internet connection");
                    alertDialogBuilder.setPositiveButton(getResources().getString(R.string.exit),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    finish();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } else {
                    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                    String email = prefs.getString("email", "No email defined");//"No name defined" is the default value.
                    int contact = prefs.getInt("contact", 0); //0 is the default value.
                    Log.e(TAG, email + " " + contact);

                    if (email.equals("No email defined")) {
                        ChatInfoFragment dFragment = new ChatInfoFragment();
                        // Show DialogFragment
                        dFragment.show(fm, "Dialog Fragment");
                    } else {
                        Intent myIntent = new Intent(MainActivity.this, JivoActivity.class);
                        startActivity(myIntent);
                    }
                }
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new HomeFragment()).commit();
        getSupportActionBar().setTitle("Home");
        //getWindow().setBackgroundDrawableResource(R.drawable.dedicated);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        disableNavigationViewScrollbars(navigationView);
    }

    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private ArrayList<SearchModel> CSVtoArrayList() {
        InputStream inputStream = getResources().openRawResource(R.raw.price);
        CSVFile csvFile = new CSVFile(inputStream);
        List list = csvFile.read();
        //String[] stat = (String[]) list.get(1);
        //Log.e(TAG, stat[0]);
        //Log.e(TAG, stat[1]);
        //Log.e(TAG, stat[2]);
        //Log.e(TAG, stat[3]);
        //Log.e(TAG, stat[4]);

        for (int i = 1; i < list.size(); i++) {
            String[] row = (String[]) list.get(i);
            SearchModel searchModel = new SearchModel();
            String location = row[0];
            char quotation = location.charAt(0);
            if (quotation == '"') {
                searchModel.setLocationName(row[0] + ", " + row[1]);
                searchModel.setDialCode(row[4]);
                searchModel.setPrice(row[5]);
            } else {
                searchModel.setLocationName(row[0]);
                searchModel.setDialCode(row[3]);
                searchModel.setPrice(row[4]);
            }
            searchArrayList.add(searchModel);
        }
        return searchArrayList;
    }

    private class MyTask extends AsyncTask<Void, Void, ArrayList<SearchModel>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<SearchModel> doInBackground(Void... params) {
            return CSVtoArrayList();
        }

        @Override
        protected void onPostExecute(ArrayList<SearchModel> result) {
            super.onPostExecute(result);
            //Log.e(TAG, result.get(1).getLocationName());
            mAdapter = new DataAdapter(MainActivity.this, result);
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    private void initViews() {
        container = findViewById(R.id.container);
        mRecyclerView = findViewById(R.id.card_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem searchMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);
        search(searchView);
        searchMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do whatever you need
                return true; // KEEP IT TO TRUE OR IT DOESN'T OPEN !!
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do whatever you need
                mRecyclerView.setVisibility(View.GONE);
                container.setVisibility(View.VISIBLE);
                return true; // OR FALSE IF YOU DIDN'T WANT IT TO CLOSE!
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            container.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (mAdapter != null) mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage) {
            mRecyclerView.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new HomeFragment()).commit();
            getSupportActionBar().setTitle("Home");
        } else if (id == R.id.inter_connection) {
            mRecyclerView.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new InterConnectionFragment()).commit();
            getSupportActionBar().setTitle("Inter Connection");
        } else if (id == R.id.dedicated_server) {
            mRecyclerView.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new DedicatedServerFragment()).commit();
            getSupportActionBar().setTitle("Dedicated Server");
        } else if (id == R.id.a_z_termiination) {
            container.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle("A-Z Termination");
        } else if (id == R.id.web_design) {
            mRecyclerView.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new WebDesignFragment()).commit();
            getSupportActionBar().setTitle("Web Design");
        } else if (id == R.id.contact_us) {
            mRecyclerView.setVisibility(View.GONE);
            container.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new ContactUsFragment()).commit();
            getSupportActionBar().setTitle("Contact Us");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }
}

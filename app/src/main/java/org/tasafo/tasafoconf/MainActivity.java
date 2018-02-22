package org.tasafo.tasafoconf;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.tasafo.tasafoconf.io.json.model.Conference;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Conference conference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        conference = ((TasafoconfApplication) getApplicationContext()).getConference();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            showAboutDialog();
            return true;
        }

        if (id == R.id.action_rate) {
            showRateAppDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;

        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {

            fragment = new HomeFragment();

        } else if (id == R.id.nav_briefs) {

            fragment = new BriefsFragment();

        } else if (id == R.id.nav_schedule) {

            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_speakers) {

            fragment = new SpeakersFragment();

        } else if (id == R.id.nav_videos) {

            fragment = new VideosFragment();

        } else if (id == R.id.nav_place) {

            Bundle args = new Bundle();
            args.putSerializable("location", conference.getLocation());
            fragment = new VenueFragment();
            fragment.setArguments(args);

        } else if (id == R.id.nav_share) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Baixe agora a app do Tá Safo Conf 2015 e acompanhe tudo sobre evento https://goo.gl/xxHVtL #tasafoconf");
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_feedback) {

            fragment = new FeedbackFragment();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        configurarActionBar(item);

        supportInvalidateOptionsMenu();;

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.container, fragment)
                .commit();

        return true;
    }

    private void configurarActionBar(MenuItem item) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(item.getTitle());
        }
    }

    private void showAboutDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.about_dialog_title))
                .setMessage(getString(R.string.about_dialog_title))
                .setPositiveButton(getString(R.string.about_dialog_positive_button_text), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openPlayStoreApp();
                    }
                }).setNeutralButton(getString(R.string.about_dialog_neutral_button_text), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    private void showRateAppDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.rate_app_dialog_title))
                .setMessage(getString(R.string.rate_app_dialog_message))
                .setPositiveButton(getString(R.string.rate_dialog_positive_button_text), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openPlayStoreApp();
                    }
                }).setNegativeButton(getString(R.string.rate_app_dialog_negative_button_text), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    private void openPlayStoreApp() {
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=org.tasafo.tasafoconf");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

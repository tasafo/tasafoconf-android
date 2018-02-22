package org.tasafo.tasafoconf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.tasafo.tasafoconf.io.json.model.Session;

public class SessionDetailsActivity extends AppCompatActivity {

    private TextView sessionDescription;
    private TextView showPresentation;
    private Session chosenSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_details);
        sessionDescription = (TextView) findViewById(R.id.session_description);
        showPresentation = (TextView) findViewById(R.id.see_presentation);
        showPresentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(chosenSession.getPresentationUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareSessionDetails();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        chosenSession = (Session) getIntent().getExtras().getSerializable("chosen_session");

        if (chosenSession != null){
            setTitle(chosenSession.getTitle());
            sessionDescription.setText(chosenSession.getDescription());
            showPresentation.setVisibility(chosenSession.isPresentationAvailable() ? View.VISIBLE : View.GONE);
        }
    }

    private void shareSessionDetails() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Estou assistindo a palestra " + chosenSession.getTitle() + " no #tasafoconf http://tasafo.github.io/conf2015");
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}

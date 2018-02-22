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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.tasafo.tasafoconf.io.json.model.SocialNetwork;
import org.tasafo.tasafoconf.io.json.model.Speaker;

import java.util.List;

public class SpeakerDetailsActivity extends AppCompatActivity {

    private ImageView speakerImage;
    private TextView speakerBio;
    private TextView socialNetworksTitle;
    private ImageView linkedin;
    private ImageView twitter;
    private ImageView github;
    Toolbar toolbar;
    private Speaker speaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_details);
        speakerImage = (ImageView) findViewById(R.id.user_profile_image);
        speakerBio = (TextView) findViewById(R.id.speaker_bio);
        socialNetworksTitle = (TextView) findViewById(R.id.social_networks_title);
        linkedin = (ImageView) findViewById(R.id.linkedin);
        twitter = (ImageView) findViewById(R.id.twitter);
        github = (ImageView) findViewById(R.id.github);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareSpeakerDetails();
            }
        });
    }

    private void shareSpeakerDetails() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, speaker.getName() + " (" + speaker.getWorkAt() + ") #tasafoconf http://tasafo.github.io/conf2015");
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        speaker = (Speaker) getIntent().getExtras().getSerializable("chosen_speaker");
        if (speaker != null) {
            toolbar.setTitle(speaker.getName());
            toolbar.setSubtitle(speaker.getJob());
            speakerBio.setText(speaker.getBio());
            Glide.with(this).load(speaker.getProfileImageUrl()).into(speakerImage);
            socialNetworksTitle.setText(String.format(getString(R.string.social_networks_title), speaker.getName()));

            if (speaker.hasSocialNetworks()) {

                List<SocialNetwork> socialNetworks = speaker.getSocialNetworks();

                for (final SocialNetwork socialNetwork : socialNetworks) {

                    if (socialNetwork.isTwitter()) {
                        twitter.setVisibility(View.VISIBLE);
                        twitter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewPage(socialNetwork.getUrl());
                            }
                        });
                    }

                    if (socialNetwork.isLinkedIn()) {
                        linkedin.setVisibility(View.VISIBLE);
                        linkedin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewPage(socialNetwork.getUrl());
                            }
                        });
                    }

                    if (socialNetwork.isGitHub()) {
                        github.setVisibility(View.VISIBLE);
                        github.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                viewPage(socialNetwork.getUrl());
                            }
                        });
                    }
                }
            }
        }
    }

    private void viewPage(String pageUrl) {
        Uri uri = Uri.parse(pageUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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

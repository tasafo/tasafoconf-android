package org.tasafo.tasafoconf;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.tasafo.tasafoconf.io.json.model.Conference;
import org.tasafo.tasafoconf.io.json.model.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    private Conference conference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        conference = ((TasafoconfApplication)getApplicationContext()).getConference();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        setTabsIcons(tabLayout);

    }

    private void setTabsIcons(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_code_braces);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_cellphone_android);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_lightbulb);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_google_circles_extended);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {
                case 0: {
                    fragment = new DevOpsFragment();
                    break;
                }
                case 1: {
                    fragment = new GameMobileFragment();
                    break;
                }
                case 2: {
                    fragment = new InnovationEnterpreneurshipCommunityFragment();
                    break;
                }
                case 3: {
                    fragment = new ManagementBusinessAgileFragment();
                    break;
                }
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

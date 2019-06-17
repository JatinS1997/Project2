package com.example.project2;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    public Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private ConstraintLayout constraintLayout;
    private FragmentCalls fragmentCalls;
    private FragmentMessages fragmentMessages;
    private FragmentHistory fragmentHistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        toolbar=findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentCalls(), "Calls");

        adapter.AddFragment(new FragmentMessages(), "Messages");

        adapter.AddFragment(new FragmentHistory(), "History");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        ListFragment fragment = new ListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, fragment);
        fragmentTransaction.commit();




        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        constraintLayout = (ConstraintLayout) findViewById(R.id.placeholder);
        fragmentCalls = new FragmentCalls();
        fragmentMessages = new FragmentMessages();
        fragmentHistory = new FragmentHistory();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId())
                {

                    case R.id.nav_calls :
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(fragmentCalls);
                        return true;

                    case R.id.nav_messages:
                        setFragment(fragmentMessages);
                        return true;

                    case R.id.nav_history:
                        setFragment(fragmentHistory);
                        return true;



                }
                return true;
            }

            private void setFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.placeholder, fragmentCalls);
                fragmentTransaction.commit();
            }

        });





    }




}

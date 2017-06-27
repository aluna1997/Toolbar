package com.unam.aluna.toolbar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        //POner titulo de la aplicacion
        setSupportActionBar(toolbar);

        //Accedemos a tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //Agregamos cada uno de los tabs
        tabLayout.addTab(tabLayout.newTab().setText("Uno"));
        tabLayout.addTab(tabLayout.newTab().setText("Dos"));
        tabLayout.addTab(tabLayout.newTab().setText("Tres"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuatro"));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Agregamos los tabs
        ViewPagerAdapter pageAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "Seleccionaste:" + tab.getText(), Toast.LENGTH_SHORT).show();
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, "Dejaste:" + tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Toast.makeText(MainActivity.this, "Reeseleccionaste:" + tab.getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}

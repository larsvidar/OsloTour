package no.larsvidar.oslotour;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflating Pager view and populating it with the TourPageAdapter.
        ViewPager viewPager = findViewById(R.id.pager_view);
        TourPagerAdapter adapter = new TourPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //Inflating the tabs at the top of the app.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}

package no.larsvidar.oslotour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array of titels for the tabs at the top of the app.
        String tabTitles[] = {getString(R.string.category_events), getString(R.string.category_restaurants), getString(R.string.category_museums), getString(R.string.category_historical)};

        //Inflating Pager view and populating it with the TourPageAdapter.
        ViewPager viewPager = findViewById(R.id.pager_view);
        TourPagerAdapter adapter = new TourPagerAdapter(getSupportFragmentManager(), tabTitles);
        viewPager.setAdapter(adapter);

        //Inflating the tabs at the top of the app.
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}

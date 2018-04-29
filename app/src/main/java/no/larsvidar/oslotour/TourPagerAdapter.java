package no.larsvidar.oslotour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = {"Events", "Food", "Museums", "Historical"};

    public TourPagerAdapter(FragmentManager manager) {
        super (manager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new EventsFragment();
        } else if (position == 1) {
            return new RestaurantsFragment();
        } else if (position == 2) {
            return new MuseumFragment();
        } else {
            return new HistoricFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

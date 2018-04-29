package no.larsvidar.oslotour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourPagerAdapter extends FragmentPagerAdapter {
    //The titles of each tab
    private String[] mTabTitle;

    public TourPagerAdapter(FragmentManager manager, String[] tabTitle) {
        super (manager);
        mTabTitle = tabTitle;
    }

    /**
     * @param position
     * @return the right fragment according to position.
     */
    @Override
    public Fragment getItem(int position) {
        //Checks position and returns right fragment.
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

    /**
     * @return number of tabs.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * @param position
     * @return name of tabs.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitle[position];
    }
}

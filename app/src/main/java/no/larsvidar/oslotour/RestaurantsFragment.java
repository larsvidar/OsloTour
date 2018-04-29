package no.larsvidar.oslotour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tour_list.xml.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //ArrayList with information about events in Oslo.
        final ArrayList sites = new ArrayList<>();
        sites.add(new Site(getString(R.string.restaurant1_title), R.drawable.ekebergrestauranten, getString(R.string.restaurant1_description)));
        sites.add(new Site(getString(R.string.restaurant2_title), R.drawable.maaemo, getString(R.string.restaurant2_description)));
        sites.add(new Site(getString(R.string.restaurant3_title), R.drawable.hanami, getString(R.string.restaurant3_description)));
        sites.add(new Site(getString(R.string.restaurant4_title), R.drawable.hosthea, getString(R.string.restaurant4_description)));
        sites.add(new Site(getString(R.string.restaurant5_title), R.drawable.alexsushi, getString(R.string.restaurant5_description)));
        sites.add(new Site(getString(R.string.restaurant6_title), R.drawable.izakaya, getString(R.string.restaurant6_description)));

        //Initilazing SiteAdapter and attaching it to the GridView
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_restaurants);
        GridView gridView = rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        //Return the complete view.
        return rootView;
    }
}

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
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tour_list.xml.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //ArrayList with information about events in Oslo.
        final ArrayList sites = new ArrayList<>();
        sites.add(new Site(getString(R.string.event1_title), R.drawable.osloxgames, getString(R.string.event1_description)));
        sites.add(new Site(getString(R.string.event2_title), R.drawable.oslopride, getString(R.string.event2_description)));
        sites.add(new Site(getString(R.string.event3_title), R.drawable.oslomedievalfestival, getString(R.string.event3_description)));
        sites.add(new Site(getString(R.string.event4_title), R.drawable.flagmay, getString(R.string.event4_description)));
        sites.add(new Site(getString(R.string.event5_title), R.drawable.osloindependentfilm, getString(R.string.event5_description)));
        sites.add(new Site(getString(R.string.event6_title), R.drawable.oyafestival, getString(R.string.event6_description)));

        //Initilazing SiteAdapter and attaching it to the GridView
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_events);
        GridView gridView = rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        //Return the complete view.
        return rootView;
    }
}

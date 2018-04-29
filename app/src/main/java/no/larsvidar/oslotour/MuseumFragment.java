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
public class MuseumFragment extends Fragment {

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tour_list.xml.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //ArrayList with information about museums in Oslo.
        final ArrayList sites = new ArrayList<>();
        sites.add(new Site(getString(R.string.museum1_title), R.drawable.astrupfearnley, getString(R.string.museum1_description)));
        sites.add(new Site(getString(R.string.museum2_title), R.drawable.tjuvholmensculpturepark, getString(R.string.museum2_description)));
        sites.add(new Site(getString(R.string.museum3_title), R.drawable.vikingmhipmuseum, getString(R.string.museum3_description)));
        sites.add(new Site(getString(R.string.museum4_title), R.drawable.norskfolkemuseum, getString(R.string.museum4_description)));
        sites.add(new Site(getString(R.string.museum5_title), R.drawable.historicalmuseum, getString(R.string.museum5_description)));
        sites.add(new Site(getString(R.string.museum6_title), R.drawable.technologymuseum, getString(R.string.museum6_description)));

        //Initilazing SiteAdapter and attaching it to the GridView
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_museums);
        GridView gridView = rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        //Return the complete view.
        return rootView;
    }
}

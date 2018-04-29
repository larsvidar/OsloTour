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
public class HistoricFragment extends Fragment {

    public HistoricFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tour_list.xml.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //ArrayList with information about historical sites in Oslo.
        final ArrayList sites = new ArrayList<>();
        sites.add(new Site(getString(R.string.site1_title), R.drawable.medivaloslo, getString(R.string.site1_description)));
        sites.add(new Site(getString(R.string.site2_title), R.drawable.kvadraturen, getString(R.string.site2_description)));
        sites.add(new Site(getString(R.string.site3_title), R.drawable.akershusfortress, getString(R.string.site3_description)));
        sites.add(new Site(getString(R.string.site4_title), R.drawable.memorialcemetery, getString(R.string.site4_description)));
        sites.add(new Site(getString(R.string.site5_title), R.drawable.akerselva, getString(R.string.site5_description)));
        sites.add(new Site(getString(R.string.site6_title), R.drawable.honselovisashouse, getString(R.string.site6_description)));

        //Initilazing SiteAdapter and attaching it to the GridView
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_historic);
        GridView gridView = rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        //Return the complete view.
        return rootView;
    }
}

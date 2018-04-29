package no.larsvidar.oslotour;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SiteAdapter extends ArrayAdapter<Site> {
    private int mBackgroundColor;

    public SiteAdapter(Activity context, ArrayList<Site> sites, int backroundColor) {
        super(context, 0, sites);
        mBackgroundColor = backroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tour_item, parent, false);
        }

        int backgroundColor = ContextCompat.getColor(getContext(), mBackgroundColor);
        listItemView.setBackgroundColor(backgroundColor);

        Site currentSite = getItem(position);

        TextView tourTitle = listItemView.findViewById(R.id.tour_title);
        tourTitle.setText(currentSite.getTitle());

        ImageView tourImage = listItemView.findViewById(R.id.tour_image);
        tourImage.setImageResource(currentSite.getImageId());

        TextView tourDescription = listItemView.findViewById(R.id.tour_description);
        tourDescription.setText(currentSite.getmDescription());

        return listItemView;
    }
}

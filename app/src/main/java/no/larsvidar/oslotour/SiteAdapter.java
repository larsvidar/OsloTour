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

        //Inflates listView, if it is not already inflated.
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tour_item, parent, false);
        }

        //Gets next item
        Site currentSite = getItem(position);

        //Setting backgroundcolor of listItemView.
        int backgroundColor = ContextCompat.getColor(getContext(), mBackgroundColor);
        listItemView.setBackgroundColor(backgroundColor);

        //Gets title from site object.
        TextView tourTitle = listItemView.findViewById(R.id.tour_title);
        tourTitle.setText(currentSite.getTitle());

        //Gets image id from site object.
        ImageView tourImage = listItemView.findViewById(R.id.tour_image);
        tourImage.setImageResource(currentSite.getImageId());

        //Gets description text from site object.
        TextView tourDescription = listItemView.findViewById(R.id.tour_description);
        tourDescription.setText(currentSite.getmDescription());

        //Returns the completed listItemView
        return listItemView;
    }
}

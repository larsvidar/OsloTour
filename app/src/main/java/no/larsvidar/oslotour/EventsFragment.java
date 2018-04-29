package no.larsvidar.oslotour;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mMediaCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaCleanUp();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaCleanUp();
            }
        }
    };

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList sites = new ArrayList<>();

        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));
        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));
        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));
        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));
        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));
        sites.add(new Site("Turist i egen by", R.drawable.turistiegenby, "En dag i året hvor Oslos borgere kan oppleve byens kulturelle tilbud helt gratis."));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites, R.color.category_events);

        GridView gridView = rootView.findViewById(R.id.list);

        gridView.setAdapter(adapter);

        return rootView;
    }

    private void mediaCleanUp() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mFocusChangeListener);
        }
    }

}

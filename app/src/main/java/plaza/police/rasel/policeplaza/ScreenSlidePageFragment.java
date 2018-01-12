package plaza.police.rasel.policeplaza;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by jacosrasel on 1/11/2018.
 */

public class ScreenSlidePageFragment extends Fragment {
    ImageView imageView;

    int drw;


    public static Fragment newInstance(int dr){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        fragment.drw=dr;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.image_layout, container, false);

        imageView=(ImageView) view.findViewById(R.id.imageView);

        Glide.with(this).load(drw).override(600, 300).into(imageView);
        return view;
    }
}
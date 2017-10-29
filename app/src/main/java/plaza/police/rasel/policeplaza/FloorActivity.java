package plaza.police.rasel.policeplaza;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class FloorActivity extends AppCompatActivity {
    TextView headText;
    RecyclerView mRecyclerViewFloorCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_floor);
        headText = (TextView) findViewById(R.id.weclome_TV);
        mRecyclerViewFloorCat = (RecyclerView) findViewById(R.id.rvCats);
        mRecyclerViewFloorCat.setLayoutManager(new GridLayoutManager(this, 3));
        FloorWiseCats floorWiseCats = new FloorWiseCats();
        mRecyclerViewFloorCat.setAdapter(floorWiseCats);
        ScaleInAnimationAdapter scaleInAnimationAdapter2 = new ScaleInAnimationAdapter(floorWiseCats);
        scaleInAnimationAdapter2.setFirstOnly(false);
        mRecyclerViewFloorCat.setAdapter(scaleInAnimationAdapter2);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/wild.ttf");
        headText.setTypeface(custom_font);
        animateIt(headText);

    }

    public void animateIt(TextView wlcmTV) {
        ObjectAnimator a = ObjectAnimator.ofInt(wlcmTV, "textColor", Color.GREEN, Color.RED);
        a.setInterpolator(new LinearInterpolator());
        a.setDuration(1000);
        a.setRepeatCount(ValueAnimator.INFINITE);
        a.setRepeatMode(ValueAnimator.REVERSE);
        a.setEvaluator(new ArgbEvaluator());
        AnimatorSet t = new AnimatorSet();
        t.play(a);
        t.start();
    }
}

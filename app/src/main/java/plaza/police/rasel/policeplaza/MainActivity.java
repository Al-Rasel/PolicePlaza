package plaza.police.rasel.policeplaza;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class MainActivity extends AppCompatActivity {

    private TextView wlcmTV, TV_shopbyFloor, TV_ShopByCat;
    private SeekBar seekBar;
    private RecyclerView mRecyclerViewFloor, mRecyerViewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.first_page);

        wlcmTV = (TextView) findViewById(R.id.weclome_TV);
        TV_shopbyFloor = (TextView) findViewById(R.id.tvShopByFloor);
        TV_ShopByCat = (TextView) findViewById(R.id.tvShopByCategory);


        mRecyclerViewFloor = (RecyclerView) findViewById(R.id.rv_shopByFloor);
        mRecyerViewCat = (RecyclerView) findViewById(R.id.rv_ShopBycategory);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/wild.ttf");
        Typeface custom_font_light = Typeface.createFromAsset(getAssets(), "fonts/openight.ttf");
        Typeface custom_regular = Typeface.createFromAsset(getAssets(), "fonts/openegular.ttf");

        wlcmTV.setTypeface(custom_font);
        TV_shopbyFloor.setTypeface(custom_regular);
        TV_ShopByCat.setTypeface(custom_regular);
        animateIt(wlcmTV);
        mRecyclerViewFloor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        RV_floorAdpater floorAdpater = new RV_floorAdpater();
        RV_catAdapter rv_catAdapter = new RV_catAdapter();
        mRecyclerViewFloor.setAdapter(floorAdpater);
        floorAdpater.setOnClickRV_floor(new RV_floorAdpater.OnClickRV_floor() {
            @Override
            public void onclick(int position) {
                startActivity(new Intent(getApplicationContext(), FloorActivity.class));
            }
        });

        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(floorAdpater);
        scaleInAnimationAdapter.setFirstOnly(false);
        mRecyclerViewFloor.setAdapter(scaleInAnimationAdapter);


        mRecyerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        mRecyerViewCat.setAdapter(rv_catAdapter);

        ScaleInAnimationAdapter scaleInAnimationAdapter2 = new ScaleInAnimationAdapter(rv_catAdapter);
        scaleInAnimationAdapter2.setFirstOnly(false);
        mRecyerViewCat.setAdapter(scaleInAnimationAdapter2);

        rv_catAdapter.setOnClickRV_floor(new RV_catAdapter.OnClickRV_floor() {
            @Override
            public void onclick(int position) {
                startActivity(new Intent(getApplicationContext(), FloorActivity.class));
            }
        });


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


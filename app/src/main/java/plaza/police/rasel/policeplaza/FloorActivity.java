package plaza.police.rasel.policeplaza;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plaza.police.rasel.policeplaza.adapters.FloorAdapter;
import plaza.police.rasel.policeplaza.model.SingleShop;

public class FloorActivity extends AppCompatActivity {
    TextView headText;
    RecyclerView mRecyclerViewFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_floor);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearSecondPage);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Glide.with(this).load(R.drawable.back_second).asBitmap().into(new SimpleTarget<Bitmap>(width, height) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearLayout.setBackground(drawable);
                }
            }
        });

        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("shopList");
        String catName = getIntent().getStringExtra("catName");
        List<SingleShop> selectedFloor = new ArrayList<>();


        for (SingleShop sort : myList
                ) {
            if (catName.equals(sort.getItemsofShop()))
                selectedFloor.add(sort);
        }


        List<SingleShop> result = new ArrayList<SingleShop>();
        Set<String> titles = new HashSet<String>();

        Toast.makeText(this, catName, Toast.LENGTH_SHORT).show();

        for (SingleShop item : selectedFloor) {
            if (titles.add(item.getFloorIconName())) {
                result.add(item);
            }
        }

        Log.e("tageee", "onCreate: 1   " + String.valueOf(result));


        Log.e("tageee", "onCreate: 22  " + String.valueOf(selectedFloor));

        mRecyclerViewFloor = (RecyclerView) findViewById(R.id.RV_floors);

        mRecyclerViewFloor.setLayoutManager(new GridLayoutManager(this, 3));
        FloorAdapter homeCategoryAdpater = new FloorAdapter(result);
        homeCategoryAdpater.setOnClickCategory(new FloorAdapter.OnClickCategory() {
            @Override
            public void onClickCategory(int position) {
                startActivity(new Intent(getApplicationContext(), Map_Activity.class));
            }
        });
        mRecyclerViewFloor.setAdapter(homeCategoryAdpater);


    }


}




package plaza.police.rasel.policeplaza;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

import plaza.police.rasel.policeplaza.model.SingleShop;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class SingleShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_single_shop);

        int shopID = getIntent().getIntExtra("id", 0);
        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("shoplist");

        SingleShop singleShop = myList.get(shopID);

        TextView textViewShopName;

        textViewShopName = (TextView) findViewById(R.id.shopName);

        try {

            textViewShopName.setText(singleShop.getShopName() + " (" + singleShop.getShopNO() + " )");
        } catch (Exception e) {
        }


        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);

        List<Banner> banners = new ArrayList<>();


        int drawableResourceId1 = getResources().getIdentifier(singleShop.getShopImageOneName(), "drawable", getPackageName());

        int drawableResourceId2 = getResources().getIdentifier(singleShop.getShopImageTwoName(), "drawable", getPackageName());


        int drawableResourceId3 = getResources().getIdentifier(singleShop.getShopImageThreeName(), "drawable", getPackageName());

        if (drawableResourceId1 != 0) {
            banners.add(new DrawableBanner(drawableResourceId1));
        }
        if (drawableResourceId2 != 0) {
            banners.add(new DrawableBanner(drawableResourceId2));
        }
        if (drawableResourceId3 != 0) {
            banners.add(new DrawableBanner(drawableResourceId3));
        }


        //add banner using image url


        //add banner using resource drawable

        bannerSlider.setBanners(banners);

        LinearLayout shopDeatlis = (LinearLayout) findViewById(R.id.shopDetails);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Glide.with(this).load(R.drawable.back_second).asBitmap().into(new SimpleTarget<Bitmap>(width, height) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    shopDeatlis.setBackground(drawable);
                }
            }
        });
        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}

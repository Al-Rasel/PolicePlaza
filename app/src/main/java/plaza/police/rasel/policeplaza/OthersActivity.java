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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import plaza.police.rasel.policeplaza.adapters.HomeCategoryAdpater;
import plaza.police.rasel.policeplaza.model.SingleShop;

public class OthersActivity extends AppCompatActivity {
    ArrayList<SingleShop> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_others);


        //background setup
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearCatPage);

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

//background end

        InputStream inputStream = getResources().openRawResource(R.raw.floorone);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Text Data", byteArrayOutputStream.toString());
        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(
                    byteArrayOutputStream.toString());
            JSONArray jObjectResult = jObject.getJSONArray("AllInfo");

            list = new ArrayList<>();
            if (jObjectResult != null) {
                int len = jObjectResult.length();
                for (int i = 0; i < len; i++) {
                    JSONObject o = (JSONObject) jObjectResult.get(i);
                    list.add(new SingleShop(o.getString("RealOwner"), o.getString("TenantsName"), o.getString("ShopNO"), o.getString("FloorNo"),


                            o.getString("FloorIconName"), o.getString("ShopName"), o.getString("ItemsofShop"), o.getString("catIconName"),


                            o.getString("marginLeft"), o.getString("marginTop"), o.getString("shopImageOneName"), o.getString("shopImageTwoName"),


                            o.getString("shopImageThreeName"), o.getString("ShopStatus"), o.getString("isOthers"), o.getString("ItemOfShopTwo"), o.getString("ItemOfShopThree")));
                }
            }

        } catch (Exception e) {
            Log.e("hadddd", "onCreate: " + String.valueOf(e));
            e.printStackTrace();
        }
        ArrayList<SingleShop> tmpList = new ArrayList<>();

        for (SingleShop singleShop : list
                ) {
            if (singleShop.getIsOthers().equals("1")) {
                tmpList.add(singleShop);
            }
        }


        ArrayList<SingleShop> result = new ArrayList<SingleShop>(12);
        for (int i = 0; i < 12; i++) {
            result.add(new SingleShop("aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa"));
        }

        Set<String> titles = new HashSet<String>();

        for (SingleShop item : tmpList) {
            if (titles.add(item.getItemOfShopTwo())) {
                if (item.getItemOfShopTwo().equals("Fitness & Sports")) {
                    result.add(0, item);
                } else if (item.getItemOfShopTwo().equals("Invitation Cards")) {
                    result.add(1, item);
                } else if (item.getItemOfShopTwo().equals("Tailors, Ladies & Gents")) {
                    result.add(2, item);
                } else if (item.getItemOfShopTwo().equals("Travel Bag")) {
                    result.add(3, item);
                } else if (item.getItemOfShopTwo().equals("Light and Decoration")) {
                    result.add(4, item);
                } else if (item.getItemOfShopTwo().equals("Gift Items")) {
                    result.add(5, item);
                } else if (item.getItemOfShopTwo().equals("Watch")) {
                    result.add(6, item);
                } else if (item.getItemOfShopTwo().equals("ATM Booth")) {
                    result.add(7, item);
                } else if (item.getItemOfShopTwo().equals("Money Exchanger")) {
                    result.add(8, item);
                } else if (item.getItemOfShopTwo().equals("Fabric & Clothes")) {
                    result.add(9, item);
                }

            }
        }

        for (Iterator<SingleShop> iterator = result.iterator(); iterator.hasNext(); ) {
            String value = iterator.next().getItemsofShop();
            if (value.equals("aa")) {
                iterator.remove();
            }
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RV_CategoryOthers);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        HomeCategoryAdpater homeCategoryAdpater = new HomeCategoryAdpater(result, 2);
        recyclerView.setAdapter(homeCategoryAdpater);
        homeCategoryAdpater.setOnClickCategory(new HomeCategoryAdpater.OnClickCategory() {
            @Override
            public void onClickCategory(int position) {

                Intent intent = new Intent(getApplicationContext(), FloorActivity.class);
                Bundle bundleSendToDdealUpload = new Bundle();
                bundleSendToDdealUpload.putString("catName", result.get(position).getItemOfShopTwo());
                bundleSendToDdealUpload.putParcelableArrayList("shopList", list);
                intent.putExtras(bundleSendToDdealUpload);
                startActivity(intent);
            }
        });


        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OthersActivity.this.finish();
            }
        });

    }

}

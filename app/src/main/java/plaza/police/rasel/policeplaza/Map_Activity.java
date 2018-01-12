package plaza.police.rasel.policeplaza;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import plaza.police.rasel.policeplaza.model.SingleShop;

public class Map_Activity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout mRelativeLayout;
    ArrayList<SingleShop> markerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_map_);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.mapRelative);


        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("allShops");
        String catName = getIntent().getStringExtra("catName");
        String floorName = getIntent().getStringExtra("floorName");

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        Log.e("floors", "onCreate: " + catName + "  " + floorName + "   " + String.valueOf(myList));

        if (floorName.equals("f_gero")) {

            ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
            Glide
                    .with(this)
                    .load(R.drawable.floor_g)
                  .override(width,height)

                    .into(imageViewMap);

        } else if (floorName.equals("f_one")) {
            ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
            Glide
                    .with(this)
                    .load(R.drawable.f_one_map)
                    .override(width,height)

                    .into(imageViewMap);
        } else if (floorName.equals("f_two")) {
            ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
            Glide
                    .with(this)
                    .load(R.drawable.f_two_map)
                    .override(width,height)

                    .into(imageViewMap);
        } else if (floorName.equals("f_three")) {
            ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
            Glide
                    .with(this)
                    .load(R.drawable.f_three_map)
                    .override(width,height)

                    .into(imageViewMap);
        } else if (floorName.equals("f_four")) {
            ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
            Glide
                    .with(this)
                    .load(R.drawable.f_four_map)
                    .override(width,height)

                    .into(imageViewMap);
        }


        markerList = new ArrayList<>();

        for (SingleShop singleShop : myList
                ) {
            if ((singleShop.getItemsofShop().equals(catName)||singleShop.getItemOfShopTwo().equals(catName)||singleShop.getItemOfShopThree().equals(catName)) && singleShop.getFloorIconName().equals(floorName)) {
                markerList.add(singleShop);
            }
        }
        int i = 0;
        for (SingleShop markerList1 : markerList
                ) {
            setMarker(Integer.parseInt(markerList1.getMarginLeft()), Integer.parseInt(markerList1.getMarginRight()), markerList1.getShopName(), i,Integer.parseInt(markerList1.getFloorNo()));
            i++;
        }


        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        try {
            startActivity(new Intent(this, SingleShopActivity.class).putExtra("shoplist", markerList).putExtra("id", v.getId()));
        } catch (Exception e) {
            Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();

        }
    }

    public void setMarker(int marginLeftFromMethod, int marginTopFromMethod, String ShopName, int id,int floor) {

        int aleft = (int) (1.26865 * marginLeftFromMethod);
        int aright = (int) (1.428571 * marginTopFromMethod);

        if (floor!=1){
            aleft=(int)(1.67*aleft);
            aright=(int)(1.52*aright);
        }
        float d = getResources().getDisplayMetrics().density;
        int marginleft = (int) (100 * d);


        LinearLayout layoutSection = new LinearLayout(this);
        layoutSection.setOnClickListener(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                marginleft, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutSection.setOrientation(LinearLayout.VERTICAL);

        if (ShopName.equals("Time Zone")) {

            params.leftMargin = (int) (marginLeftFromMethod * d);
            params.topMargin = (int) (marginTopFromMethod * d);

        } else {
            Log.e("tageese", "setMarker:left " + aleft + " right " + aright);
            params.leftMargin = (int) (aleft * d);
            params.topMargin = (int) (aright * d);

        }


        int marginleft22 = (int) (50 * d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginleft22, marginleft22);
        layoutSection.setId(id);
        layoutParams.gravity = Gravity.CENTER;
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);

        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        textView.setMaxLines(1);
        textView.setText(ShopName);
        textView.setPadding((int) (4 * d), (int) (4 * d), (int) (4 * d), (int) (4 * d));

        textView.setBackgroundColor(Color.parseColor("#214658"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        layoutSection.addView(textView);
        layoutSection.addView(imageView);


        mRelativeLayout.addView(layoutSection, params);
        Glide
                .with(this)
                .load(R.drawable.check)
                .thumbnail(0.1f)
                .into(imageView);


    }

}
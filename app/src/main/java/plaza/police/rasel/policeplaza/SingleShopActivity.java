package plaza.police.rasel.policeplaza;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import plaza.police.rasel.policeplaza.model.SingleShop;

public class SingleShopActivity extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    TextView textViewNoImages;
    List<Integer> myImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_single_shop);
        textViewNoImages = (TextView) findViewById(R.id.noImage);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        int shopID = getIntent().getIntExtra("id", 0);
        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("shoplist");

        SingleShop singleShop = myList.get(shopID);

        TextView textViewShopName;

        textViewShopName = (TextView) findViewById(R.id.shopName);

        try {

            textViewShopName.setText(singleShop.getShopName() + " (" + singleShop.getShopNO() + " )");
        } catch (Exception e) {
        }


        int drawableResourceId1 = getResources().getIdentifier(singleShop.getShopImageOneName(), "drawable", getPackageName());


        int drawableResourceId2 = getResources().getIdentifier(singleShop.getShopImageTwoName(), "drawable", getPackageName());
        int drawableResourceId3 = getResources().getIdentifier(singleShop.getShopImageThreeName(), "drawable", getPackageName());


        if (drawableResourceId1 == 0) {
            drawableResourceId1 = getResources().getIdentifier("a" + singleShop.getShopNO() + "_1", "drawable", getPackageName());


        }
        if (drawableResourceId2 == 0) {
            drawableResourceId2 = getResources().getIdentifier("a" + singleShop.getShopNO() + "_2", "drawable", getPackageName());

        }


        if (drawableResourceId3 == 0) {
            drawableResourceId3 = getResources().getIdentifier("a" + singleShop.getShopNO() + "_3", "drawable", getPackageName());

        }

        if (drawableResourceId1 != 0) {

            myImages.add(drawableResourceId1);

        }
        if (drawableResourceId2 != 0) {
            myImages.add(drawableResourceId2);

        }
        if (drawableResourceId3 != 0) {
            myImages.add(drawableResourceId3);

        }


        //add banner using image url


        //add banner using resource drawable


        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            try {
                return ScreenSlidePageFragment.newInstance(myImages.get(position));
            } catch (Exception e) {

                if (myImages.size()==0){
                    mPager.setVisibility(View.GONE);
                    textViewNoImages.setVisibility(View.VISIBLE);
                }

                return ScreenSlidePageFragment.newInstance(0);
            }


        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}



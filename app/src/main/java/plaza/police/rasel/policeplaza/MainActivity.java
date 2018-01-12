package plaza.police.rasel.policeplaza;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import plaza.police.rasel.policeplaza.adapters.FloorAdapter;
import plaza.police.rasel.policeplaza.adapters.HomeCategoryAdpater;
import plaza.police.rasel.policeplaza.model.SingleShop;

public class MainActivity extends AppCompatActivity {
    ArrayList<SingleShop> list;

    RecyclerView recyclerViewCategory;

    RecyclerView recyclerViewFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.first_page);




       /* Glide.with(this).load(R.drawable.floor_ge).asBitmap().into(new SimpleTarget<Bitmap>(width, height) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    linearLayout.setBackground(drawable);
                }
            }
        });*/


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


                            o.getString("shopImageThreeName"), o.getString("ShopStatus"),o.getString("isOthers"),o.getString("ItemOfShopTwo"),o.getString("ItemOfShopThree")));
                }
            }

        } catch (Exception e) {
            Log.e("hadddd", "onCreate: " + String.valueOf(e));
            e.printStackTrace();
        }

        ArrayList<SingleShop> result = new ArrayList<SingleShop>(12);
        for (int i = 0; i <12 ; i++) {
            result.add(new SingleShop("aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa","aa"));
        }

        Set<String> titles = new HashSet<String>();

        for (SingleShop item : list) {
            if (titles.add(item.getItemsofShop())) {
                if(item.getItemsofShop().equals("Gents Collection")){
                    result.add(0,item);
                }else if(item.getItemsofShop().equals("Ladies Collection")){
                    result.add(1,item);
                }else if(item.getItemsofShop().equals("Kids Collection")){
                    result.add(2,item);
                }else if(item.getItemsofShop().equals("Cosmetics")){
                    result.add(3,item);
                }else if(item.getItemsofShop().equals("Mobile & Tab")){
                    result.add(4,item);
                }else if(item.getItemsofShop().equals("Computer & Electronics")){
                    result.add(5,item);
                }else if(item.getItemsofShop().equals("Gold and Diamond")){
                    result.add(6,item);
                }else if(item.getItemsofShop().equals("Imitation")){
                    result.add(7,item);
                }else if(item.getItemsofShop().equals("Households")){
                    result.add(8,item);
                }else if(item.getItemsofShop().equals("Leather & shoes")){
                    result.add(9,item);
                }else if(item.getItemsofShop().equals("Food")){
                    result.add(10,item);
                }else if(item.getItemsofShop().equals("Others")){
                    result.add(11,item);
                }

            }
        }

        for (Iterator<SingleShop> iterator = result.iterator(); iterator.hasNext(); ) {
            String value = iterator.next().getItemsofShop();
            if (value.equals("aa")) {
                iterator.remove();
            }
        }


        recyclerViewCategory = (RecyclerView) findViewById(R.id.recylerViewCategory);

        recyclerViewFloor = (RecyclerView) findViewById(R.id.recylerViewFloor);

        recyclerViewCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(), 6));


        Log.e("eedee", "onCreate: "+String.valueOf(result) );
        HomeCategoryAdpater homeCategoryAdpater = new HomeCategoryAdpater(result);
        homeCategoryAdpater.setOnClickCategory(new HomeCategoryAdpater.OnClickCategory() {
            @Override
            public void onClickCategory(int position) {

                if (result.get(position).getItemsofShop().equals("Others")){

                    Intent intent = new Intent(getApplicationContext(), OthersActivity.class);
            /*        Bundle bundleSendToDdealUpload = new Bundle();
                    bundleSendToDdealUpload.putString("catName", result.get(position).getItemsofShop());
                    bundleSendToDdealUpload.putParcelableArrayList("shopList", list);
                    intent.putExtras(bundleSendToDdealUpload);*/
                    startActivity(intent);

                }else {
                    Intent intent = new Intent(getApplicationContext(), FloorActivity.class);
                    Bundle bundleSendToDdealUpload = new Bundle();
                    bundleSendToDdealUpload.putString("catName", result.get(position).getItemsofShop());
                    bundleSendToDdealUpload.putParcelableArrayList("shopList", list);
                    intent.putExtras(bundleSendToDdealUpload);
                    startActivity(intent);
                }



            }
        });
        recyclerViewCategory.setAdapter(homeCategoryAdpater);


        List<SingleShop> floorList = new ArrayList<>();


        floorList.add(new SingleShop("real", "ten", "ee", "aad", "f_gero", "ten", "ee", "aad", "real", "real", "ten", "ee", "aad", "real","ee","ee","ee"));
        floorList.add(new SingleShop("real", "ten", "ee", "aad", "f_one", "ten", "ee", "aad", "real", "real", "ten", "ee", "aad", "real","ee","ee","ee"));
        floorList.add(new SingleShop("real", "ten", "ee", "aad", "f_two", "ten", "ee", "aad", "real", "real", "ten", "ee", "aad", "real","ee","ee","ee"));
        floorList.add(new SingleShop("real", "ten", "ee", "aad", "f_three", "ten", "ee", "aad", "real", "real", "ten", "ee", "aad", "real","ee","ee","ee"));
        floorList.add(new SingleShop("real", "ten", "ee", "aad", "f_four", "ten", "ee", "aad", "real", "real", "ten", "ee", "aad", "real","ee","ee","ee"));


        recyclerViewFloor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        FloorAdapter homeFloor = new FloorAdapter(floorList);
        homeFloor.setOnClickCategory(new FloorAdapter.OnClickCategory() {
            @Override
            public void onClickCategory(int position) {
                startActivity(new Intent(getApplicationContext(), CategoryActivity.class).putExtra("allCats", list).putExtra("floorName", floorList.get(position).getFloorIconName()));
            }
        });
        recyclerViewFloor.setAdapter(homeFloor);


    }

    public void goToFloor(View view) {
        startActivity(new Intent(this, FloorActivity.class));
    }

    public void goToCategory(View view) {
        startActivity(new Intent(this, CategoryActivity.class));
    }
}
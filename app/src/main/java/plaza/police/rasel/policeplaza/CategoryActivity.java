package plaza.police.rasel.policeplaza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plaza.police.rasel.policeplaza.adapters.HomeCategoryAdpater;
import plaza.police.rasel.policeplaza.model.SingleShop;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_category);




        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("allCats");
        String floorIconName = getIntent().getStringExtra("floorName");

        ArrayList<SingleShop> floorWiseCats = new ArrayList<>();

        for (SingleShop singleShop : myList
                ) {
            if (singleShop.getFloorIconName().equals(floorIconName)) {
                floorWiseCats.add(singleShop);
            }
        }


        List<SingleShop> result = new ArrayList<SingleShop>();
        Set<String> titles = new HashSet<String>();


        for (SingleShop item : floorWiseCats) {
            if(item.getIsOthers().equals("0")){
                if (titles.add(item.getItemsofShop())) {
                    result.add(item);
                }
            } else {

                if (titles.add(item.getItemOfShopTwo())) {
                    result.add(item);
                }


            }


        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RV_Category);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        Log.e("eeeeee", "onCreate: "+result );
        HomeCategoryAdpater homeCategoryAdpater = new HomeCategoryAdpater(result,"ch");

        homeCategoryAdpater.setOnClickCategory(new HomeCategoryAdpater.OnClickCategory() {
            @Override
            public void onClickCategory(int position) {

                if (result.get(position).getItemsofShop().equals("Others")){
                    startActivity(new Intent(getApplicationContext(), Map_Activity.class).putExtra("allShops", myList).putExtra("catName", result.get(position).getItemOfShopTwo()).putExtra("floorName", floorIconName));

                }else {
                    startActivity(new Intent(getApplicationContext(), Map_Activity.class).putExtra("allShops", myList).putExtra("catName", result.get(position).getItemsofShop()).putExtra("floorName", floorIconName));

                }



            }
        });


        recyclerView.setAdapter(homeCategoryAdpater);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
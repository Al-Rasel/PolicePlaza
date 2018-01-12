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
import android.widget.TextView;

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



        ArrayList<SingleShop> myList = getIntent().getExtras().getParcelableArrayList("shopList");
        String catName = getIntent().getStringExtra("catName");
        List<SingleShop> selectedFloor = new ArrayList<>();


        for (SingleShop sort : myList
                ) {
            if (catName.equals(sort.getItemsofShop())|| catName.equals(sort.getItemOfShopTwo())|| catName.equals(sort.getItemOfShopThree())){
                selectedFloor.add(sort);
            }

        }


        List<SingleShop> result = new ArrayList<SingleShop>();
        Set<String> titles = new HashSet<String>();
//l


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
                startActivity(new Intent(getApplicationContext(), Map_Activity.class).putExtra("allShops", myList).putExtra("catName", catName).putExtra("floorName", result.get(position).getFloorIconName()));
            }
        });
        mRecyclerViewFloor.setAdapter(homeCategoryAdpater);


        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}

package plaza.police.rasel.policeplaza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Map_Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.enter, R.anim.exit);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_map_);
        RelativeLayout mRelativeLayout = (RelativeLayout) findViewById(R.id.mapRelative);
        ImageView imageViewMap = (ImageView) findViewById(R.id.mainImage);
        Glide
                .with(this)
                .load(R.drawable.map)

                .thumbnail(0.1f)
                .into(imageViewMap);


        ImageView imageView = new ImageView(this);
        imageView.setId(11111);
        imageView.setOnClickListener(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                140, 140);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        int dpValueLeft = 150;

        int dpValueRight = 150; /// margin in dips
        float d = getResources().getDisplayMetrics().density;
        int marginleft = (int) (dpValueLeft * d);

        int marginRight = (int) (dpValueRight * d);

        params.leftMargin = marginleft;
        params.topMargin = marginRight;
        mRelativeLayout.addView(imageView, params);
        Glide
                .with(this)
                .load(R.drawable.check)

                .thumbnail(0.1f)
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == 11111)
            Toast.makeText(this, "Okka", Toast.LENGTH_SHORT).show();
    }
}

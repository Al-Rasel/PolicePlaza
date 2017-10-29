package plaza.police.rasel.policeplaza;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Rasel on 10/29/2017.
 */

public class RV_catAdapter extends RecyclerView.Adapter<RV_catAdapter.RV_viewholder> {

    OnClickRV_floor onClickRV_floor;

    public interface OnClickRV_floor {
        void onclick(int position);
    }

    public void setOnClickRV_floor(OnClickRV_floor onClickRV_floor) {
        this.onClickRV_floor = onClickRV_floor;
    }

    @Override
    public RV_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RV_viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_cat, parent, false));
    }

    @Override
    public void onBindViewHolder(RV_viewholder holder, int position) {

        if (position == 0) {
            holder.textViewName.setText("Men's Fashion");
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(6)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
        } else if (position == 1) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(7)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Women's World");
        } else if (position == 2) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(50)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Sample Category");
        } else if (position == 3) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(11)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Category");
        } else if (position == 4) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(15)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Category");
        } else if (position == 5) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(22)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Category");
        } else if (position == 6) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(18)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Category");
        } else if (position == 7) {
            Glide
                    .with(holder.itemView.getContext())
                    .load("http://www.ajkerdeal.com/images/AppImages/HomeCategoryLogoVs1P4/"+String.valueOf(42)+".png")
                    .override(300, 200)
                    .thumbnail(0.1f)
                    .into(holder.nm);
            holder.textViewName.setText("Category");
        }




    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class RV_viewholder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDes;
        ImageView nm;

        public RV_viewholder(View itemView) {


            super(itemView);
            Typeface custom_font_light = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/openight.ttf");
            Typeface custom_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/openegular.ttf");
            textViewName = itemView.findViewById(R.id.textName);
            textViewDes = itemView.findViewById(R.id.tvDes);
            nm = itemView.findViewById(R.id.textNm);

            textViewName.setTypeface(custom_regular);
            textViewDes.setTypeface(custom_font_light);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickRV_floor.onclick(getAdapterPosition());
                }
            });
        }
    }
}


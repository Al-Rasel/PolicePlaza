package plaza.police.rasel.policeplaza.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import plaza.police.rasel.policeplaza.R;
import plaza.police.rasel.policeplaza.model.SingleShop;

/**
 * Created by jacosrasel on 11/22/2017.
 */

public class HomeCategoryAdpater extends RecyclerView.Adapter<HomeCategoryAdpater.HomeCategoryViewHolder> {

    List<SingleShop> singleShops = new ArrayList<>();
    OnClickCategory onClickCategory;
    int mTrackValue;
    String check = "ooo";

    public void setOnClickCategory(OnClickCategory onClickCategory) {
        this.onClickCategory = onClickCategory;
    }


    public HomeCategoryAdpater(List<SingleShop> singleShops) {
        this.singleShops = singleShops;
    }

    public HomeCategoryAdpater(List<SingleShop> singleShops, int track) {
        this.singleShops = singleShops;
        this.mTrackValue = track;
    }

    public HomeCategoryAdpater(List<SingleShop> singleShops, String track) {
        this.singleShops = singleShops;
        this.check = track;
    }

    @Override
    public HomeCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_home_category_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeCategoryViewHolder holder, int position) {

        if (mTrackValue == 2) {
            holder.textCatName.setText(singleShops.get(position).getItemOfShopTwo());
        } else {

            if (check.equals("ch")) {

                if (singleShops.get(position).getItemsofShop().equals("Others")) {
                    holder.textCatName.setText(singleShops.get(position).getItemOfShopTwo());
                } else {
                    holder.textCatName.setText(singleShops.get(position).getItemsofShop());
                }

            } else {
                holder.textCatName.setText(singleShops.get(position).getItemsofShop());
            }

        }


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(singleShops.get(position).getCatIconName(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageViewCatIcon);


    }

    public interface OnClickCategory {
        void onClickCategory(int position);
    }

    @Override
    public int getItemCount() {
        return singleShops.size();
    }

    class HomeCategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewCatIcon;
        TextView textCatName;

        public HomeCategoryViewHolder(View itemView) {
            super(itemView);

            imageViewCatIcon = itemView.findViewById(R.id.singleCatImage);
            textCatName = itemView.findViewById(R.id.singleCatText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickCategory.onClickCategory(getAdapterPosition());
                }
            });

        }
    }
}

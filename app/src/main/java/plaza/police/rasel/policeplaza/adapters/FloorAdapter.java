package plaza.police.rasel.policeplaza.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import plaza.police.rasel.policeplaza.R;
import plaza.police.rasel.policeplaza.model.SingleShop;

/**
 * Created by jacosrasel on 11/22/2017.
 */

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.HomeCategoryViewHolder>  {

    OnClickCategory onClickCategory;

    public void setOnClickCategory(OnClickCategory onClickCategory) {
        this.onClickCategory = onClickCategory;
    }


    public interface OnClickCategory {
        void onClickCategory(int position);
    }


    List<SingleShop> singleShops = new ArrayList<>();

    public FloorAdapter(List<SingleShop> singleShops) {
        this.singleShops = singleShops;
    }

    @Override
    public HomeCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_floor_design, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeCategoryViewHolder holder, int position) {


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(singleShops.get(position).getFloorIconName(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageViewCatIcon);


    }

    @Override
    public int getItemCount() {
        return singleShops.size();
    }

    class HomeCategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewCatIcon;

        public HomeCategoryViewHolder(View itemView) {
            super(itemView);

            imageViewCatIcon = itemView.findViewById(R.id.singleCatImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickCategory.onClickCategory(getAdapterPosition());
                }
            });
        }
    }
}

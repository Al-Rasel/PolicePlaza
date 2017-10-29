package plaza.police.rasel.policeplaza;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Rasel on 10/29/2017.
 */

public class RV_floorAdpater extends RecyclerView.Adapter<RV_floorAdpater.RV_viewholder> {
    OnClickRV_floor onClickRV_floor;

    public interface OnClickRV_floor {
        void onclick(int position);
    }

    public void setOnClickRV_floor(OnClickRV_floor onClickRV_floor) {
        this.onClickRV_floor = onClickRV_floor;
    }

    @Override
    public RV_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RV_viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_floor, parent, false));
    }

    @Override
    public void onBindViewHolder(RV_viewholder holder, int position) {
        holder.nm.setText(String.valueOf(position + 1));
        if (position == 0) {
            holder.textViewName.setText("First Floor");
        } else if (position == 1) {
            holder.textViewName.setText("Second Floor");
        } else if (position == 2) {
            holder.textViewName.setText("Third Floor");
        } else if (position == 3) {
            holder.textViewName.setText("Fourth Floor");
        } else if (position == 4) {
            holder.textViewName.setText("Fifth Floor");
        } else if (position == 5) {
            holder.textViewName.setText("Sixth Floor");
        } else if (position == 6) {
            holder.textViewName.setText("Seventh Floor");
        } else if (position == 7) {
            holder.textViewName.setText("Eighth Floor");
        }

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class RV_viewholder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDes;
        TextView nm;

        public RV_viewholder(View itemView) {


            super(itemView);
            Typeface custom_font_light = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/openight.ttf");
            Typeface custom_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/openegular.ttf");
            textViewName = itemView.findViewById(R.id.textName);
            textViewDes = itemView.findViewById(R.id.tvDes);
            nm = itemView.findViewById(R.id.textNm);
            nm.setTypeface(custom_font_light);
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

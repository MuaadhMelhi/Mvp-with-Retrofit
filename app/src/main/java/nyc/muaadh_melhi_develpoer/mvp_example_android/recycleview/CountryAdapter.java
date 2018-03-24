package nyc.muaadh_melhi_develpoer.mvp_example_android.recycleview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.muaadh_melhi_develpoer.mvp_example_android.R;
import nyc.muaadh_melhi_develpoer.mvp_example_android.model.CountryRes;

/**
 * Created by Muaadh on 3/23/18.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    int count = 0;
    List<CountryRes> countryResList = new ArrayList<>();
    private int nullCount = 0;

    public CountryAdapter(List<CountryRes> countryResList) {
        this.countryResList.clear();
        this.countryResList.addAll(countryResList);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(final CountryViewHolder holder, int position) {
        holder.tvCountryName.setText(countryResList.get(position).getName());
         String url=countryResList.get(0).getFlag();
        Picasso.get().load(url).into(holder.imCountryFlag);
        holder.tvCountryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryResList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_country_name)
        TextView tvCountryName;
        @BindView(R.id.im_country_flag)
        ImageView imCountryFlag;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

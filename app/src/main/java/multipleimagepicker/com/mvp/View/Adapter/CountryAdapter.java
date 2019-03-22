package multipleimagepicker.com.mvp.View.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import multipleimagepicker.com.mvp.Model.CountryModel;
import multipleimagepicker.com.mvp.R;
import multipleimagepicker.com.mvp.View.activity.MainActivity;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<CountryModel> feedResponse;
    public CountryAdapter(ArrayList<CountryModel> feedResponse, MainActivity mainActivity) {
        this.feedResponse=feedResponse;
        this.mContext=mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.countryName.setText(feedResponse.get(i).getName());
        myViewHolder.countrycode.setText(feedResponse.get(i).getCurrencyName());
        myViewHolder.CurrencySymbol.setText(feedResponse.get(i).getCurrencySymbol());
        Glide.with(mContext)
                .load(feedResponse.get(i).getFlagPng()).apply(new RequestOptions().placeholder(R.drawable.logo_butterflies))
                .into(myViewHolder.flags);
    }



    @Override
    public int getItemCount() {
        return feedResponse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countryName,countrycode,CurrencySymbol;
        ImageView flags;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName=(TextView)itemView.findViewById(R.id.countryName);
            countrycode=(TextView)itemView.findViewById(R.id.countrycode);
            CurrencySymbol=(TextView)itemView.findViewById(R.id.CurrencySymbol);
            flags=(ImageView)itemView.findViewById(R.id.flags);
        }


    }
}

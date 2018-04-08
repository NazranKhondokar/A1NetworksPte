package com.maxxitsolution.a1networkspte.Adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.maxxitsolution.a1networkspte.ModelClass.SearchModel;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {

    private static final String TAG = DataAdapter.class.getSimpleName();
    private ArrayList<SearchModel> mArrayList;
    private ArrayList<SearchModel> mFilteredList;
    private Activity activity;
    private boolean isMatched = true;

    public DataAdapter(Activity activity, ArrayList<SearchModel> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
        this.activity = activity;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(com.maxxitsolution.a1networkspte.R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        Typeface type = Typeface.createFromAsset(activity.getAssets(), "fonts/CONA.ttf");
        //Typeface type = Typeface.createFromAsset(activity.getAssets(), "fonts/Salmela.ttf");
        viewHolder.tv_location_name.setTypeface(type);
        viewHolder.tv_location_name.setText(mFilteredList.get(i).getLocationName());
        viewHolder.tv_dial_code.setText("Dial Code: " + mFilteredList.get(i).getDialCode());
        viewHolder.tv_price.setText("Rate: $" + mFilteredList.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();
                //Log.e(TAG, charString);
                isMatched = true;

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<SearchModel> filteredList = new ArrayList<>();

                    for (SearchModel searchModel : mArrayList) {
                        if (searchModel.getLocationName().toLowerCase().contains(charString) && !TextUtils.isDigitsOnly(charSequence)) {
                            //Log.e(TAG, "match name" + searchModel.getLocationName());
                            filteredList.add(searchModel);
                        }
                        if (searchModel.getDialCode().contains(charString)) {
                            isMatched = true;
                            for (int i = 0; i < charString.length(); i++) {
                                if (searchModel.getDialCode().charAt(i) != charSequence.charAt(i)) {
                                    isMatched = false;
                                    break;
                                }
                            }
                            if (isMatched) {
                                //Log.e(TAG, "match code " + searchModel.getDialCode());
                                filteredList.add(searchModel);
                            }
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<SearchModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_location_name, tv_dial_code, tv_price;

        public ViewHolder(View view) {
            super(view);

            tv_location_name = (TextView) view.findViewById(com.maxxitsolution.a1networkspte.R.id.tv_location_name);
            tv_dial_code = (TextView) view.findViewById(com.maxxitsolution.a1networkspte.R.id.tv_dial_code);
            tv_price = (TextView) view.findViewById(com.maxxitsolution.a1networkspte.R.id.tv_price);

        }
    }

}
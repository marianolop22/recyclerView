package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recyclerview.RestaurantFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link } and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestaurantRecyclerViewAdapter(List<Restaurant> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).getName());
        holder.address.setText(mValues.get(position).getAddress());
        holder.rate.setRating(mValues.get(position).getRate());
        //holder.ivPhoto.set(mValues.get(position).getUrlPhoto());


        Picasso.get().load(mValues.get(position).getUrlPhoto()).into( holder.ivPhoto );


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView address;
        public final RatingBar rate;
        public final ImageView ivPhoto;
        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            address = (TextView) view.findViewById(R.id.txtAddress);
            name = (TextView) view.findViewById(R.id.txtName);
            rate = (RatingBar) view.findViewById(R.id.rate);
            ivPhoto = (ImageView) view.findViewById(R.id.ivPhoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + name.getText() + "'";
        }
    }
}

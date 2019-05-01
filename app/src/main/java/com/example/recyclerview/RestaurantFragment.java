package com.example.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestaurantFragment extends Fragment {

    RecyclerView recyclerView;
    MyRestaurantRecyclerViewAdapter restaurantAdapter;
    List<Restaurant> restaurants;


    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Lista de restaurantes
            restaurants = new ArrayList<>();
            restaurants.add( new Restaurant( "Poncho", "https://static.wixstatic.com/media/f1fc76_2e58281f4dd546b1b83dfc800e8e1bce~mv2_d_1933_1283_s_2.png/v1/crop/x_0,y_268,w_1933,h_651/fill/w_1674,h_564,al_c,q_85,usm_0.66_1.00_0.01/f1fc76_2e58281f4dd546b1b83dfc800e8e1bce~mv2_d_1933_1283_s_2.webp", 3, "aca nomas"));
            restaurants.add( new Restaurant( "Pepe", "http://www.restaurantelacupula.com/wp-content/blogs.dir/1417/files/gallery/W1A1327-HDR.jpg", 3, "aca nomas"));
            restaurants.add( new Restaurant( "Pacharola", "http://fusion19.com/nueva-web/wp-content/uploads/2018/07/IMG_4363bweb.jpg", 3, "aca nomas"));
            restaurants.add( new Restaurant( "Los hijos de puta", "https://i.ytimg.com/vi/f5s4GIuB8HI/hqdefault.jpg", 3, "aca nomas"));
            restaurants.add( new Restaurant( "Carlitos", "https://media-cdn.tripadvisor.com/media/photo-s/03/d8/b0/ce/restaurante.jpg", 3, "aca nomas"));
            restaurants.add( new Restaurant( "panchotazo", "https://pbs.twimg.com/media/BzEdJywIEAAcKTA.jpg", 3, "aca nomas"));


            restaurantAdapter = new MyRestaurantRecyclerViewAdapter(restaurants , mListener);
            recyclerView.setAdapter(  restaurantAdapter );
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurant item);
    }
}

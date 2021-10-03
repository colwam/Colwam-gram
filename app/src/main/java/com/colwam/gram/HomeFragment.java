package com.colwam.gram;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView homeRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_home,container,false
        );

        String[] eventNames = new String[Model.eventData.length];
        for (int i=0;i<eventNames.length;i++)
        {
            eventNames[i] = Model.eventData[i].getEventName();
        }
        int[] image = new int[Model.eventData.length];
        for (int i=0;i< image.length;i++)
        {
            image[i] = Model.eventData[i].getImageResourceId();
        }

        HomePageAdapter adapter = new HomePageAdapter(eventNames,image);
        homeRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        homeRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new HomePageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),DisplayEventdetail.class);
                intent.putExtra(DisplayEventdetail.EXTRA_DATA_ID,position);
                getActivity().startActivity(intent);
            }
        });
        return homeRecycler;

    }






}
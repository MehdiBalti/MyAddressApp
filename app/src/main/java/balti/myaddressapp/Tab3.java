package balti.myaddressapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import balti.myaddressapp.AdapterModule.ContactAdapter;
import balti.myaddressapp.LocalDb.TableControllerContact;
import balti.myaddressapp.MOdel.Contacts;

/**
 * Created by Belal on 2/3/2016.
 */

public class Tab3 extends Fragment {
    RecyclerView rv;
    LinearLayoutManager llm;
    ArrayList<Contacts> conatclist;
    ContactAdapter adapter;
    ViewGroup rootView;
    private SwipeRefreshLayout swipeRefreshLayout;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        // return inflater.inflate(R.layout.tab1, container, false);

        rootView = (ViewGroup) inflater.inflate(R.layout.tab3, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) rootView. findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);

                conatclist=new TableControllerContact(rootView.getContext()).getAllContacts("1");
                adapter= new ContactAdapter(conatclist,getActivity());
                swipeRefreshLayout.setRefreshing(false);
                rv.setAdapter(adapter);

            }
        });


        rv= (RecyclerView)rootView.findViewById(R.id.recycler_view);
        llm = new LinearLayoutManager(getContext().getApplicationContext());
        rv.setLayoutManager(llm);



        conatclist=new TableControllerContact(rootView.getContext()).getAllContacts("1");
        swipeRefreshLayout.setRefreshing(false);
        adapter= new ContactAdapter(conatclist,getActivity());

        rv.setAdapter(adapter);













        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();

        swipeRefreshLayout.setRefreshing(true);

        conatclist=new TableControllerContact(rootView.getContext()).getAllContacts("1");
        adapter= new ContactAdapter(conatclist,getActivity());
        swipeRefreshLayout.setRefreshing(false);
        rv.setAdapter(adapter);
    }
}

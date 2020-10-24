package com.example.m0317073.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.m0317073.Adapder.NavigationListAdapter;
import com.example.m0317073.R;

public class LeftFragment extends Fragment {
    private FragmentListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + "must implement FragmentListener");
        }
    }
    public static LeftFragment newInstance(String title){
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    public LeftFragment(){
    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_left, container, false);
        final String[] itemname = {
                "Home",
                "Menu",
                "Exit"
        };

        final Integer[] imgid = {
                R.drawable.ic_cafe,
                R.drawable.ic_menu,
                R.drawable.ic_logout
        };

        NavigationListAdapter adapter = new NavigationListAdapter(getActivity(), itemname, imgid);
        list = (ListView) view.findViewById(R.id.list_view);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                switch (selectedItem){
                    case "Home":
                        listener.changePage(1);
                        break;
                    case "Menu" :
                        listener.changePage(2);
                        break;
                    case "Exit" :
                        listener.closeApplication();
                        break;
                }
            }
        });
        return view;

    }
}

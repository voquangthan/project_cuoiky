package com.example.project_bangcuuchuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HeaderFragment extends Fragment {
    Button Button_back;
    Button Btn_done;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        Button_back = view.findViewById(R.id.hoc_back);
        Btn_done=view.findViewById(R.id.btn_hoc_done);
        Btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Quiz_Activity.class);
                v.getContext().startActivity(intent);
            }
        });
        Button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getSupportFragmentManager().getBackStackEntryCount()>0){
                    getActivity().getSupportFragmentManager().popBackStack();
                }
                else{
                    getActivity().finish();
                }
            }
        });

        return view;
    }
}

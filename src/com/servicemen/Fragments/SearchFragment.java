package com.servicemen.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.servicemen.R;

public class SearchFragment extends Fragment{
	
	@Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);	      
 }
 	 
 @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
     Bundle savedInstanceState) {
	ViewGroup searchView = (ViewGroup) inflater.inflate(R.layout.search_frag, null);
	return searchView;
 }

}

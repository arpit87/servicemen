package com.servicemen.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.servicemen.R;
import com.servicemen.HTTPClient.HttpClient;
import com.servicemen.HTTPClient.HttpRequest;
import com.servicemen.HTTPClient.RegisterRequest;
import com.servicemen.HelperClasses.AlertDialogBuilder;
import com.servicemen.Utils.StringUtils;

public class RegisterFragment extends Fragment
{
	EditText mobile_num;
	EditText name;
	AutoCompleteTextView area_autocomplete;
	Spinner skill;
	EditText description;
	Button register_button;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState){
	        super.onCreate(savedInstanceState);	      
	 }
	 	 
	 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState) {
		ViewGroup registerView = (ViewGroup) inflater.inflate(R.layout.register_frag, null);
		mobile_num = (EditText)registerView.findViewById(R.id.inputMobNo);
		name = (EditText)registerView.findViewById(R.id.inputName);
		description = (EditText)registerView.findViewById(R.id.inputDesc);
		area_autocomplete =(AutoCompleteTextView) registerView.findViewById(R.id.inputRegion);
		skill = (Spinner) registerView.findViewById(R.id.inputSkill);
		register_button = (Button) registerView.findViewById(R.id.btnCreateProduct);
		
		String[] localities = getResources().getStringArray(R.array.locationlist_arrays);
	    ArrayAdapter loc_adapter = new ArrayAdapter (getActivity(),R.layout.skilldropdown,localities);
	    area_autocomplete.setAdapter(loc_adapter);
	    
	    String[] skillset = getResources().getStringArray(R.array.servicelist_arrays);
	    ArrayAdapter skill_adapter = new ArrayAdapter (getActivity(),R.layout.skilldropdown,skillset);
	    skill.setAdapter(skill_adapter);	   
	   	    
	    register_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			String mob_num = mobile_num.getText().toString();
			String nameStr = name.getText().toString();
			String descriptionStr = description.getText().toString();
			String area = area_autocomplete.getText().toString();
			String skillStr = skill.getSelectedItem().toString();
			
			if (StringUtils.isBlank(mob_num) ||
			    StringUtils.isBlank(nameStr)	||
			    StringUtils.isBlank(area) ||
			    StringUtils.isBlank(skillStr))
			{
				AlertDialogBuilder.showOKDialog(getActivity(), "Input missing", "Mobile, Name, Area and Skill are necessary");
			}
			else
			{
				HttpRequest regReq = new RegisterRequest(mob_num, nameStr, area, skillStr, descriptionStr, null);
				HttpClient.getInstance().executeRequest(regReq);
			}
			}
		});
				   
		return registerView;
	 }

}

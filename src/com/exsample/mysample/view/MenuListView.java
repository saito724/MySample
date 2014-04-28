package com.exsample.mysample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mysample.R;
import com.example.mysample.util.LogUtil;

public class MenuListView extends RelativeLayout {
	private ExpandableListView mExListView;
	private EditText mEditText;
	
	private final String[] mTitles = new String[]{"oya1","oya2","oya3","oya4","oya5"};
	private final String[] mPhease1 = new String[]{"aaaaaaaaaaa","iiiiiiiiiiiiiiiiiiiiii","uuuuu","e","ooooooooooooooo"};
	private final String[] mPhease2 = new String[]{"kkkkkkkkkkk","kekekekek","kjlijilj","2e2e2e2e","2ooooo"};
	private final String[] mPhease3 = new String[]{"33","3ggggggggggggg","uu3sdfsdfsfsffsuuu","e33333333333333","ggggg"};
	private final String[] mPhease4 = new String[]{"4jskopdrigspori","iiiiiiiiiiiiiiiiiiiiii","uuuuu","e","ooooooooooooooo"};
	private final String[] mPhease5 = new String[]{"5jisdlofjhioujtis;oierjh;","iiiiiiiiiiiiiiiiiiiiii","uuuuu","e","ooooooooooooooo"};

	public MenuListView(Context context) {
		super(context);
		init();
	}

	public MenuListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public MenuListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init(){
		 ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.menu_list_view,this,true);
		 this.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
		 mExListView = (ExpandableListView)findViewById(R.id.expandableListView1);
		 LogUtil.DLog("mExlistView", mExListView.getWidth());
		 mEditText = (EditText)findViewById(R.id.editText1);
		 LogUtil.DLog("MenuListView", this.getHeight());
	}
	public void initData(){
		
	}

}

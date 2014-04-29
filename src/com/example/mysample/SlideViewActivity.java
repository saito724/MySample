package com.example.mysample;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;

import com.example.mysample.util.LogUtil;
import com.exsample.mysample.view.MenuListView;
import com.exsample.mysample.view.ScrollHorizon;
import com.exsample.mysample.view.SlideView;

public class SlideViewActivity extends BaseActivity implements View.OnClickListener {
	ScrollHorizon mSlideView;
	View mainView ;
	View subView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTitle("スライドする");
		super.onCreate(savedInstanceState);
	 mainView = getLayoutInflater().inflate(R.layout.activity_slide_view, null);
		 subView = new MenuListView(this);

		
		
		mSlideView = new ScrollHorizon(this);
		//mSlideView.setView(mainView, subView, SlideView.RtoL);
		//setContentView(mSlideView);
		mSlideView.setView((Activity)this,mainView, subView, SlideView.RtoL);
		Button btn1 = (Button)findViewById(R.id.btn_slide_view);
		btn1.setOnClickListener(this);
		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setOnClickListener(this);



	}
	
	@Override
	protected void onPostResume() {
		super.onPostResume();

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);

	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(Menu.FIRST).setOnMenuItemClickListener(new OnMenuItemClickListener(){

			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				
				return false;
			}});
		return true;
	}

	@Override
	public void onClick(View v) {
		LogUtil.DLog("ddddd", mainView.getWidth());
		LogUtil.DLog("subView", subView.getWidth());
		if(v.getId() == R.id.btn_slide_view){
			mSlideView.openSubView();
		}else{
			mSlideView.CloseSubView();
		}
		
	}

}

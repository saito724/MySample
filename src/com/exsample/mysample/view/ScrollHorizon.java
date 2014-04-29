package com.exsample.mysample.view;

import com.example.mysample.util.LogUtil;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class ScrollHorizon extends LinearLayout {
	private HorizontalScrollView mScrollView;
	private View mMainView;
	private View mSubView;
	
	



	public ScrollHorizon(Context context) {
		super(context);
		init(context);
	}



	public ScrollHorizon(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context){

		
	}
	
	
	public void setView(Activity activity ,View mainView, View subView, int mode) {

		this.setOrientation(HORIZONTAL);
		
		
		
		mMainView = mainView;
		mSubView = subView;
		

		LinearLayout.LayoutParams rlp = getLLParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

		ViewGroup parent = (ViewGroup) getParent();
		if(parent != null){
			parent.removeView(this);
		}
		
		mScrollView = new HorizontalScrollView(activity);
		mScrollView.setHorizontalScrollBarEnabled(false);
		mScrollView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		LogUtil.DLog("mScrollView", mScrollView.getChildCount());
		setLayoutParams(getLLParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mScrollView.addView(this);
		addView(mainView, getLLParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		addView(subView,rlp);
		
		ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
		ViewGroup above = (ViewGroup) decor.getChildAt(0);
		decor.removeView(above);
		decor.addView(mScrollView);
		
		

	}


	public synchronized void toggleSubView(){

		
	}
	
	public void openSubView(){
		mSubView.setVisibility(VISIBLE);
		mScrollView.post(new Runnable(){
			@Override
			public void run() {
				mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
				
			}
		});

	}
	
	public void CloseSubView(){
		mScrollView.post(new Runnable(){
			@Override
			public void run() {
				mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
				
			}
		});
		mSubView.setVisibility(GONE);

	}
	
	private LinearLayout.LayoutParams getLLParams(int width, int height) {
		return new LinearLayout.LayoutParams(width, height);
	}

}

package com.exsample.mysample.view;

import com.example.mysample.util.LogUtil;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class SlideView extends RelativeLayout {
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
	private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;

	public static final int LtoR = 0;
	public static final int RtoL = 1;
	
	private Scroller mScroller;
	private int mDuration = 300;
	
	
	private int mMode;
	private boolean mIsOpenSub;
	
	
	private int mStartX = 0;
	private int mEndX = 0;



	public SlideView(Context context) {
		super(context);
		init(context);
	}

	public SlideView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public SlideView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context){
		mScroller = new Scroller(context);
	}
	
	
	public void setView(View mainView, View subView, int mode) {
		mMode = mode;
		
		

		RelativeLayout.LayoutParams rlp = getRLParams(WC, MP);
		if (mode == RtoL) {
			mStartX = 0;
			mEndX = 300;
			rlp.addRule(RelativeLayout.RIGHT_OF, mainView.getId());
		}else{
			mStartX = 0;
			mEndX = -300;
			rlp.addRule(RelativeLayout.LEFT_OF, mainView.getId());
		}
		addView(subView,rlp);
		addView(mainView, getRLParams(MP, MP));
		LogUtil.DLog("subVieww", subView.getWidth());
		LogUtil.DLog("mainView", mainView.getWidth());
	}

	 @Override
	    public void computeScroll() {
	        if (mScroller.computeScrollOffset()) {
	            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
	            postInvalidate();
	        }
	    }
	
	public synchronized void toggleSubView(){
		
	}
	
	public void openSubView(){
		if(!mScroller.isFinished()){
			return;
		}
		mScroller.startScroll(mStartX, 0, (mEndX - mStartX), 0, mDuration);

		LogUtil.DLog("open", mEndX);
        invalidate();
	}
	
	public void CloseSubView(){
		if(!mScroller.isFinished()){
			return;
		}
		mScroller.startScroll(mEndX, 0, (mStartX - mEndX), 0, mDuration);
        invalidate();
	}
	
	private RelativeLayout.LayoutParams getRLParams(int width, int height) {
		return new RelativeLayout.LayoutParams(width, height);
	}

}

package com.example.mysample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

	Button btnSlideView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		View.OnClickListener btnListener = new ButtonClickListener();
		
		btnSlideView = (Button) findViewById(R.id.btn_slide_view);
		btnSlideView.setOnClickListener(btnListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	private class ButtonClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();

			switch (id) {
			case R.id.btn_slide_view:
				clickBtnSlideView();
			default:
				break;
			}

		}

	}

	void clickBtnSlideView() {
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), SlideViewActivity.class);
		startActivity(intent);
	}

}

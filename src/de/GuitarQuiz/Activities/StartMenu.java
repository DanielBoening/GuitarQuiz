package de.GuitarQuiz.Activities;

import com.MusikMonksSolution.guitarquiz.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StartMenu extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.startpage);
	}
	
	public void play(View v) {
		Intent myIntent = new Intent(StartMenu.this, Quiz.class);
		StartMenu.this.startActivity(myIntent);
	}

}

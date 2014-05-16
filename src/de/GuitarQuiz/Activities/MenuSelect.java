package de.GuitarQuiz.Activities;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.UserDataBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MenuSelect extends Activity {
	private UserDataBase userDataBase = new UserDataBase();
	TextView level1View;
	TextView level2View;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.menuselect);
		
		userDataBase.load(this);
		level1View = (TextView) findViewById(R.id.level1TextView);		
		level2View = (TextView) findViewById(R.id.level2TextView);		
		
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		level1View.setText("HighScore: "+userDataBase.getHighScore(1));
		level2View.setText("HighScore: "+userDataBase.getHighScore(2));

	}


	public void resetDatabase(View v){
		userDataBase.resetDataBase();
		level1View.setText("HighScore: "+userDataBase.getHighScore(1));
		level2View.setText("HighScore: "+userDataBase.getHighScore(2));

	}

	public void startInfiniteMode(View v) {
		Intent myIntent = new Intent(MenuSelect.this, Quiz.class);
		MenuSelect.this.startActivity(myIntent);
	}

	public void startLevel(View v) {
		int level = 1;
		switch (v.getId()) {
		case R.id.startlevel1:
			level = 1;
			break;
		case R.id.startLevel2:
			level = 2;
			break;

		}
		Quiz.setLevel(level);
		Intent myIntent = new Intent(MenuSelect.this, Quiz.class);
		MenuSelect.this.startActivity(myIntent);
	}

}

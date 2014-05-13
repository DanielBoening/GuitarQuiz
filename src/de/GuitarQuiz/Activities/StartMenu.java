package de.GuitarQuiz.Activities;

<<<<<<< HEAD
import com.MusikMonksSolution.guitarquiz.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
=======
import android.app.Activity;
import android.os.Bundle;
>>>>>>> 1658d75f338137583a6f16cac706533ac307b0b6

public class StartMenu extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD
	
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.startpage);
	}
	
	public void play(View v) {
		Intent myIntent = new Intent(StartMenu.this, Quiz.class);
		StartMenu.this.startActivity(myIntent);
=======
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
>>>>>>> 1658d75f338137583a6f16cac706533ac307b0b6
	}

}

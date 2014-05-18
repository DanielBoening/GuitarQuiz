package de.GuitarQuiz.Activities;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.UserDataBase;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MenuSelect extends Activity implements OnClickListener {
	private UserDataBase userDataBase = new UserDataBase();
	TextView level1View;
	TextView level2View;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
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
		level1View.setText("HighScore: " + userDataBase.getHighScore(1));
		level2View.setText("HighScore: " + userDataBase.getHighScore(2));

	}

	public void resetDatabase(View v) {
		AlertDialog ad = new AlertDialog.Builder(this)
				.setMessage(
						"Achtung.\nSollen deine Daten wirklich unwiderruflich gel�scht werden?")
				.setIcon(R.drawable.ic_launcher).setTitle("Daten l�schen")
				.setPositiveButton("Ja", this).setNegativeButton("Nein", this)
				.setCancelable(false).create();
		ad.show();
		;



	}

	public void startInfiniteMode(View v) {
		Quiz.setLevel(0);

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
		case R.id.startLevel3:
			level = 1;
			break;
		case R.id.startLevel4:
			level = 1;
			break;

		}
		Quiz.setLevel(level);
		Intent myIntent = new Intent(MenuSelect.this, Quiz.class);
		MenuSelect.this.startActivity(myIntent);
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		switch (which) {
		case DialogInterface.BUTTON_POSITIVE: // yes
			userDataBase.resetDataBase();
			level1View.setText("HighScore: " + userDataBase.getHighScore(1));
			level2View.setText("HighScore: " + userDataBase.getHighScore(2));
			
			
			break;
		case DialogInterface.BUTTON_NEGATIVE: // no

			break;
		case DialogInterface.BUTTON_NEUTRAL: // neutral
			break;
		default:
			// nothing
			break;
		}
	}

}

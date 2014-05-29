package de.GuitarQuiz.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.ChordLibrary;
import de.GuitarQuiz.Classes.UserDataBase;

public class MenuSelect extends Activity implements OnClickListener {
	private UserDataBase userDataBase = new UserDataBase();
//	TextView level1View;
//	TextView level2View;
	private ChordLibrary chordsLibrary = new ChordLibrary();

	
	Button buttonStartLevel1;
	Button buttonStartLevel2;
	Button buttonStartLevel3;
	Button buttonStartLevel4;
	Button buttonStartLevel5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.menuselect);

		userDataBase.load(this);
//		level1View = (TextView) findViewById(R.id.level1TextView);
//		level2View = (TextView) findViewById(R.id.level2TextView);
		initialiseLevelButtons();


	}

	private void initialiseLevelButtons() {
		buttonStartLevel1 = (Button) findViewById(R.id.startlevel1);
		buttonStartLevel2 = (Button) findViewById(R.id.startlevel2);
		buttonStartLevel3 = (Button) findViewById(R.id.startlevel3);
		buttonStartLevel4 = (Button) findViewById(R.id.startlevel4);
		buttonStartLevel5 = (Button) findViewById(R.id.startlevel5);
		
		int medalScore1 = chordsLibrary.getMedal(1, userDataBase.getHighScore(1));
		int medalScore2 = chordsLibrary.getMedal(2, userDataBase.getHighScore(2));
		int medalScore3 = chordsLibrary.getMedal(3, userDataBase.getHighScore(3));
		int medalScore4 = chordsLibrary.getMedal(4, userDataBase.getHighScore(4));
		int highScore = userDataBase.getHighScore(5);
//		int medalScore5 = chordsLibrary.getMedal(5, highScore);
		
		
		updateButtonImage(buttonStartLevel1, medalScore1, 1);
		updateButtonImage(buttonStartLevel2, medalScore2, 2);
		updateButtonImage(buttonStartLevel3, medalScore3, 3);
		updateButtonImage(buttonStartLevel4, medalScore4, 4);
//		updateButtonImage(buttonStartLevel5, medalScore5, 5);
		
	}

	private void updateButtonImage(Button button, int medalScore, int level) {
		if(medalScore != 0){
		int medalImage = chordsLibrary.getMedalImageSmall(medalScore);
		button.setBackgroundResource(medalImage);
		}
		if(level != 1){
			level--; // Last Level
			int lastMedal = chordsLibrary.getMedal(level, userDataBase.getHighScore(level));
			if(lastMedal==0){
				button.setBackgroundResource(R.drawable.lockedlevel);
			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		level1View.setText("HighScore: " + userDataBase.getHighScore(1));
//		level2View.setText("HighScore: " + userDataBase.getHighScore(2));

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
		case R.id.startlevel2:
			level = 2;
			break;
		case R.id.startlevel3:
			level = 3;
			break;
		case R.id.startlevel4:
			level = 4;
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
//			level1View.setText("HighScore: " + userDataBase.getHighScore(1));
//			level2View.setText("HighScore: " + userDataBase.getHighScore(2));
			
			
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

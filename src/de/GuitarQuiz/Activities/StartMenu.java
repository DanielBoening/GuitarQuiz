package de.GuitarQuiz.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.MusikMonksSolution.guitarquiz.R;
import de.GuitarQuiz.Classes.*;

public class StartMenu extends Activity {
	private ProgressBar progressBar;
	UserDataBase userData;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.startpage);
		userData = new UserDataBase();
		userData.load(this);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		progressBar.setMax(100);
		int progress = 40;
		progress = calculateProgress();
		setProgressBar(progress);

		
		
	}
	

	private int calculateProgress() {
		int allChords = ChordLibrary.countAllChords();
		int userRightAnswers = userData.getOverAllHighscore();
		double progress = (userRightAnswers*100) / allChords;
		return (int) progress;
	}


	private void setProgressBar(int progress) {
		progressBar.setProgress(progress);
		TextView progressView = (TextView) findViewById(R.id.ProgressView);
		progressView.setText("Fortschritt: "+progress+"%");		
	}

	public void play(View v) {
		Intent myIntent = new Intent(StartMenu.this, MenuSelect.class);
		StartMenu.this.startActivity(myIntent);
	}
	
	public void facebookShare(View v){
		
	}

}

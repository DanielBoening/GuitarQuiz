package de.GuitarQuiz.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.ChordLibrary;
import de.GuitarQuiz.Classes.UserDataBase;

public class GameOver extends Activity {

	private static int rightAnswers = 0;
	private static int falseAnswers = 0;
	private ProgressBar progressBar;
	private static UserDataBase userData;
	private static int level = 0;
	private static boolean newHighScore = false;
	private ChordLibrary chordsLibrary = new ChordLibrary();
	TextView ViewRightAnswers;
	TextView ViewFalseAnswers;
	TextView ViewLevel;
	TextView ViewGameOver;
	TextView ViewMedal;





	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.gameover);

		initialiseLayoutVars();

		progressBar.setMax(100);
		userData = new UserDataBase();
		userData.load(this);

		printProgress();

	}
	
	public static void setLevel(int level) {
		GameOver.level = level;
	}

	
	public static void setRightAnswers(int rightAnswers) {
		GameOver.rightAnswers = rightAnswers;
	}



	public static void setFalseAnswers(int falseAnswers) {
		GameOver.falseAnswers = falseAnswers;
	}

	private void printProgress() {
		int progress = calculateProgress();
		setProgressBar(progress);
		ViewRightAnswers.setText("Richtige Antworten: "+rightAnswers);
		ViewFalseAnswers.setText("Falsche Antworten: "+falseAnswers);
		ViewLevel.setText("Level "+level);
		if(newHighScore){
			ViewGameOver.setText("Neuer High Score!");
		}
		else{
			ViewGameOver.setText("Spiel zu Ende");
		}
		int medal = chordsLibrary.getMedal(level, rightAnswers);
		String medalText = chordsLibrary.getMedalText(medal);
		ViewMedal.setText("Medallie: "+medalText);
	}

	private void initialiseLayoutVars() {
		progressBar = (ProgressBar) findViewById(R.id.GO_progressBar);
		ViewRightAnswers = (TextView) findViewById(R.id.GO_rightAnswers);
		ViewFalseAnswers = (TextView) findViewById(R.id.GO_falseAnswers);
		ViewLevel = (TextView) findViewById(R.id.GO_Level);
		ViewGameOver = (TextView) findViewById(R.id.GO_GameOver);
		ViewMedal  = (TextView) findViewById(R.id.GO_medal);
		
	}

	private void setProgressBar(int progress) {
		progressBar.setProgress(progress);
		TextView progressView = (TextView) findViewById(R.id.ProgressView);
		progressView.setText("Fortschritt: " + progress + "%");
	}

	public static void setUserDataBase(UserDataBase database) {
		userData = database;
	}
	
	public static void setNewHighScore(boolean newHighScore) {
		GameOver.newHighScore = newHighScore;
	}

	private int calculateProgress() {
		int allChords = ChordLibrary.countAllChords();
		int userRightAnswers = userData.getOverAllHighscore();
		double progress = (userRightAnswers * 100) / allChords;
		return (int) progress;
	}

}

package de.GuitarQuiz.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

public class UserDataBase {
	String DATABASE_FILE = "databasefile.csv";
	int LEVEL_ANZAHL = 10;
	private int[] highScore = new int[LEVEL_ANZAHL];
	String seperator = ",";
	Activity activity;
	
	public void resetDataBase(){
		for(int i=0; i < highScore.length; i++){
			saveHighScore(i, 0);
		}
	}
	
	public int getPossibleScore(int level){
		return ChordLibrary.createChordList(level).size();
	}
	
	public int getHighScore(int level){
		return highScore[level];
	}
	
	public int getOverAllHighscore(){
		int overAllHighScore = 0;
		for(int i:highScore)
			overAllHighScore+=i;
		return overAllHighScore;
	}
	
	public void updateHighScore(int level, int score){
		if(highScore[level] < score){
			saveHighScore(level, score);
		}
	}
	public void saveHighScore(int level, int score) {
		highScore[level] = score;

		File file = new File("assets/"+DATABASE_FILE);
		FileWriter writer;
		AssetManager mngr;

		try {
			mngr = activity.getAssets();
			FileOutputStream fos = activity.openFileOutput(DATABASE_FILE, activity.MODE_WORLD_READABLE);
			OutputStreamWriter out = new OutputStreamWriter(fos);
//			out.write("Test aus File");
//			out.flush();
//			out.close();


			for (int i = 0; i < highScore.length; i++) {
				out.write(i + seperator + " " + highScore[i]);
				out.write(System.getProperty("line.separator")); // Leerzeile

			}
			out.flush(); // Stream in Datei schreiben
			out.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load(Activity activity) {
		this.activity = activity;
		// Initialise Array
		for (int i = 0; i < highScore.length; i++) {
			highScore[i] = 0;
		}
		AssetManager mngr;
		String line = "";

		try {
			mngr = activity.getAssets();
			FileInputStream fis = activity.openFileInput(DATABASE_FILE);
			InputStreamReader isr = new InputStreamReader(fis);	
//			InputStream is = mngr.open(DATABASE_FILE);
//			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
		



			while ((line = br.readLine()) != null) {

				String[] content = line.split(seperator);
				if (content.length != 0) {

					String indexString = content[0].trim();
					String valueString = content[1].trim();
					int index = Integer.valueOf(indexString);
					int value = Integer.valueOf(valueString);
//					Toast.makeText(activity.getApplicationContext(),"Index: "+index, Toast.LENGTH_SHORT).show();
//					Toast.makeText(activity.getApplicationContext(),"Value: "+value, Toast.LENGTH_SHORT).show();

					highScore[index] = value; 
//					Toast.makeText(activity.getApplicationContext(),"Added", Toast.LENGTH_SHORT).show();

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


}

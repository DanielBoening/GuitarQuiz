package de.GuitarQuiz.Activities;
import java.util.ArrayList;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.Chord;
import android.app.Activity;
import android.os.Bundle;


public class Quiz extends Activity{
	ArrayList <Chord> chords = new ArrayList<Chord>();
	String[] names = {"D-Moll","D-Dur"};
	int[][] fingers = {{1,12,8,0,0},{12,2,8,0,0}};
	int[][] isPlayed = {{0,0,0,0,2,1,1},{0,0,0,2,1,1}};
	
//	public static void Main(String[] agrs){
//		System.out.println("Hallo");
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		
	}
	protected void creatChords(){
		addChord(names[0],fingers[0],isPlayed[0]);
		addChord(names[1],fingers[1],isPlayed[1]);
	}
	
	protected void addChord(String name,int[] fingers, int[] isPlayed){
		Chord dummy = new Chord(name,fingers,isPlayed);
		chords.add(dummy);
	}
	
}

		
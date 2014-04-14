package de.GuitarQuiz.Activities;
import java.util.ArrayList;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.Chord;
import android.app.Activity;
import android.os.Bundle;


public class Quiz extends Activity{
	ArrayList<String> chords = new ArrayList<String>();
	
//	public static void Main(String[] agrs){
//		System.out.println("Hallo");
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		
	}
	protected void createChord(String name,int[] fingers, int[] os, int[] xs){
		Chord dummy = new Chord(name,fingers,os,xs);
	}
	
}

		

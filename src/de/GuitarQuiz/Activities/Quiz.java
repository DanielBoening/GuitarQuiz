package de.GuitarQuiz.Activities;
import java.util.ArrayList;

import com.MusikMonksSolution.guitarquiz.R;

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

		
}

package de.GuitarQuiz.Classes;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.MusikMonksSolution.guitarquiz.R;

public class ChordCreator {
	Chord chord;
	Activity activity;
	
	
	public ChordCreator(Activity context) {
		super();
		this.activity = context;
	}


	public void setChord(Chord c) {
		this.chord = c;
		ImageView chordPattern = (ImageView) activity.findViewById(R.id.ChordPattern);
		RelativeLayout.LayoutParams chordParam = (RelativeLayout.LayoutParams) chordPattern.getLayoutParams();
		Tuple chordStartPoint = new Tuple(chordParam.leftMargin,chordParam.topMargin);
		Tuple chordEndPoint = new Tuple(chordParam.leftMargin+chordParam.width,chordParam.topMargin+chordParam.height);
		
		ImageView finger1 = (ImageView) activity.findViewById(R.id.quiz_finger1);
		RelativeLayout.LayoutParams finger1Params= (RelativeLayout.LayoutParams) finger1.getLayoutParams();
		finger1Params.setMargins(200, 30, 50, 50);
		
	}
}

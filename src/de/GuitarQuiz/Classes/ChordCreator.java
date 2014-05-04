package de.GuitarQuiz.Classes;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.MusikMonksSolution.guitarquiz.R;

public class ChordCreator {
	static int ANZAHL = 5; // Anzahl der Spalten
	static int STRINGS = 6;
	Chord chord;
	Activity activity;
	Tuple IMG_START;
	Tuple IMG_END;
	static Tuple BORDER_X = new Tuple(90,-20); //Border Links und Rechts, wo kein Bild platziert werden darf
	static Tuple BORDER_Y = new Tuple(24,20); //Border Oben und Unten, wo kein Bild platziert werden darf

	
	
	public ChordCreator(Activity context) {
		super();
		this.activity = context;
	}


	public void setChord(Chord c) {
		this.chord = c;
		ImageView chordPattern = (ImageView) activity.findViewById(R.id.ChordPattern);
		RelativeLayout.LayoutParams chordParam = (RelativeLayout.LayoutParams) chordPattern.getLayoutParams();
		IMG_START = new Tuple(chordParam.leftMargin,chordParam.topMargin);
		int imageWidth = chordPattern.getWidth();
//		IMG_END = new Tuple(chordParam.leftMargin+chordPattern.getWidth(),chordParam.topMargin+chordPattern.getHeight());
		IMG_END = new Tuple(407,290);

		
		placeImage(R.id.quiz_finger1, chord.getFingerPoints()[0]);
		placeImage(R.id.quiz_finger2, chord.getFingerPoints()[1]);
		placeImage(R.id.quiz_finger3, chord.getFingerPoints()[2]);
		placeImage(R.id.quiz_finger4, chord.getFingerPoints()[3]);
//		ImageView finger1 = (ImageView) activity.findViewById(R.id.quiz_finger1);
//		RelativeLayout.LayoutParams finger1Params= (RelativeLayout.LayoutParams) finger1.getLayoutParams();
//		Tuple finger1Position = getImagePosition(28);
//		finger1Params.setMargins(finger1Position.getX(), finger1Position.getY(), 0, 0);
//		Helper.log("IMG_START: "+IMG_START);
//		Helper.log("IMG_END: "+IMG_END);
//		Helper.log("Bildbreite: "+chordPattern.getWidth() + " oder "+ imageWidth);
//		Helper.log("Bildhöhe: "+chordPattern.getHeight());
		
		
	}
	
	
	private void placeImage(int imgID, int i) {
		ImageView finger1 = (ImageView) activity.findViewById(imgID);
		finger1.setVisibility(View.VISIBLE);
		RelativeLayout.LayoutParams finger1Params= (RelativeLayout.LayoutParams) finger1.getLayoutParams();
		Tuple finger1Position = getImagePosition(i);
		finger1Params.setMargins(finger1Position.getX(), finger1Position.getY(), 0, 0);
		if(i == 0){
			finger1.setVisibility(View.INVISIBLE);
		}
	}


	public Tuple getImagePosition(int number){
		
		return new Tuple(getXPosition(number), getYPosition(number));
	}
	
	
	/**
	 * Returns the current X-Coordinate for any Position depending on the current Image Scale
	 * @param x Position
	 * @return
	 */
	public int getXPosition(int x){
		x = x % ANZAHL; // g(1) = 1, g(6) =1, g(7) = 2, ...
		if(x==0) x = 5;
		int delta = (IMG_END.getX() - IMG_START.getX() - BORDER_X.getSum()) / (ANZAHL-1); //Abstand
		return BORDER_X.getX() + (x-1) * delta;	
	}
	
	/**
	 * Returns the current Y-Coordinate for any Position depending on the current Image Scale
	 * @param y Position
	 * @return
	 */
	public int getYPosition(int y){
		y = (int) Math.ceil((double) y / ANZAHL); // f(1) = 1, f(6) = 2, ...
		int delta = (IMG_END.getY() - IMG_START.getY() - BORDER_Y.getSum()) / (STRINGS-1); //Abstand
		return BORDER_Y.getX() + (y-1) * delta;	
	}
}

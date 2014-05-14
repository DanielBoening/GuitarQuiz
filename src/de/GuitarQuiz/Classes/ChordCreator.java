package de.GuitarQuiz.Classes;

import android.app.Activity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.MusikMonksSolution.guitarquiz.R;

public class ChordCreator {
	static int ANZAHL = 5; // Anzahl der Spalten
	static int STRINGS = 6;
	Chord chord;
	Activity activity;
	Tuple IMG_START;
	Tuple IMG_END;
	static Tuple BORDER_X = new Tuple(90,0); //Border Links und Rechts, wo kein Bild platziert werden darf
	static Tuple BORDER_Y = new Tuple(7,40); //Border Oben und Unten, wo kein Bild platziert werden darf

	
	
	public ChordCreator(Activity context) {
		super();
		this.activity = context;
	}


	public void setChord(Chord c) {
		this.chord = c;
		final ImageView chordPattern = (ImageView) activity.findViewById(R.id.ChordPattern);
		chordPattern.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		RelativeLayout.LayoutParams chordParam = (RelativeLayout.LayoutParams) chordPattern.getLayoutParams();
		//IMG_START = new Tuple(chordParam.leftMargin,chordParam.topMargin);
		int imageWidth = chordPattern.getWidth();
		//IMG_END = new Tuple(chordParam.leftMargin+chordPattern.getMeasuredWidth(),chordParam.topMargin+chordPattern.getMeasuredHeight());
	
		
		
		
//		IMG_START = new Tuple(50,250);
//		IMG_END = new Tuple(407,345);
		
		final RelativeLayout chordLayout = (RelativeLayout) activity.findViewById(R.id.RelativeLayout2);
		chordLayout.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int[] locations = new int[2];
		chordPattern.getLocationOnScreen(locations);
//		int leftMargin = locations[0];
		int leftMargin = (int) ((int) chordParam.width / (4.80));
		int topMargin = (int) ((int) chordParam.height / (26.00));
		IMG_START = new Tuple(locations[0],locations[1]);
		IMG_END = new Tuple(locations[0]+chordPattern.getMeasuredWidth(), locations[1]+chordPattern.getMeasuredHeight());
		BORDER_X = new Tuple(leftMargin,0); 
		BORDER_Y = new Tuple(topMargin,0);
		
		
		Helper.log("Left Margin: "+leftMargin);
		Helper.log("Top Margin: "+topMargin);
		Helper.log("Start: "+IMG_START);
		Helper.log("End: "+IMG_END);
		
		int width = chordLayout.getMeasuredWidth();
		int height  = chordLayout.getMeasuredHeight();
		
		//Helper.log("Höhe: "+height);

		//onPreDrawListstener, onGlobalLayout

		

	//	placeImage(R.id.quiz_finger1, 100, 100);
//		placeImage(R.id.quiz_finger1, 1);
	
		Toast.makeText(activity.getApplicationContext(),
				"Accord "+chord.getName()+" wird geprintet", Toast.LENGTH_SHORT)
				.show();
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

	private void placeImage(int imgID, int x, int y) {
		ImageView finger1 = (ImageView) activity.findViewById(imgID);
		finger1.setVisibility(View.VISIBLE);
		RelativeLayout.LayoutParams finger1Params= (RelativeLayout.LayoutParams) finger1.getLayoutParams();
		Tuple finger1Position = new Tuple(x,y);
		finger1Params.setMargins(finger1Position.getX(), finger1Position.getY(), 0, 0);

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

package de.GuitarQuiz.Activities;

import java.util.ArrayList;
import java.util.Random;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.Chord;
import de.GuitarQuiz.Classes.ChordCreator;
import de.GuitarQuiz.Classes.Helper;
import de.GuitarQuiz.Classes.Tuple;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.Window;
import android.view.WindowManager;
=======
import android.view.View;
import android.widget.Button;
>>>>>>> b5de3f24f54dcd85b655239090931e5ec89a54d5
=======
import android.view.View;
import android.widget.Button;
>>>>>>> b5de3f24f54dcd85b655239090931e5ec89a54d5
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Quiz extends Activity {
	ArrayList<Chord> chords = new ArrayList<Chord>();
	String[] names = { "D-Moll", "D-Dur", "E", "E-Moll" };
	int[][] fingers = { { 1, 12, 8, 0, 0 }, { 12, 2, 8, 0, 0 },
			{ 11, 22, 17, 0, 0 }, { 0, 22, 17, 0, 0 } };
	int[][] isPlayed = { { 0, 0, 0, 0, 2, 1, 1 }, { 0, 0, 0, 2, 1, 1 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

	private int rightAccord = 0; // Richtiger Acccord noch nicht gesetzt
	ChordCreator creator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.quiz);
		creatChords();

	}

	@Override
	protected void onResume() {
		creator = new ChordCreator(this);
		// creator.setChord(chords.get(0));
		Chord randomChord = chords.get((new Random()).nextInt(chords.size()));

		creator.setChord(randomChord);
		super.onResume();
		printAnswersToButton(randomChord, (ArrayList<Chord>) chords.clone());
	}

	public int printAnswersToButton(Chord right, ArrayList<Chord> others) {
		Button button1 = (Button) this.findViewById(R.id.quiz_b1);
		Button button2 = (Button) this.findViewById(R.id.quiz_b2);
		Button button3 = (Button) this.findViewById(R.id.quiz_b3);
		Button button4 = (Button) this.findViewById(R.id.quiz_b4);

		ArrayList<Button> buttons = new ArrayList<Button>();
		ArrayList<Integer> used = new ArrayList<Integer>();

		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);

		rightAccord = (new Random()).nextInt(buttons.size());
		
		Helper.log("Generating new Random: "+rightAccord);
		buttons.get(rightAccord).setText(right.getName());
		used.add(rightAccord);
		Helper.log("Added "+right.getName()+" to Button " +rightAccord);
		others.remove(right);

		while (used.size() <= 3) {

			int randomNumber = (new Random()).nextInt(buttons.size());

			if (used.contains((Integer) randomNumber)) {
				continue;
			} else {
				int randomChordNumber = (new Random()).nextInt(others.size());

				Chord randomChord = others.get(randomChordNumber);
				buttons.get(randomNumber).setText(randomChord.getName());

				used.add(randomNumber);
				others.remove(randomChord);
			}
		}

		return rightAccord;
<<<<<<< HEAD
	}

	public void onClick(View v) {
		int selectedButton = 0;
		String outputString = "";
		TextView t = (TextView) findViewById(R.id.textView1);
		boolean nextround = false;

		switch (v.getId()) {
		case R.id.quiz_b1:
			selectedButton = 0;
			// Button b = ((Button) v);

			break;
		case R.id.quiz_b2:
			selectedButton = 1;
			break;
		case R.id.quiz_b3:
			selectedButton = 2;
			break;
		case R.id.quiz_b4:
			selectedButton = 3;
			break;
		case R.id.nextRound:
			nextround = true;
			Chord randomChord = chords.get((new Random()).nextInt(chords.size()));
			creator.setChord(randomChord);
			printAnswersToButton(randomChord, (ArrayList<Chord>) chords.clone());		
			break;

		}

		if(selectedButton == rightAccord){
			outputString = "Richtig!! ("+rightAccord+")";
		}
		else{
			outputString = "Leider Falsch  ("+rightAccord+")";
		}

		if(nextround){
			outputString = "Wähle einen Button!";
		}
		t.setText(outputString);
	}

	protected void creatChords() {
		addChord(names[0], fingers[0], isPlayed[0]);
		addChord(names[1], fingers[1], isPlayed[1]);
		addChord(names[2], fingers[2], isPlayed[2]);
		addChord(names[3], fingers[3], isPlayed[3]);

	}

=======
	}

	public void onClick(View v) {
		int selectedButton = 0;
		String outputString = "";
		TextView t = (TextView) findViewById(R.id.textView1);
		boolean nextround = false;

		switch (v.getId()) {
		case R.id.quiz_b1:
			selectedButton = 0;
			// Button b = ((Button) v);

			break;
		case R.id.quiz_b2:
			selectedButton = 1;
			break;
		case R.id.quiz_b3:
			selectedButton = 2;
			break;
		case R.id.quiz_b4:
			selectedButton = 3;
			break;
		case R.id.nextRound:
			nextround = true;
			Chord randomChord = chords.get((new Random()).nextInt(chords.size()));
			creator.setChord(randomChord);
			printAnswersToButton(randomChord, (ArrayList<Chord>) chords.clone());		
			break;

		}

		if(selectedButton == rightAccord){
			outputString = "Richtig!! ("+rightAccord+")";
		}
		else{
			outputString = "Leider Falsch  ("+rightAccord+")";
		}

		if(nextround){
			outputString = "Wähle einen Button!";
		}
		t.setText(outputString);
	}

	protected void creatChords() {
		addChord(names[0], fingers[0], isPlayed[0]);
		addChord(names[1], fingers[1], isPlayed[1]);
		addChord(names[2], fingers[2], isPlayed[2]);
		addChord(names[3], fingers[3], isPlayed[3]);

	}

>>>>>>> b5de3f24f54dcd85b655239090931e5ec89a54d5
	protected void addChord(String name, int[] fingers, int[] isPlayed) {
		Chord dummy = new Chord(name, fingers, isPlayed);
		chords.add(dummy);

	}

}

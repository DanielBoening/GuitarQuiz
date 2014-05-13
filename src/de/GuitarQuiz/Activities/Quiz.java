package de.GuitarQuiz.Activities;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.Chord;
import de.GuitarQuiz.Classes.ChordCreator;

public class Quiz extends Activity {
	ArrayList<Chord> chords = new ArrayList<Chord>();
	private Chord rightChordItem;
	private Button rightButton;
	int round = 0;
	boolean buttonIsGreen = false;

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
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.quiz);
		creatChords();

	}

	@Override
	protected void onResume() {
		super.onResume();

		final RelativeLayout chordLayout = (RelativeLayout) this
				.findViewById(R.id.RelativeLayout2);
		final Activity correntActivity = this;
		chordLayout.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {

					@Override
					public void onGlobalLayout() {

						creator = new ChordCreator(correntActivity);
						prepareForNextRound();
						/**
						 * // Select Random Chord Chord randomChord =
						 * chords.get((new Random()) .nextInt(chords.size()));
						 * rightChordItem = randomChord;
						 * creator.setChord(randomChord);
						 * printAnswersToButton(randomChord, (ArrayList<Chord>)
						 * chords.clone());
						 **/
						chordLayout.getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);

					}

				});

	}

	Handler rightButtonHandler = new Handler();
	private Runnable letRightButtonBlink = new Runnable() {
		public void run() {
			try {
				if (!buttonIsGreen) {
					rightButton.setBackgroundResource(R.drawable.correctanswer);
					buttonIsGreen = true;
				} else {
					rightButton.setBackgroundResource(R.drawable.answerbutton);
					buttonIsGreen = false;
				}

				// Toast.makeText(getApplicationContext(), ""+buttonIsGreen,
				// Toast.LENGTH_LONG).show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	Handler rightButtonGreyHandler = new Handler();
	private Runnable changeRightButtonGrey = new Runnable() {
		public void run() {
			try {
				rightButton.setBackgroundResource(R.drawable.answerbutton);
				buttonIsGreen = false;

				// Toast.makeText(getApplicationContext(), ""+buttonIsGreen,
				// Toast.LENGTH_LONG).show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	Handler startNextRoundHandler = new Handler();
	private Runnable runNextRound = new Runnable() {
		public void run() {
			try {

				Toast.makeText(getApplicationContext(),
						"Nächste Runde startet jetzt", Toast.LENGTH_LONG)
						.show();
				prepareForNextRound();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	public int printAnswersToButton(Chord right, ArrayList<Chord> others) {

		ArrayList<Button> buttons = getButtonList();
		ArrayList<Integer> used = new ArrayList<Integer>();

		rightAccord = (new Random()).nextInt(buttons.size());

		// Helper.log("Generating new Random: "+rightAccord);
		buttons.get(rightAccord).setText(right.getName());
		used.add(rightAccord);
		// Helper.log("Added "+right.getName()+" to Button " +rightAccord);
		others.remove(right);
		rightButton = buttons.get(rightAccord);

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
	}

	public ArrayList<Button> getButtonList() {
		Button button1 = (Button) this.findViewById(R.id.quiz_b1);
		Button button2 = (Button) this.findViewById(R.id.quiz_b2);
		Button button3 = (Button) this.findViewById(R.id.quiz_b3);
		Button button4 = (Button) this.findViewById(R.id.quiz_b4);

		ArrayList<Button> buttons = new ArrayList<Button>();

		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);

		return buttons;

	}

	public void onClick(View v) {
		// Button Config
		int startBlinking = 500;
		int blinkingDuration = 250;
		int timesOfBlinking = 5;

		int selectedButton = 0;
		String outputString = "";
		TextView t = (TextView) findViewById(R.id.textView1);

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

		}

		if (selectedButton == rightAccord) {
			// Richtige antwort ausgewählt

			Button correctButton = (Button) findViewById(v.getId());
			correctButton.setBackgroundResource(R.drawable.correctanswer);

		} else {
			// Falsche Antwort
			Button falseButton = (Button) findViewById(v.getId());
			falseButton.setBackgroundResource(R.drawable.falseanswer);

			for (int i = 0; i < timesOfBlinking; i++) {
				rightButtonHandler.postDelayed(letRightButtonBlink,
						startBlinking + blinkingDuration * i);
			}

		}

		startNextRoundHandler.postDelayed(runNextRound, startBlinking
				+ blinkingDuration * timesOfBlinking + 200);

		t.setText(outputString);
	}

	private void prepareForNextRound() {

		// try {
		// Thread.sleep(1500);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		round++;
		ArrayList<Button> buttons = getButtonList();

		for (Button b : buttons) {
			b.setBackgroundResource(R.drawable.answerbutton);
		}

		Chord randomChord = chords.get((new Random()).nextInt(chords.size()));
		rightChordItem = randomChord;
		creator.setChord(randomChord);
		printAnswersToButton(randomChord, (ArrayList<Chord>) chords.clone());

	}

	protected void creatChords() {
		addChord(names[0], fingers[0], isPlayed[0]);
		addChord(names[1], fingers[1], isPlayed[1]);
		addChord(names[2], fingers[2], isPlayed[2]);
		addChord(names[3], fingers[3], isPlayed[3]);

	}

	protected void addChord(String name, int[] fingers, int[] isPlayed) {
		Chord dummy = new Chord(name, fingers, isPlayed);
		chords.add(dummy);

	}

}

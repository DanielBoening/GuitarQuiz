package de.GuitarQuiz.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.MusikMonksSolution.guitarquiz.R;

import de.GuitarQuiz.Classes.UserDataBase;

public class Settings extends Activity implements OnClickListener {
	private static UserDataBase userData;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.settings);
		// TODO Auto-generated method stub
	}
	
	public static void setUserDataBase(UserDataBase database){
		userData = database;
	}

	public void resetDatabase(View v) {
		AlertDialog ad = new AlertDialog.Builder(this)
				.setMessage(
						"Achtung.\nSollen deine Daten wirklich unwiderruflich gelöscht werden?")
				.setIcon(R.drawable.ic_launcher).setTitle("Daten löschen")
				.setPositiveButton("Ja", this).setNegativeButton("Nein", this)
				.setCancelable(false).create();
		ad.show();
		;

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		switch (which) {
		case DialogInterface.BUTTON_POSITIVE: // yes
			userData.resetDataBase();


			break;
		case DialogInterface.BUTTON_NEGATIVE: // no

			break;
		case DialogInterface.BUTTON_NEUTRAL: // neutral
			break;
		default:
			// nothing
			break;
		}
	}
}

package de.GuitarQuiz.Classes;

import java.util.ArrayList;

public class ChordLibrary {
	/* ########## Legende ########## 
	 * X^=1
	 * O^=2
	 * 
	 * */
	
	
	/* ########## Level 1 ########## */
	
	private static String[] namesLevel1 = { 
			"D-Moll", 
			"D-Dur", 
			"E", 
			"E-Moll", 
			"A", 
			"G", 
			"C", 
			"A-Moll" 
			};
	private static int[][] fingersLevel1 = { 
			{ 1, 12, 8, 0, 0 }, 	//D-Moll
			{ 12, 2, 8, 0, 0 },		//D-Dur
			{ 11, 22, 17, 0, 0 }, 	//E
			{ 0, 22, 17, 0, 0 }, 	//E-Moll
			{ 12, 17, 7, 0, 0 }, 	//A
			{ 22, 28, 3, 0, 0 }, 	//G
			{ 6, 17, 23, 0, 0 }, 	//C
			{ 6, 12, 17, 0, 0 } 	//A-Moll
			};
	private static int[][] isPlayedLevel1 = { 
			{ 0, 0, 0, 2, 1, 1 }, 	//D-Moll
			{ 0, 0, 0, 2, 1, 1 },	//D-Dur
			{ 2, 2, 0, 0, 0, 2 }, 	//E
			{ 2, 2, 2, 0, 0, 2 }, 	//E-Moll
			{ 0, 2, 0, 0, 2, 1 }, 	//A
			{ 0, 2, 2, 2, 0, 0 }, 	//G
			{ 2, 0, 2, 0, 0, 1 }, 	//C
			{ 2, 0, 0, 0, 2, 1 } 	//A-Moll
			};
	
	
	/* ########## Level 2 ########## */
	
	private static String[] namesLevel2 = { 
			"G 7", 
			"C 7", 
			"B 7", 
			"A 7", 
			"D 7", 
			"E 7", 
			};
	private static int[][] fingersLevel2 = { 
			{ 1, 22, 28, 0, 0 }, 	// G7
			{ 6, 17, 23, 13, 0 }, 	// C7
			{ 16, 22, 12, 2, 0 }, 	// B7
			{ 17, 0, 7, 0, 0 }, 	// A7
			{ 6, 12, 2, 0, 0 }, 	// D7
			{ 11, 22, 0, 0, 0 }, 	// E7
			};
	private static int[][] isPlayedLevel2 = { 
			{ 0, 2, 2, 2, 0, 0 }, 	// G7 
			{ 2, 0, 0, 0, 0, 1 }, 	// C7
			{ 0, 2, 0, 0, 0, 1 }, 	// B7
			{ 2, 0, 2, 0, 2, 1 }, 	// A7
			{ 0, 0, 0, 2, 1, 1 }, 	// D7
			{ 2, 2, 0, 2, 0, 2 }, 	// E7

			};
	
	
	
	public static ArrayList<Chord> createChordList(int level){
		ArrayList<Chord> chords = new ArrayList<Chord>();
		String[] names = getNames(level);
		int[][] fingers = getFingersLevel(level);
		int[][] isPlayed = getIsPlayedLevel(level);
		for(int i = 0; i < names.length; i++){
			Chord dummy = new Chord(names[i], fingers[i], isPlayed[i]);
			chords.add(dummy);
		}
		
		return chords;
	}
	
	
	
	public static String[] getNames(int i){
		switch (i) {
			case 1:
				return namesLevel1;
			case 2:
				return namesLevel2;
			default:
				// TODO
		}
		return null;
	}
	
	public static int[][] getFingersLevel(int i){
		switch (i) {
			case 1:
				return fingersLevel1;
			case 2:
				return fingersLevel2;
			default:
				// TODO
		}
		return null;
	}
	
	public static int[][] getIsPlayedLevel(int i){
		switch (i) {
			case 1:
				return isPlayedLevel1;
			case 2:
				return isPlayedLevel2;
			default:
				// TODO
		}
		return null;
	}
	
}

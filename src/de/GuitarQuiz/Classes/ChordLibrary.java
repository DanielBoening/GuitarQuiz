package de.GuitarQuiz.Classes;

public class ChordLibrary {
	/* ########## Legende ########## 
	 * X^=1
	 * O^=2
	 * 
	 * */
	
	
	/* ########## Level 1 ########## */
	
	private String[] namesLevel1 = { 
			"D-Moll", 
			"D-Dur", 
			"E", 
			"E-Moll", 
			"A", 
			"G", 
			"C", 
			"A-Moll" 
			};
	private int[][] fingersLevel1 = { 
			{ 1, 12, 8, 0, 0 }, 	//D-Moll
			{ 12, 2, 8, 0, 0 },		//D-Dur
			{ 11, 22, 17, 0, 0 }, 	//E
			{ 0, 22, 17, 0, 0 }, 	//E-Moll
			{ 12, 17, 7, 0, 0 }, 	//A
			{ 22, 28, 15, 0, 0 }, 	//G
			{ 6, 17, 23, 0, 0 }, 	//C
			{ 6, 12, 17, 0, 0 } 	//A-Moll
			};
	private int[][] isPlayedLevel1 = { 
			{ 0, 0, 0, 2, 1, 1 }, 	//D-Moll
			{ 0, 0, 0, 2, 1, 1 },	//D-Dur
			{ 2, 2, 0, 0, 0, 2 }, 	//E
			{ 2, 2, 2, 0, 0, 2 }, 	//E-Moll
			{ 0, 2, 0, 0, 2, 1 }, 	//A
			{ 0, 2, 2, 2, 0, 0 }, 	//G
			{ 2, 0, 2, 0, 0, 1 }, 	//C
			{ 2, 0, 0, 0, 2, 1 } 	//A-Moll
			};
	
	
	
}

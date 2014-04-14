package de.GuitarQuiz.Classes;

public class Chord {
	
	private String name;
	private int[] fingerPoints = new int [5]; 
	// defines the fingers Position [0,3,2,9,0] -> finger 2 lies on pos 3, finger 3 on pos 9...  
	private int[] isxo = new int [7];
	// defines which Strings are played 0 = finger on it, 1 = not played, 2 = played empty  
	
	public Chord(String name, int[] fingerPoints, int[] isPlayed){
		this.name = name;
		this.fingerPoints = fingerPoints;
		this.isxo = isPlayed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public int[] getFingerPoints() {
		return fingerPoints;
	}

	public void setFingerPoints(int[] fingerPoints) {
		fingerPoints = fingerPoints;
	}


}

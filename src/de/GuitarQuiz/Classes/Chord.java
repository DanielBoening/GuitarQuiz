package de.GuitarQuiz.Classes;

public class Chord {
	
	private String name;
	private int[] fingerPoints = new int [5]; 
	// defines the fingers Position [0,3,2,9,0] -> finger 2 lies on pos 3, finger 3 on pos 9...  
	private int[] isxo = new int [7];
	// defines which Strings are played 0 = finger on it, 1 = not played (X) , 2 = played empty (O)  
	
	public Chord(String name, int[] fingerPoints, int[] isPlayed){
		this.name = name;
		this.fingerPoints = fingerPoints;
		this.isxo = isPlayed;
	}

	public int getPlayedString(int i){
		return isxo[i];
	}
	
	public String getPlayedSign(int i){
		int stringSign = isxo[i];
		if(stringSign==2){
			return "O";
		}
		else if(stringSign==1){
			return "X";
		}
		else{
			return "";
		}
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

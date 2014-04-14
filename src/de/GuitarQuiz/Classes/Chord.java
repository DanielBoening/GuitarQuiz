package de.GuitarQuiz.Classes;

public class Chord {
	
	private String Name;
	private int[] FingerPoints = new int [30];
	private int[] XStrings = new int [6];
	private int[] OStrings = new int [6];
	
	public Chord(String Name, int[] FingerPoints, int[] XStrings, int[] OStrings){
		this.Name = Name;
		this.FingerPoints = FingerPoints;
		this.XStrings = XStrings;
		this.OStrings = OStrings;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int[] getFingerPoints() {
		return FingerPoints;
	}

	public void setFingerPoints(int[] fingerPoints) {
		FingerPoints = fingerPoints;
	}

	public int[] getXStrings() {
		return XStrings;
	}

	public void setXStrings(int[] xStrings) {
		XStrings = xStrings;
	}

	public int[] getOStrings() {
		return OStrings;
	}

	public void setOStrings(int[] oStrings) {
		OStrings = oStrings;
	}

}

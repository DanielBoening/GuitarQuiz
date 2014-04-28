package de.GuitarQuiz.Classes;
public class Tuple {
	int x;
	int y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSum() {
		return x + y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

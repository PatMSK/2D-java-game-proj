package logic;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Target extends Sphere {
	private int score;

	public Target(int radius, Color color) {
		super(radius);
		super.setMaterial(new PhongMaterial(color));
	}

	public double getX() {
		return this.getTranslateX();
	}

	public void setX(double x) {
		this.setTranslateX(x);

	}

	public double getY() {
		return this.getTranslateY();
	}

	public void setY(double y) {
		this.setTranslateY(y);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

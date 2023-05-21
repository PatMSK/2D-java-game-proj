package microshot;

import java.util.ArrayList;

import Util.RenderableHolder;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Target;
import time.Timer;

public class MicroShot extends Pane {

	private final int MAX_TARGETS = 3;
	private final int radius = 15;
	private final Color color = Color.AQUA;

	private ArrayList<Target> targets;

	private MicroShotGui microShotPane;
	private Timer countDownPane;
	private MicroShotSummary microShotSumPane;
	private Text accuracy;

	private boolean isStart = false;
	private int score = 0;
	private int shotTimes = 0;

	public MicroShot() {
		Image img = new Image("file:bg/bg.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		this.setBackground(bGround);
		this.initializeGame();

		this.setOnMouseClicked(event -> {

			if (isStart) {
				RenderableHolder.gunShotSound.play();
				MicroShotUtil.mouseClick(event.getX(), event.getY(), targets, this, radius, color);

			}
		});
	}

	private void initializeGame() {
		microShotPane = new MicroShotGui(this);
		countDownPane = new Timer();
		microShotSumPane = new MicroShotSummary(this);
		microShotSumPane.setVisible(false);
		this.getChildren().addAll(microShotPane, countDownPane, microShotSumPane);
		targets = new ArrayList<>();
		MicroShotUtil.spawnTargets(targets, this, MAX_TARGETS, radius, color);
		microShotPane.toFront();
	}

	public void gameEnd() {
		this.setCursor(Cursor.DEFAULT);
		accuracyText();
		this.getChildren().addAll(accuracy, microShotSumPane, microShotPane);
		microShotSumPane.setVisible(true);
		microShotSumPane.toFront();

	}

	private void accuracyText() {
		accuracy = new Text("Accuracy = " + this.getAccuracy() + "%");
		accuracy.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		accuracy.setFill(Color.WHITE);
		accuracy.setLayoutX(740);
		accuracy.setLayoutY(400);
	}

	private String getAccuracy() {
		return String.valueOf(this.getScore() * 100 / this.getShotTimes());
	}

	public void gameStart() {
		this.isStart = true;

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timer getCountDownPane() {
		return countDownPane;
	}

	public void setCountDownPane(Timer countDownPane) {
		this.countDownPane = countDownPane;
	}

	public MicroShotSummary getMicroShotSumPane() {
		return microShotSumPane;
	}

	public void setMicroShotSumPane(MicroShotSummary microShotSumPane) {
		this.microShotSumPane = microShotSumPane;
	}

	public int getShotTimes() {
		return shotTimes;
	}

	public void setShotTimes(int shotTimes) {
		this.shotTimes = shotTimes;
	}

}

package time;

import Util.Config;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Timer extends VBox implements CountTime{
	private Label timerLabel;

	private int seconds = 0;

	public Timer() {
		timerLabel = createTimerLabel();
		this.setPrefHeight(Config.screenHeight);
		this.setPrefWidth(Config.screenWidth);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().add(timerLabel);

	}

	private Label createTimerLabel() {
		Label label = new Label();
		label.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 120));
		label.setTextFill(Color.WHITE);
		return label;
	}

	public void startCount() {
		timerLabel.setVisible(true);
		timerLabel.setText("0");
		Timeline timeline = new Timeline();
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
			seconds++;
			timerLabel.setText(String.valueOf(seconds));
		});

		timeline.getKeyFrames().add(keyFrame);

		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}

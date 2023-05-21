package microshot;

import Util.Config;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import time.CountTime;

public class MicroShotGui extends VBox implements CountTime{
	private Button startGameButton;
	private Label countdownLabel;
	private MicroShot targetCircle;
	
	private Boolean isFirstClick = true;
	
	public MicroShotGui(MicroShot targetCircle) {
		this.setPrefHeight(Config.screenHeight);
		this.setPrefWidth(Config.screenWidth);
		this.targetCircle = targetCircle;
		this.setAlignment(Pos.CENTER);
		
		startGameButton = createStartGameButton();
		countdownLabel = createCountdownLabel();
		this.getChildren().addAll(startGameButton, countdownLabel);
		this.setOnMouseClicked(event -> {
			if (isFirstClick) {
				this.getChildren().remove(startGameButton);
				this.targetCircle.setCursor(Cursor.CROSSHAIR);
				this.isFirstClick = false;
				startCount();
			}
		});
	}
	
	private Button createStartGameButton() {
		Button button = new Button("Click to Start");
		button.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 60));
		button.setTextFill(Color.WHITE);
		button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		button.setMouseTransparent(true);
		button.setPrefWidth(Config.screenWidth);
		return button;
	}
	
	private Label createCountdownLabel() {
		Label label = new Label();
		label.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 120));
		label.setTextFill(Color.WHITE);
		return label;
	}
	
	public void startCount() {
		countdownLabel.setVisible(true);
		countdownLabel.setText("3");
		countdownLabel.setPadding(new Insets(-130, 0, 0, 0));
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> countdownLabel.setText("2")),
				new KeyFrame(Duration.seconds(2), event -> countdownLabel.setText("1")),
				new KeyFrame(Duration.seconds(3), event -> {
					countdownLabel.setVisible(false);
					countdownLabel.setText("");
				}));
		timeline.setOnFinished(event -> {
			this.targetCircle.getChildren().remove(this);
			this.targetCircle.gameStart();
			this.targetCircle.getCountDownPane().startCount();
		});
		timeline.play();
	}
}

	

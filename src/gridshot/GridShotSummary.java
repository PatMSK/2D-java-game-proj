package gridshot;

import Util.Config;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GridShotSummary extends VBox {

	private Button restartButton;
	private Button selectMode;

	public GridShotSummary(GridShot gridshot) {
		this.setPrefHeight(Config.screenHeight);
		this.setPrefWidth(Config.screenWidth);
		this.createRestartButton();
		this.selectModeButton();
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
		this.getChildren().addAll(selectMode, restartButton);

	}

	private void selectModeButton() {
		selectMode = new Button("SELECT MODE");
		selectMode.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 60));
		selectMode.setTextFill(Color.WHITE);
		selectMode.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

	}

	private void createRestartButton() {
		restartButton = new Button("RESTART");
		restartButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 60));
		restartButton.setTextFill(Color.WHITE);
		restartButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

	}

	public Button getSelectMode() {
		return selectMode;
	}

	public void setSelectMode(Button selectMode) {
		this.selectMode = selectMode;
	}

	public Button getRestartButton() {
		return restartButton;
	}

	public void setRestartButton(Button restartButton) {
		this.restartButton = restartButton;
	}

}

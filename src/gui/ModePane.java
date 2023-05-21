package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ModePane extends VBox {

	private Text selectMode;
	private Button backButton;
	private Button gridShotButton;
	private Button microShotButton;
	private Button classicButton;

	public ModePane() {
		this.setSpacing(70);
		Image img = new Image("file:bg/bg.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		this.setBackground(bGround);
		this.backButton();
		this.selectMode();
		this.gridshotMode();
		this.microShotMode();
		this.classicMode();
		this.setPadding(new Insets(100, 0, 0, 250)); // Add right margin
		this.getChildren().addAll(selectMode, gridShotButton, microShotButton, classicButton, backButton);
		;
	}

	private void selectMode() {
		selectMode = new Text("SELECT MODE");
		selectMode.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 70));
		selectMode.setFill(Color.WHITE);
		selectMode.setLayoutX(10);

	}

	private void backButton() {
		backButton = new Button("Back");
		backButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		backButton.setTextFill(Color.WHITE);
		backButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

		// hovering
		backButton.setOnMouseEntered(event -> {
			backButton.setTextFill(Color.GRAY);
		});
		backButton.setOnMouseExited(event -> {
			backButton.setTextFill(Color.WHITE);
		});

	}

	private void gridshotMode() {
		gridShotButton = new Button("GridShot");
		gridShotButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		gridShotButton.setTextFill(Color.WHITE);
		gridShotButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		// hovering
		gridShotButton.setOnMouseEntered(event -> {
			gridShotButton.setTextFill(Color.YELLOW);
		});
		gridShotButton.setOnMouseExited(event -> {
			gridShotButton.setTextFill(Color.WHITE);

		});
	}

	private void microShotMode() {
		microShotButton = new Button("MicroShot");
		microShotButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		microShotButton.setTextFill(Color.WHITE);
		microShotButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		// hovering
		microShotButton.setOnMouseEntered(event -> {
			microShotButton.setTextFill(Color.YELLOW);
		});
		microShotButton.setOnMouseExited(event -> {
			microShotButton.setTextFill(Color.WHITE);

		});
	}

	private void classicMode() {
		classicButton = new Button("Classic");
		classicButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		classicButton.setTextFill(Color.WHITE);
		classicButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		// hovering
		classicButton.setOnMouseEntered(event -> {
			classicButton.setTextFill(Color.YELLOW);
		});
		classicButton.setOnMouseExited(event -> {
			classicButton.setTextFill(Color.WHITE);

		});
	}

	public Text getSelectMode() {
		return selectMode;
	}

	public void setSelectMode(Text selectMode) {
		this.selectMode = selectMode;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public Button getGridShotButton() {
		return gridShotButton;
	}

	public void setGridShotButton(Button gridShotButton) {
		this.gridShotButton = gridShotButton;
	}

	public Button getMicroShotButton() {
		return microShotButton;
	}

	public void setMicroShotButton(Button microShotButton) {
		this.microShotButton = microShotButton;
	}

	public Button getClassicButton() {
		return classicButton;
	}

	public void setClassicButton(Button classicButton) {
		this.classicButton = classicButton;
	}

}

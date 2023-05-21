package gui;


import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class WelcomePane extends VBox {

	private Text title;
	private Button startButton;
	private Button howToPlayButton;
	private Button exitButton;

	public WelcomePane() {
		this.setSpacing(50);
		Image img = new Image("file:bg/bg.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		this.setBackground(bGround);
		this.setAlignment(Pos.CENTER);
		this.title();
		this.startButton();
		this.exitButton();
		this.howToPlayButton();
		this.getChildren().addAll(title, startButton, howToPlayButton, exitButton);
	}

	private void title() {
		title = new Text("Aim Prac");
		title.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 100));
		title.setFill(Color.WHITE);
	}

	private void startButton() {
		startButton = new Button("Start");
		startButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		startButton.setTextFill(Color.WHITE);
		startButton.setBackground(new Background(new BackgroundFill(Color.web("#0c1514"), null, null)));

		// hovering
		startButton.setOnMouseEntered(event -> {
			startButton.setTextFill(Color.GRAY);
		});
		startButton.setOnMouseExited(event -> {
			startButton.setTextFill(Color.WHITE);
		});

	}

	private void howToPlayButton() {
		howToPlayButton = new Button("How To Play");
		howToPlayButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		howToPlayButton.setTextFill(Color.WHITE);
		howToPlayButton.setBackground(new Background(new BackgroundFill(Color.web("#0c1514"), null, null)));

		// hovering
		howToPlayButton.setOnMouseEntered(event -> {
			howToPlayButton.setTextFill(Color.GRAY);
		});
		howToPlayButton.setOnMouseExited(event -> {
			howToPlayButton.setTextFill(Color.WHITE);
		});
	}

	private void exitButton() {
		exitButton = new Button("Exit");
		exitButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		exitButton.setTextFill(Color.WHITE);
		exitButton.setBackground(new Background(new BackgroundFill(Color.web("#0c1514"), null, null)));

		// hovering
		exitButton.setOnMouseEntered(event -> {
			exitButton.setTextFill(Color.GRAY);
		});

		exitButton.setOnMouseExited(event -> {
			exitButton.setTextFill(Color.WHITE);
		});

		exitButton.setOnAction(event -> nextPageExitButton());
	}

	private void nextPageExitButton() {
		Platform.exit();
	}

	public Text getTitle() {
		return title;
	}

	public void setTitle(Text title) {
		this.title = title;
	}

	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public void setExitButton(Button exitButton) {
		this.exitButton = exitButton;
	}

	public Button getHowToPlayButton() {
		return howToPlayButton;
	}

	public void setHowToPlayButton(Button howToPlayButton) {
		this.howToPlayButton = howToPlayButton;
	}

}

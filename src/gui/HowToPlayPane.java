package gui;

import item.BackButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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

public class HowToPlayPane extends VBox {

	private Label howToPlayText;
	private Text firstRow;
	private Text secondRow;
	private Text thirdRow;
	private BackButton backButton;

	public HowToPlayPane() {
		Image img = new Image("file:bg/bg.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		this.setBackground(bGround);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(40);
		this.howToPlayTitle();
		this.firstRowSentence();
		this.secondRowSentence();
		this.thirdRowSentence();
		backButton = new BackButton();
		this.getChildren().addAll(backButton, howToPlayText, firstRow, secondRow, thirdRow);
	}

	private void howToPlayTitle() {
		howToPlayText = new Label("How To Play");
		howToPlayText.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 80));
		howToPlayText.setTextFill(Color.WHITE);
		howToPlayText.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		howToPlayText.setPadding(new Insets(20, 70, 20, 70));
	}

	private void firstRowSentence() {
		firstRow = new Text("There are lots of spheres spawn in the screen");
		firstRow.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		firstRow.setFill(Color.WHITE);
	}

	private void secondRowSentence() {
		secondRow = new Text("You need to click those spheres to destroy");
		secondRow.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		secondRow.setFill(Color.WHITE);
	}

	private void thirdRowSentence() {
		thirdRow = new Text("If you destroy 30 spheres, The game will end");
		thirdRow.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		thirdRow.setFill(Color.WHITE);
	}

	public BackButton getBackButton() {
		return backButton;
	}

	public void setBackButton(BackButton backButton) {
		this.backButton = backButton;
	}

}

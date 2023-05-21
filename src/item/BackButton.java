package item;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BackButton extends VBox {

	private Button backButton;

	public BackButton() {
		this.setAlignment(Pos.TOP_LEFT);
		this.setSpacing(30);
		this.initializeBackButton();
		this.getChildren().add(backButton);
	}

	public void initializeBackButton() {
		backButton = new Button("BACK");
		backButton.setFont(Font.loadFont("file:font/Valorax-lg25V.otf", 40));
		backButton.setTextFill(Color.WHITE);

		// hovering
		backButton.setOnMouseEntered(event -> {
			backButton.setTextFill(Color.YELLOW);
		});
		backButton.setOnMouseExited(event -> {
			backButton.setTextFill(Color.WHITE);
		});
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

}

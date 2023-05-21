package main;

import gui.WelcomePane;
import Util.Config;
import classic.Classic;
import gridshot.GridShot;
import gui.HowToPlayPane;
import gui.ModePane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import microshot.MicroShot;
import microshot.MicroShotSummary;

public class Main extends Application {
	private WelcomePane welcomePane;
	private ModePane modePane;
	private GridShot gridShotPane;
	private MicroShot microShotPane;
	private HowToPlayPane howToPlayPane;
	private MicroShotSummary microShotSumPane;
	private Classic classicPane;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		welcomePane = new WelcomePane();
		modePane = new ModePane();
		gridShotPane = new GridShot();
		microShotPane = new MicroShot();
		howToPlayPane = new HowToPlayPane();
		microShotSumPane = new MicroShotSummary(microShotPane);
		classicPane = new Classic();
		switchToWelcomePane();
		addEventListener();
		primaryStage.setHeight(Config.screenHeight);
		primaryStage.setWidth(Config.screenWidth);
		
		primaryStage.setResizable(false);
		primaryStage.setFullScreen(true);
		primaryStage.show();

	}

	public void switchToWelcomePane() {
		if (welcomePane.getParent() != null) {
			welcomePane.getScene().setRoot(null);
		}

		welcomePane = new WelcomePane();
		Scene welcomeScene = new Scene(welcomePane);
		primaryStage.setScene(welcomeScene);
		primaryStage.setFullScreen(true);
		addEventListener();
	}

	public void switchToModePane() {
		if (modePane.getParent() != null) {
			// Remove the WelcomePane from its current parent scene
			modePane.getScene().setRoot(null);
		}

		modePane = new ModePane();
		Scene modeScene = new Scene(modePane);
		primaryStage.setScene(modeScene);
		primaryStage.setFullScreen(true);
		addEventListener();

	}

	public void switchToHowToplayPane() {
		if (howToPlayPane.getParent() != null) {
			// Remove the WelcomePane from its current parent scene
			howToPlayPane.getScene().setRoot(null);
		}

		howToPlayPane = new HowToPlayPane();
		Scene howToPlayScene = new Scene(howToPlayPane);
		primaryStage.setScene(howToPlayScene);
		primaryStage.setFullScreen(true);
		addEventListener();
	}

	public void switchToGridShotPane() {
		if (gridShotPane.getParent() != null) {
			// Remove the WelcomePane from its current parent scene
			gridShotPane.getScene().setRoot(null);
		}

		gridShotPane = new GridShot();
		Scene gridShotScene = new Scene(gridShotPane);
		primaryStage.setScene(gridShotScene);
		primaryStage.setFullScreen(true);
		addEventListener();

	}

	public void switchToMicroShotPane() {
		if (microShotPane.getParent() != null) {
			// Remove the WelcomePane from its current parent scene
			microShotPane.getScene().setRoot(null);
		}

		microShotPane = new MicroShot();
		Scene microShotScene = new Scene(microShotPane);
		primaryStage.setScene(microShotScene);
		primaryStage.setFullScreen(true);
		addEventListener();

	}

	public void switchToclassicPane() {
		if (classicPane.getParent() != null) {
			// Remove the WelcomePane from its current parent scene
			classicPane.getScene().setRoot(null);
		}

		classicPane = new Classic();
		Scene classicScene = new Scene(classicPane);
		primaryStage.setScene(classicScene);
		primaryStage.setFullScreen(true);
		addEventListener();

	}

	public void addEventListener() {
		welcomePane.getStartButton().setOnMouseClicked(event -> {
			switchToModePane();
		});

		welcomePane.getHowToPlayButton().setOnAction(event -> {
			switchToHowToplayPane();
		});

		welcomePane.getExitButton().setOnAction(event -> {
			Platform.exit();
		});

		howToPlayPane.getBackButton().getBackButton().setOnAction(event -> {
			switchToWelcomePane();
		});

		modePane.getBackButton().setOnMouseClicked(event -> {
			switchToWelcomePane();
		});

		modePane.getGridShotButton().setOnMouseClicked(event -> {
			switchToGridShotPane();
		});

		modePane.getMicroShotButton().setOnMouseClicked(event -> {
			switchToMicroShotPane();
		});

		modePane.getClassicButton().setOnMouseClicked(event -> {
			switchToclassicPane();
		});

		microShotPane.getMicroShotSumPane().getRestartButton().setOnMouseClicked(event -> {
			switchToMicroShotPane();
		});

		microShotPane.getMicroShotSumPane().getSelectMode().setOnMouseClicked(event -> {
			switchToModePane();
		});

		gridShotPane.getGridShotSumPane().getRestartButton().setOnMouseClicked(event -> {
			switchToGridShotPane();
		});

		gridShotPane.getGridShotSumPane().getSelectMode().setOnMouseClicked(event -> {
			switchToModePane();
		});

		classicPane.getClassicSumPane().getRestartButton().setOnMouseClicked(event -> {
			switchToclassicPane();
		});

		classicPane.getClassicSumPane().getSelectMode().setOnMouseClicked(event -> {
			switchToModePane();
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
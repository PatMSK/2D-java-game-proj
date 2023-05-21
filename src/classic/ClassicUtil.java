package classic;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import logic.BombTarget;
import logic.Target;

import java.util.ArrayList;
import java.util.Random;

import Util.RenderableHolder;
import Util.TargetUtil;

public class ClassicUtil {
	public static void spawnTargets(ArrayList<Target> targets, Pane pane, int maxTargets, int radius) {
		while (targets.size() <= maxTargets) {
			spawnTarget(targets, pane, radius);
		}
	}

	public static void spawnTarget(ArrayList<Target> targets, Pane pane, int radius) {
		Random random = new Random();
		ArrayList<String> option = new ArrayList<String>();
		for (int i = 0; i <= 10; i++) {
			option.add("BASE");
		}
		option.add("BOMB");

		Target target = null;
		String get = option.get(random.nextInt(option.size()));
		if (get.equals("BASE")) {
			target = new Target(50, Color.AQUA);
		}
		if (get.equals("BOMB")) {
			target = new BombTarget(50, Color.RED);
		}

		TargetUtil.randomizeValidPosition(targets, target);
		targets.add(target);
		pane.getChildren().add(target);
	}

	public static void mouseClick(double x, double y, ArrayList<Target> targets, Pane pane, int radius) {
		Classic classic = (Classic) pane;
		classic.setShotTimes(classic.getShotTimes() + 1);
		;

		for (int i = targets.size() - 1; i >= 0; i--) {
			Target target = targets.get(i);
			if (checkClicked(x, y, target, radius)) {
				classic.setScore(classic.getScore() + 1);
				if (target instanceof BombTarget) {
					RenderableHolder.explosionSound.play();
					classic.setScore(classic.getScore() - 1);
					targets.clear();
					pane.getChildren().clear();
					classic.gameEnd();
					classic.setScore(0);
					classic.setShotTimes(0);
					break;
					
				} else if (classic.getScore() == 30){
					targets.clear();
					pane.getChildren().clear();
					classic.gameEnd();
					classic.setScore(0);
					classic.setShotTimes(0);
					break;
				}
				
				else {
					targets.remove(i);
					pane.getChildren().remove(target);
					spawnTarget(targets, pane, radius);
				}

				break;
			}
		}
	}

	private static boolean checkClicked(double clickX, double clickY, Sphere target, int radius) {
		return Math.sqrt(
				Math.pow(clickX - target.getTranslateX(), 2) + Math.pow(clickY - target.getTranslateY(), 2)) <= radius;
	}
}

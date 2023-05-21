package gridshot;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import logic.Target;

import java.util.ArrayList;

import Util.TargetUtil;

public class GridShotUtil {
	
	
    public static void spawnTargets(ArrayList<Target> targets, Pane pane, int numTargets, int radius,Color color) {
        for (int i = 0; i < numTargets; i++) {
            spawnTarget(targets, pane, radius,color);
        }
    }

    public static void spawnTarget(ArrayList<Target> targets, Pane pane, int radius,Color color) {
        Target target = new Target(radius, color);
        TargetUtil.randomizeValidPosition(targets, target);
        targets.add(target);
        pane.getChildren().add(target);
    }

    public static void mouseClick(double x, double y, ArrayList<Target> targets, Pane pane, int radius,Color color) {
        GridShot gridShot = (GridShot) pane;
        gridShot.setShotTimes(gridShot.getShotTimes() + 1);
        for (int i = targets.size() - 1; i >= 0; i--) {
            Sphere target = targets.get(i);
            if (checkClicked(x, y, target, radius)) {
                gridShot.setScore(gridShot.getScore() + 1);
                targets.remove(i);
                pane.getChildren().remove(target);
                spawnTarget(targets, pane, radius, color);
                if (gridShot.getScore() == 30) {
                    targets.clear();
                    pane.getChildren().clear();
                    gridShot.gameEnd();
                    gridShot.setScore(0);
                    gridShot.setShotTimes(0);
                    break;
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

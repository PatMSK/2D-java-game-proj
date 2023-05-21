package Util;

import java.util.ArrayList;
import java.util.Random;

import logic.Target;

public class TargetUtil {

	private static double calculateDistance(Target target1, Target target2) {
		double dX = Math.pow(target1.getX() - target2.getX(), 2);
		double dY = Math.pow(target1.getY() - target2.getY(), 2);
		return Math.sqrt(dX + dY);
	}

	private static boolean isTargetCollide(Target target1, Target target2) {
		double distance = calculateDistance(target1, target2);
		double sumOfRadii = target1.getRadius() + target2.getRadius();
		return distance <= sumOfRadii;
	}

	private static boolean isAnyTargetCollide(ArrayList<Target> targets, Target target) {
		for (Target t : targets) {
			if (isTargetCollide(t, target)) {
				return true;
			}
		}
		return false;
	}

	private static void randomPosition(Target target) {
		Random random = new Random();
		double minX = 400 + target.getRadius();
		double minY = 200 + target.getRadius();
		double maxX = Config.screenWidth - 400 - target.getRadius() * 2;
		double maxY = Config.screenHeight - 200 - target.getRadius() * 2;
		target.setX(minX + random.nextDouble() * (maxX - minX));
		target.setY(minY + random.nextDouble() * (maxY - minY));
	}

	public static void randomizeValidPosition(ArrayList<Target> targets, Target target) {
		int maxAttempts = 1000;
		int attempts = 0;

		while (attempts < maxAttempts) {
			randomPosition(target);

			if (!isAnyTargetCollide(targets, target)) {
				return; // Valid position found, exit the method
			}

			attempts++;
		}

		System.out.println("Failed to find a valid position for the target.");
	}
}

package Actor;

import javafx.scene.image.Image;

public class Sniper extends Actor {

	public boolean clicked = false;
	public int clickCount = 0;
	private int clickRotCount;
	private final int shootCoolDown = 16;
	private final double scaleSpeed = 0.025;

	private double dScale;

	public Sniper() {
		width = height = 100;
		img = new Image("objectAssets/reticle.gif");
		scalef = 1;

	}

	public void update() {
		// System.out.println("Sniper update");
		if (clicked && clickCount == 0) { // just clicked the mouse so start
											// click animation
			clickCount = shootCoolDown;
			clickRotCount = clickCount / 2;
			if (Math.random() > 0.5)
				dr = 1;
			else
				dr = -1;
			dScale = scaleSpeed;
			clicked = false;
		}

		if (clickRotCount == 0) {
			dr = -dr;
			dScale = -scaleSpeed;
			clickRotCount = clickCount;
		} else {
			clickRotCount--;
			clickCount--;
			clicked = false;
		}
		if (clickCount == 0) {
			dr = 0;
			r = 0;
			dScale = 0;
		}
		// r += dr;
		scalef += dScale;
		super.update();

	}

	public void setPosition(double x2, double y2) {
		x = x2;
		y = y2;
	}

}
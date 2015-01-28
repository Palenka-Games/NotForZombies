package nfz.game.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {

	private float r,g,b;
	private float sx;
	private float sy;
	
	public Sprite(float r, float g, float b, float sx, float sy) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.sx = sx;
		this.sy = sy;
	}
	
	/**
	 * render the sprite
	 */
	public void render() {
		glColor3f(r,g,b);
		glBegin(GL_QUADS);
			glVertex2f(0, 0);
			glVertex2f(0, sy);
			glVertex2f(sx, sy);
			glVertex2f(sx, 0);
		glEnd();
	}
	
	public float getSx() {
		return sx;
	}
	
	public float getSy() {
		return sy;
	}

}

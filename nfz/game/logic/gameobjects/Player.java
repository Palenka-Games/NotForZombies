package nfz.game.logic.gameobjects;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import nfz.game.graphics.Sprite;
import nfz.game.logic.GameObject;

public class Player extends GameObject{
	
	public static final float PLAYER_SX = 32;
	public static final float PLAYER_SY = 32;
	
	private int hp;
	
	private float xp;
	
	public Player (float x, float y) {
		super(x, y, 0.1f, 1f, 0.5f, PLAYER_SX, PLAYER_SY);
		xp = 151;
		hp = 10;
	}
	
	public void update() {
		//System.out.println("Stats:\nSPEED: " + getSpeed() + "\nLEVEL: " + getLevel() + "\nMAXHP: " + getMaxHealth() +
				//"\nHP: " + getCurrentHealth());
		
		//rotate with mouse
		//get mouse coords
		float mouseX = Mouse.getX();
		float mouseY = Mouse.getY();
		
		//get player center coords
		float centerX = x + sprite.getSx() / 2;
		float centerY = y + sprite.getSy() / 2;
		
		//get delta values
		float deltaY = mouseY - centerY;
		float deltaX = mouseX - centerX;
		
		//calculate angle between player and mouse
		float angle = (float) Math.atan(deltaY / deltaX);
		rot = (float) Math.toDegrees(angle);
		//System.out.println("Angle: " + Math.toDegrees(angle) + ", x: " + x + ", y: " + y + ", mx: " + mouseX + ", my: " + mouseY);
		
	}
	
	public void getInput() {
		//check for keys pressed
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			move(0, 1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			move(0, -1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			move(-1, 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			move(1, 0);
		}
	}
	
	public void render() {
		glPushMatrix();
		glTranslatef(x, y, 0);
		glTranslatef(sprite.getSx() / 2, sprite.getSy() / 2, 0);
		glRotatef(rot, 0.0f, 0.0f, 1.0f);	
		glTranslatef(-(sprite.getSx() / 2), -(sprite.getSy() / 2), 0);
		sprite.render();
		glPopMatrix();
	}
	
	private void move(float magX, float magY) {
		//x += getSpeed() * Math.cos(Math.toRadians(rot));
		//y += getSpeed() * Math.sin(Math.toRadians(rot));
		x += getSpeed() * magX;
		y += getSpeed() * magY;
	}
	
	public void addXP(float amt) {
		xp += amt;
	}
	
	/**
	 * Calculates max hp of player
	 * @return
	 */
	public int getMaxHealth() {
		//to do : proper calculation
		return getLevel() * 10;
	}
	/*
	 * return current hp
	 */
	public int getCurrentHealth() {
		int max = getMaxHealth();
		if (hp > max) {
			hp = max;
		}
		return hp;
	}
	
	/**
	 * return str of player
	 * @return
	 */
	public float getStrength() {
		return getLevel() * 4f;
	}
	
	/**
	 * calculates speed
	 * @return
	 */
	public float getSpeed() {
		return 4f;
	}
	
	public int getLevel() {
		return (int)(xp / 50) + 1;
	}
	
}

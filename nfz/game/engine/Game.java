package nfz.game.engine;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import nfz.game.logic.GameObject;
import nfz.game.logic.gameobjects.Player;

/**
 * 
 * @author BBPG, Phar0x
 *
 */
public class Game {

	private ArrayList<GameObject> objects;
	private Player player;
	
	public Game() {
		objects = new ArrayList<GameObject>();
		
		player = new Player(0, 0);
		
		objects.add(player);
	}
	
	public void getInput() {
		player.getInput();
	}
	
	public void update() {
		for (GameObject go : objects) {
			go.update();
		}
	}
	
	public void render() {
		for (GameObject go : objects) {
			go.render();
		}
	}
	
}

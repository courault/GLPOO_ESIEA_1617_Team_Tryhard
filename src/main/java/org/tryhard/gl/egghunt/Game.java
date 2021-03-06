package org.tryhard.gl.egghunt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import org.tryhard.gl.egghunt.gui.Window;
import org.tryhard.gl.egghunt.io.CsvDao;

/**
 *
 *
 */
public class Game extends GraphicObject {

	public static final int ID = 2;
	private Garden gd;
	private int timer = 0;
	private Button returnButton;
	private Button pauseButton;
	private Button scoreButton;

	public Game(String csv_garden, String csv_children) {
		super(0, 0, Window.WIDTH, Window.HEIGHT);
		CsvDao cd = new CsvDao();
		gd = cd.getGardenAndChilds(csv_garden, csv_children);
		addDescendant(gd);
		returnButton = new Button(Window.WIDTH - 250, 620, 200, 84, EggHunt.IMGP + "QuitGame.png");
		addDescendant(returnButton);
		pauseButton = new Button(30, 30, Garden.WC, Garden.WC, EggHunt.IMGP + "PauseGame.png");
		addDescendant(pauseButton);
		scoreButton = new Button(50, 620, 200, 84, EggHunt.IMGP + "ScoreGame.png");
		addDescendant(scoreButton);
		loadImages(EggHunt.IMGP + "background.png");
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawImage(imgs[0], 0, 0, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString("Œufs ramassés", 1050, 50);
		int i = 0;
		for (GraphicObject d : gd.getDescendants()) {
			if (d.getClass() == Child.class) {
				Child c = (Child) d;
				String str = c.getName() + " : " + c.getBasket().size();
				g.drawString(str, 1050, 100 + 30 * i);
				g.drawString(String.valueOf(timer / Window.FPS), 500, 50);
				i++;
			}
		}
	}

	public int getTimer() {
		return timer;
	}
	
	public Garden getGarden() {
		return gd;
	}

	@Override
	protected void calculate() {
		timer++;
	}
}

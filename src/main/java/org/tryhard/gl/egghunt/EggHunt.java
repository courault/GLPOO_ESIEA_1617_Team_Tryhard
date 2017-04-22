package org.tryhard.gl.egghunt;

import org.apache.log4j.Logger;
import org.tryhard.gl.egghunt.gui.Window;
import java.util.ArrayList;


/**
 * 
 * @author menuiserie
 *
 */
public final class EggHunt 
{
	
	private static final Logger LOGGER = Logger.getLogger(EggHunt.class);

	private static EggHunt instance = null;
	private static ArrayList<View> views = new ArrayList<View>();
	private static int viewChoice = 0;
	
/**
 * Constructeur de EggHung
 * initialise le jeu et crée la fenêtre d'affichage
 */
	private EggHunt() {
		load();
		new Window();
	}

	private void load() {
		views.add(new View());
	}

	public static ArrayList<View> getContainers() {
		return views;
	}

	public static int getViewChoice() {
		return viewChoice;
	}

	public static void setViewChoice(int nviewchoice) {
		viewChoice = nviewchoice;
	}

	/**
	 * methode retournant le singleton d' EggHunt
	 * @return
	 */
	public static final EggHunt getInstance() {
		if (instance == null) {
			synchronized (EggHunt.class) {
				if (instance == null) {
					instance = new EggHunt();
				}
			}
		}
		return EggHunt.instance;
	}

	/**
	 * fonction principale du programme, créer le singleton EggHunt
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info(Window.TITLE);
		getInstance(); //crée le singleton 
	}
}

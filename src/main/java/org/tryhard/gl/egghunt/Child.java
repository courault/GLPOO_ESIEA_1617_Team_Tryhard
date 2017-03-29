package org.tryhard.gl.egghunt;

import java.util.ArrayList;

public class Child extends GraphicObject {

	private int xc; // Coordonnée x en case
	private int yc; // Coordonnée y en case
	private ArrayList<Egg> basket = new ArrayList<Egg>(); // Oeufs ramassés

	public Child(int xc, int yc, Garden g) {
		super(xc * Garden.WC, yc * Garden.WC, g);
		this.xc = xc;
		this.yc = yc;
	}

	public int getXC() {
		return xc;
	}

	public int getYC() {
		return yc;
	}

	public ArrayList<Egg> getEggs() {
		return basket;
	}
}

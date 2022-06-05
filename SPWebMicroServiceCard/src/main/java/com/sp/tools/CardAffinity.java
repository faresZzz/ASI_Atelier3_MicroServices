package com.sp.tools;

import java.util.Random;

public enum CardAffinity {
	Eau, Vent, Feu, Terre, Nuit, Soleil, Argent;
	
	
	public static CardAffinity getRandomAffinity() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

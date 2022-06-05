package com.sp.tools;

import java.util.Random;

public enum CardFamily {
	Gentil, Mechant, Neutre, LaFamillePirate, Louds, Simpson, Griffins;
	
	public static CardFamily getRandomFamily() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

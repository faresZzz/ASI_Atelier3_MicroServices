package com.sp.tools;

import java.util.Random;

public enum CardsName {
	Flippy, Lumpy, MrPickles, Lifty, Shifty, CroMarmot, Superman, Batman, Aquaman, Atom, Deadpool, Deadshot;
	
	
	public static CardsName getRandomName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

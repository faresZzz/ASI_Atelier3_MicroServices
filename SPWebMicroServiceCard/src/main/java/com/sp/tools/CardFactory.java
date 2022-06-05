package com.sp.tools;

import com.model.CardDto;
import java.util.Random;

public class CardFactory 
{
	private static Random randomGenerator = new Random();
	public static CardDto createCardRandomCard()
	{
		String name =  CardsName.getRandomName().toString();
		String affinity = CardAffinity.getRandomAffinity().toString();
		String description = CardDescription.getDescriptionByNom(name);
		String imgUrl = CardImage.getImageByNom(name);
		String family = CardFamily.getRandomFamily().toString();
		
		int id = 0;
		int hp = 100 + CardFactory.randomGenerator.nextInt(900);
		int energy = 100 + CardFactory.randomGenerator.nextInt(900);
		int attack = 100 + CardFactory.randomGenerator.nextInt(900);
		int defence = 100 + CardFactory.randomGenerator.nextInt(900);
		
		int price =  (int) ( 500 + 10*((100*hp+ 100*attack + 100*defence + 100*energy) / 4000)* CardFactory.randomGenerator.nextFloat()) ;
		int ownerId = 0;
		boolean onMarket = false;
		
		return new CardDto(id, price,  name, description, imgUrl, family, affinity, hp, energy ,attack, defence, ownerId, onMarket );
		
	}
	
	
	
	public static void main(String[] args)
	{
		for (int i = 0; i<5 ; i++)
		{

			System.out.println(CardFactory.createCardRandomCard());
		}
	}
	
}


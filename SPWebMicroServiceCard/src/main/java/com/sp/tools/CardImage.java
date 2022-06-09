package com.sp.tools;


public enum CardImage {
	Flippy("Flippy", "https://img2.freepng.fr/20180824/tvt/kisspng-flippy-giggles-cro-marmot-image-art-happy-tree-friends-ale-bing-images-5b8038eeb775b5.5301884315351298387515.jpg"),
	Lumpy("Lumpy", "http://pm1.narvii.com/6341/da6bd3c08d3c7c5556ba15b7101547d5275acf3a_00.jpg"), 
	MrPickles("MrPickles", "https://static.wikia.nocookie.net/happytreefriends/images/0/01/S3E17_Picklehop.png/revision/latest/scale-to-width-down/1000?cb=20160326142145"),
	Lifty("Lifty", "https://cosplayfu-website.s3.amazonaws.com/_Photo/character/mini/18216_12101.jpg"), 
	Shifty("Shifty", "https://cosplayfu-website.s3.amazonaws.com/_Photo/character/mini/18217_12100.jpg"), 
	CroMarmot("CroMarmot", "https://i.skyrock.net/8451/44118451/pics/1779113410.gif"), 
	SuperMan("Superman", "https://www.comicsplace.net/wp-content/uploads/2018/01/AC_1000.jpg"),
	BatMan("Batman", "https://www.batman-legend.com/wp-content/uploads/2017/05/Batman-POCLCB.jpg"),
	Aquaman("Aquaman", "https://www.urban-comics.com/wp-content/uploads/2018/09/aquaman1-1-1024x642.jpg"),
	Atom("Atom", "https://i2.wp.com/topcomics.fr/wp-content/uploads/2020/01/10-persos-dc-comics-plus-puissants-que-superman-captain-atom.jpg?w=678&ssl=1"),
	Deadpool("Deadpool", "https://www.actuabd.com/local/cache-vignettes/L330xH496/arton28724-0b370.jpg?1638532001"),
	Deadshot("Deadshot", "https://www.planetebd.com/dynamicImages/album/cover/large/31/86/album-cover-large-31860.jpg")
	;
	
	public String nom;
	public  String imageUrl ;   

	CardImage(String nom,  String imageUrl) { 
		this.nom = nom;
		this.imageUrl = imageUrl;
	}
	
	public static String getImageByNom(String nom) {
	       for (CardImage card : CardImage.values()) {
	           if (card.nom.equals(nom)) {
	               return card.imageUrl;
	           }
	       }
	       return null;
	}
}

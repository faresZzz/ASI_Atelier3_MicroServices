package com.sp.tools;


public enum CardImage {
	Flippy("Flippy", "https://static.wikia.nocookie.net/happytreefriends/images/9/9e/FlippyTraumatizedScreamHS33.png/revision/latest?cb=20190106223343"),
	Lumpy("Lumpy", "https://static.wikia.nocookie.net/happytreefriends/images/3/39/Cdahtfcalendar3.jpg/revision/latest?cb=20110507082152"), 
	MrPickles("MrPickles", "https://static.wikia.nocookie.net/happytreefriends/images/0/01/S3E17_Picklehop.png/revision/latest/scale-to-width-down/1000?cb=20160326142145"),
	Lifty("Lifty", "https://static.wikia.nocookie.net/happytreefriends/images/7/7e/LiftyProfile.png/revision/latest?cb=20170616160329"), 
	Shifty("Shifty", "https://static.wikia.nocookie.net/happytreefriends/images/8/8f/Gallery_01_11.png/revision/latest?cb=20130113035357"), 
	CroMarmot("CroMarmot", "https://static.wikia.nocookie.net/happytreefriends/images/0/04/Cro-Marmot-NOICE.png/revision/latest?cb=20200524202259"), 
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

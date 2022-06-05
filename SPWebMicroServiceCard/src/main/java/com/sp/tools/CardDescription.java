package com.sp.tools;

public enum CardDescription {
	Flippy("Flippy", "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm."),
	Lumpy("Lumpy", "Lumpy fait partie des personnages éponymes de la série Happy Tree Friends. Au départ, Lumpy devait être un dinosaure. Au final, il a été décidé qu'il deviendrait un élan."), 
	MrPickles("MrPickles", "Mr.Pickles est l'ami imaginaire de Lammy."), 
	Lifty("Lifty", "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas !"), 
	Shifty("Shifty", "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas !"), 
	CroMarmot("CroMarmot", "Cro-Marmot est une marmotte verte dans un grand cube de glace, il tient une batte en bois dans la main et une sorte de slip léopard sur lui. Ses cheveux cachent ses yeux."), 
	SuperMan("Superman", "Point faible trop fort"), 
	BatMan("Batman", "Bruce Wayne devient un justicier masqué qui agit principalement la nuit. S'il ne possède pas de super-pouvoirs, il compense par une grande dextérité dans les arts martiaux et par son équipement technologique ultra-sophistiqué."), 
	Aquaman("Aquaman", "Aquaman possède une large palette de pouvoirs. En effet, il possède une force, une résistance et une agilité surhumaines,  il peut vivre sous l'eau, il commande et communique par télépathie aux animaux marins,"), 
	Atom("Atom", "The Atom peut contrôler les atomes. Ses atomes ont la capacité de détruire une ou plusieurs planètes mais il ne fait jamais voir cette capacité par peur de détruire notre galaxie."), 
	Deadpool("Deadpool", "Deadpool est un mercenaire défiguré, doté d'une capacité surhumaine de guérison accélérée et capable de prouesses physiques. "), 
	Deadshot("Deadshot", "Deadshot est un tueur à gages qui se vante de ne jamais manquer sa cible. Il est généralement associé au Suicide Squad bien qu'il soit aussi un membre des Secret Six.")
	;
	
	public String nom;
	public  String description ;   

	CardDescription(String nom,  String description) { 
		this.nom = nom;
		this.description = description;
	}
	
	public static String getDescriptionByNom(String nom) {
	       for (CardDescription card : CardDescription.values()) {
	           if (card.nom.equals(nom)) {
	               return card.description;
	           }
	       }
	       return null;
	}
}

package zyel;

public enum ZyElClass{
	ASSASSIN(0),
	BARBARIAN(1),
	DRUID(2),
	AMAZON(3),
	NECROMANCER(4),
	PALADIN(5),
	SORCERESS(6),
	ALL(7),
	NONE(8),
	ONLY(9);
	
	private int num;
	
	ZyElClass(int n){ num = n; }
	public int get(){return num; }
}

public enum ZyElClass{
	ASSASSIN("Assassin","Ассасин"),
	BARBARIAN("Barbarian","Варвар"),
	DRUID("Druid", "Друид"),
	AMAZON("Amazon", "Амазонка"),
	NECROMANCER("Necromancer", "Некромант"),
	PALADIN("Paladin", "Паладин"),
	SORCERESS("Sorceress", "Волшебница"),
	ALL("All", "Все"),
	NONE("None", "Безкласса"),
	ONLY("Only", "Только");
	
	private String Eng, Rus;
	private String Language;
	
	ZyElClass(String eng, String rus){
		Eng = eng;
		Rus = rus;
		Language = "Eng";
	}
}
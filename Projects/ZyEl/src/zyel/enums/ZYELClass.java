package zyel.enums;

public enum ZYELClass{
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
	private static String Language = "Eng";
	
	ZYELClass(String eng, String rus){
		Eng = eng;
		Rus = rus;
	}
	
	public String get(){
		if(Language.equals("Eng")) return Eng;
		return Rus;
	}
	
	public static void set(String language){
		if(language.equals("Eng") || language.equals("Rus")) Language = language;
	}
}
package zyel.sys;

public interface ZyElLanguage{
	String Eng = null, Rus = null;
    String Language = "Eng";
	
	public default String get(){
		if(Language.equals("Eng")) return Eng;
		return Rus;
	}
	
	public static void set(String language){
		if(language.equals("Eng") || language.equals("Rus")) Language = language;
	}
}
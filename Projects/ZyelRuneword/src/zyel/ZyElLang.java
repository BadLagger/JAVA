package zyel;

public class ZyElLang{
	private static String CurrentLang = "Eng";
	/* Classes */
    private static final  String[] ClassEng = {"Assassin", "Barbarian", "Druid", "Amazon", "Necromancer", "Paladin", "Sorceress", "All", "None", "Only"};
	private static final  String[] ClassRus = {"Ассасин", "Варвар", "Друид", "Амазонка", "Некромант", "Паладин", "Волшебница", "Все", "Безклассовый", "Только"};
    private static String[] ClassCurrent = ClassEng;
	/* Items */
	private static final String[] ItemsEng = {"Amulet", "Any armor", "Auric shield", "Belt", "Boot", "Circlet", "Glove", "Necro head", "Helmet", "Druid pelt", "Primal helmet", "Ring", "Shield", "Torso armor"},
	                              ItemsRus = {"Амулет", "Любая бронь", "Щит", "Пояс", "Сапоги", "Обруч", "Перчатки", "Голова некр.", "Шлем", "Шкура", "Шлем вар.", "Кольцо", "Щит", "Торс"};
	private static String[] ItemsCurrent = ItemsEng;
	/* Weapons */
	private static final String[] WeaponsEng = {"Amazon bow", "Amazon javelin", "Amazon spear", "Axe", "Blunt", "Bow", "Club", "Claw", "Hammer", "Javelin", "Knife", "Mace", "Melee", "Missile", "Orb", "Polearm", "Rod", "Scepter", "Spear", "Staff", "Sword", "Throw axe", "Thrown", "Throw knife", "Wand", "Crossbow", "Any"},
	                              WeaponsRus = {"Лук амазонки", "Дротик амазонки", "Копьё амазонки", "Топор", "Дробящее", "Лук", "Дубина", "Когти", "Молот", "Дротик", "Нож", "Булава", "Ближнее", "Дальнее", "Сфера", "Древковое", "Посохи", "Скипетр", "Копьё", "Трость", "Меч", "Топр мет.", "Метательное", "Нож мет.", "Жезл", "Арбалет", "Любое"};
	private static String[] WeaponsCurrent = WeaponsEng;
	/* Talismans */
	private static final String[] TalismansEng = {"Hex", "Large", "Any", "Narrow", "Quad", "Small", "Tall"},
	                              TalismansRus = {"Сглаза", "Большой", "Любой", "Узкий", "Квадратный", "Малый", "Высокий"};
	private static String[] TalismansCurrent = TalismansEng;
	
	public static String getCls(ZyElClass id){
		return ClassCurrent[id.get()];
	}
	
	public static void toggle(){
		if(CurrentLang.equals("Eng")){
			CurrentLang  = "Rus";
			ClassCurrent = ClassRus;
			ItemsCurrent = ItemsRus;
			WeaponsCurrent = WeaponsRus;
			TalismansCurrent = TalismansRus;
		} else {
			CurrentLang  = "Eng";
			ClassCurrent = ClassEng;
			ItemsCurrent = ItemsEng;
			WeaponsCurrent = WeaponsEng;
			TalismansCurrent = TalismansEng;
		}
	}
	
	public static String[] getCurrentCls(){
		return ClassCurrent;
	}
	
	public static String[] getCurrentItems(){
		return ItemsCurrent;
	}
	
	public static String[] getCurrentWeapons(){
		return WeaponsCurrent;
	}
	
	public static String[] getCurrentTalismans(){
		return TalismansCurrent;
	}
	
	
	public static String getCurrent(){
		return CurrentLang;
	} 
}
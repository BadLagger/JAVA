package zyel.dbg;

import zyel.enums.*;

public class ZyElDbg{
	public static void main(String[] args){
		System.out.println("ZyElDbg");
		for(ZYELClass i:ZYELClass.values())
			System.out.println(i.get());
		ZYELClass.set("Rus");
		for(ZYELClass i:ZYELClass.values())
			System.out.println(i.get());
	}
}
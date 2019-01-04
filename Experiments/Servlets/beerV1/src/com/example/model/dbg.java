package com.example.dbg;
import java.util.*;
import com.example.model.*;

class Dbg{
	public static void main(String[] args){		
		System.out.println("Test for first model");
		List lBeer = BeerExpert.getBrands("dark");
	    for(int i = 0; i < lBeer.size(); i++){
			System.out.println(lBeer.get(i));
		}
	}
}
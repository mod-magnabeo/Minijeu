package com.Wolf_IV.MiniJeu.HungerGame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.HikaBrain.MatchMaking;
import com.Wolf_IV.MiniJeu.HungerGame.Item.HItem;

public class HungerGame {
	private MainJ main;

	public static int chestnub = 150;
	public Location[] chestLoc = new Location[chestnub+2];
	public HungerGame(MainJ mainJ) {
		this.main= mainJ;
		/*HItem h = new HItem();
		h.create(1);*/
		/*int o = 0;
		PotionEffectType[] pET= PotionEffectType.values();
		for(PotionEffectType effect : PotionEffectType.values())
		{
		    
			o++;
			Bukkit.broadcastMessage(o+" = "+pET[o].getName());
			
		}
		Bukkit.broadcastMessage("num = "+o);*/
		Bukkit.broadcastMessage("Les coffre on etait crée");
		HungerChest.setLoc(this);
		
		HungerChest.construct(this);
		
		HungerTimer tasks =new HungerTimer(this);
		tasks.runTaskTimer(main, 0, 20);
		

	}
}

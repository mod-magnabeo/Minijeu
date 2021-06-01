package com.Wolf_IV.MiniJeu.HungerGame;

import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.Wolf_IV.MiniJeu.HungerGame.Item.Armor;
import com.Wolf_IV.MiniJeu.HungerGame.Item.HItem;
import com.Wolf_IV.MiniJeu.HungerGame.Item.Miscellaneous;
import com.Wolf_IV.MiniJeu.HungerGame.Item.Projectiles;
import com.Wolf_IV.MiniJeu.HungerGame.Item.Sword;

public class HungerChest {
	public static Location[] cLoc = new Location[HungerGame.chestnub];
	static Random rand = new Random();
	public static void setLoc(HungerGame hug) {
		for(int i=0; i<=hug.chestnub; i++) {
			int dist = HungerGame.spaceS;
			int x =rand.nextInt(dist*2)-dist;
			int z =rand.nextInt(dist*2)-dist;
			int y;
			boolean sky = true;
			for(y = 254; sky == true; y--) {
			
				Location loc = new Location(Bukkit.getWorld("worldSpawn"),x,y,z);
				if(loc.getBlock().getType() != Material.AIR) {
					sky = false;
					hug.chestLoc[i] = new Location(Bukkit.getWorld("worldSpawn"),x,y+1,z);
				}
		}
			
		}
		cLoc=hug.chestLoc;
	}
	
	public static void construct(HungerGame hug) {
		int i=0;
		for(i=0; i<=hug.chestnub; i++) {
		
		hug.chestLoc[i].getBlock().setType(Material.CHEST);
		Chest chest = (Chest)hug.chestLoc[i].getBlock().getState();
		
		invCon(chest.getBlockInventory());
		
		}
	}
	public static void invCon(Inventory inv) {
		int max = 4;
		boolean empty = true;
		for(int n =0; n<=26; n++) {
			try{
		ItemStack[] mat = new ItemStack[100];
		mat[1]=new Sword().create();
		mat[2]=new Armor().create();
		mat[3]=new Projectiles().create();
		mat[4]=new Miscellaneous().create();
		ItemStack item = mat[rand.nextInt(max)+1];
		inv.setItem(n, item);
			}catch(Exception e) {
				
			}
		
		}
	}
}

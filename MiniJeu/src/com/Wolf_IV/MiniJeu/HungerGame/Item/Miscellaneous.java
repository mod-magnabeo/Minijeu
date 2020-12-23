package com.Wolf_IV.MiniJeu.HungerGame.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Miscellaneous extends HItem {

	@Override
	public ItemStack create() {
			int dif=8;
			int difP = 2;
			int difTNT = 5;
			int difG = 9;
			int difMB = 14;
			int difE = 22;
			int p2 = 10;
			int p3 = 30;
			int b = rand.nextInt(3)+1;
			
				if(rand.nextInt(dif)+1 == 1) {
					int pA = 1;
					if(rand.nextInt(p3)+1 == 1) {
						pA = 3;
					}else if(rand.nextInt(p2)+1 == 1){
						pA = 2;
					}
					if(rand.nextInt(difE)+1 == 1) {
						return new ItemStack(Material.ENDER_PEARL, pA);
					}
					if(rand.nextInt(difG)+1 == 1) {
						return new ItemStack(Material.GOLDEN_APPLE, pA);
					}
					
					if(rand.nextInt(difMB)+1 == 1) {
						return new ItemStack(Material.MILK_BUCKET);
					}
					
					
					
					if(rand.nextInt(difTNT)+1 == 1) {
						return new ItemStack(Material.TNT, pA);
					}
					if(rand.nextInt(difP)+1 == 1) {
						int o = rand.nextInt(24);
						PotionEffectType[] pET= PotionEffectType.values();
						ItemStack potion = new ItemStack(Material.POTION);
		                PotionMeta potionmeta = (PotionMeta) potion.getItemMeta();
		                //potionmeta.setMainEffect(PotionEffectType.POISON);
		                if(o == 6 || o==7) {
		                	potionmeta.setDisplayName("§250% invinsibilité 1min 50% mort");
						}else {
							 potionmeta.setDisplayName("§2Mystery Potion");
						}
		                potionmeta.addCustomEffect(new PotionEffect(pET[o], 1200, 0), true);
		                potion.setItemMeta(potionmeta);
						return potion;
					}
					
					if(rand.nextInt(b)+1 == 1) {
						return new ItemStack(Material.BUCKET);
					}else if(rand.nextInt(b)+1 == 2) {
						return new ItemStack(Material.LAVA_BUCKET);
					}else {
						return new ItemStack(Material.WATER_BUCKET);
					}
					
				}
		return null;
	
	}

}

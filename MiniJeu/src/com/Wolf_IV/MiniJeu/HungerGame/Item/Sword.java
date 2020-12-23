package com.Wolf_IV.MiniJeu.HungerGame.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sword extends HItem {
	
	@Override
	public ItemStack create() {
		int dif=7;
		int difW = 3;
		int difSA = 4;
		int difS = 6;
		int difIA = 9;
		int difI = 14;
		int difDA = 16;
		int difD = 32;
		
			if(rand.nextInt(dif)+1 == 1) {
				if(rand.nextInt(difD)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_SWORD));
				}
				if(rand.nextInt(difDA)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_AXE));
				}
				if(rand.nextInt(difI)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_SWORD));
				}
				if(rand.nextInt(difIA)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_AXE));
				}
				if(rand.nextInt(difS)+1 == 1) {
					return enchant(new ItemStack(Material.STONE_SWORD));
				}
				if(rand.nextInt(difSA)+1 == 1) {
					return enchant(new ItemStack(Material.STONE_AXE));
				}
				if(rand.nextInt(difW)+1 == 1) {
					return enchant(new ItemStack(Material.WOOD_SWORD));
				}
				return enchant(new ItemStack(Material.WOOD_AXE));
			}
		
		return null;
		
	}
	
	private ItemStack enchant(ItemStack it) {
		int dif = 3;
		int difs2 = 7;
		int difs3 = 15;
		int difs4 = 30;
		int difs5 = 50;
		int difF = 30;
		ItemMeta im = it.getItemMeta();
		if(rand.nextInt(dif)+1 == 1) {
			if(rand.nextInt(difs5)+1 == 1) {
				im.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			}else if(rand.nextInt(difs4)+1 == 1) {
				im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
			}else if(rand.nextInt(difs3)+1 == 1) {
				im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
			}else if(rand.nextInt(difs2)+1 == 1) {
				im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
			}else {
				
				im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
			}
		}
		if(rand.nextInt(difF)+1 == 1) {
			im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		}
		it.setItemMeta(im);
		return it;
	}
}

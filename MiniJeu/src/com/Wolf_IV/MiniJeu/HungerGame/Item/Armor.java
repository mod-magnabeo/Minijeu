package com.Wolf_IV.MiniJeu.HungerGame.Item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Armor extends HItem {

	@Override
	public ItemStack create() {
		int type = rand.nextInt(4)+1;
		int dif = 7;
		int difG = 3;
		int difC = 5;
		int difI = 8;
		int difD = 15;
		if(rand.nextInt(dif)+1 == 1) {
			
			//HELMET
			if(type == 1) {
				if(rand.nextInt(difD)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_HELMET));
				}
				if(rand.nextInt(difI)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_HELMET));
				}
				if(rand.nextInt(difC)+1 == 1) {
					return enchant(new ItemStack(Material.CHAINMAIL_HELMET));
				}
				if(rand.nextInt(difG)+1 == 1) {
					return enchant(new ItemStack(Material.GOLD_HELMET));
				}
				
				return enchant(new ItemStack(Material.LEATHER_HELMET));
				}
			//CHESTPLATE
			if(type == 2) {
				if(rand.nextInt(difD)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_CHESTPLATE));
				}
				if(rand.nextInt(difI)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_CHESTPLATE));
				}
				if(rand.nextInt(difC)+1 == 1) {
					return enchant(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
				}
				if(rand.nextInt(difG)+1 == 1) {
					return enchant(new ItemStack(Material.GOLD_CHESTPLATE));
				}
				
				return enchant(new ItemStack(Material.LEATHER_CHESTPLATE));
				}
			
			//LEGGINGS
			if(type == 3) {
				if(rand.nextInt(difD)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_LEGGINGS));
				}
				if(rand.nextInt(difI)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_LEGGINGS));
				}
				if(rand.nextInt(difC)+1 == 1) {
					return enchant(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				}
				if(rand.nextInt(difG)+1 == 1) {
					return enchant(new ItemStack(Material.GOLD_LEGGINGS));
				}
				
				return enchant(new ItemStack(Material.LEATHER_LEGGINGS));
				}
			
			
			//BOOTS
			if(type == 4) {
				if(rand.nextInt(difD)+1 == 1) {
					return enchant(new ItemStack(Material.DIAMOND_BOOTS));
				}
				if(rand.nextInt(difI)+1 == 1) {
					return enchant(new ItemStack(Material.IRON_BOOTS));
				}
				if(rand.nextInt(difC)+1 == 1) {
					return enchant(new ItemStack(Material.CHAINMAIL_BOOTS));
				}
				if(rand.nextInt(difG)+1 == 1) {
					return enchant(new ItemStack(Material.GOLD_BOOTS));
				}
				
				return enchant(new ItemStack(Material.LEATHER_BOOTS));
				}
		}
		return null;
	}
		private ItemStack enchant(ItemStack it) {
			int dif = 4;
			int difp2 = 7;
			int difp3 = 15;
			int difp4 = 30;
			int difT = 30;
			ItemMeta im = it.getItemMeta();
			if(rand.nextInt(dif)+1 == 1) {
				if(rand.nextInt(difp4)+1 == 1) {
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				}else if(rand.nextInt(difp3)+1 == 1) {
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				}else if(rand.nextInt(difp2)+1 == 1) {
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
				}else {
					
					im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				}
			}
			if(rand.nextInt(difT)+1 == 1) {
				im.addEnchant(Enchantment.THORNS, 1, true);
			}
			it.setItemMeta(im);
			return it;
			
		}
}

package com.Wolf_IV.MiniJeu.HungerGame.Item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Projectiles extends HItem {

	@Override
	public ItemStack create() {
		int dif=5;
		int difA = 2;
		int difF = 5;
		int difB = 6;
		int difA8 = 5;
		int difA16 = 15;
		int difA32 = 30;
		int difA64 = 40;
		
			if(rand.nextInt(dif)+1 == 1) {
				if(rand.nextInt(difB)+1 == 1) {
					return enchant(new ItemStack(Material.BOW));
				}
				if(rand.nextInt(difF)+1 == 1) {
					return new ItemStack(Material.FISHING_ROD);
				}
				if(rand.nextInt(difA)+1 == 1) {
					int nA=rand.nextInt(4)+1;
					if(rand.nextInt(difA64)+1 == 1) { 
						nA=rand.nextInt(64)+1;
					}else if(rand.nextInt(difA32)+1 == 1) { 
						nA=rand.nextInt(32)+1;
					}else if(rand.nextInt(difA16)+1 == 1) { 
						nA=rand.nextInt(16)+1;
					}else if(rand.nextInt(difA8)+1 == 1) { 
						nA=rand.nextInt(8)+1;
					}
						
					return new ItemStack(Material.ARROW, nA);
				}
				int nSE = rand.nextInt(4)+1;
				if(rand.nextInt(difA32)+1 == 1) { 
					nSE=rand.nextInt(32)+1;
				}else if(rand.nextInt(difA16)+1 == 1) { 
					nSE=rand.nextInt(16)+1;
				}else if(rand.nextInt(difA8)+1 == 1) { 
					nSE=rand.nextInt(8)+1;
				}
				if(rand.nextBoolean() == true) {
					return new ItemStack(Material.EGG, nSE);
				}
				return new ItemStack(Material.SNOW_BALL, nSE);
				}
			
			return null;
	}

	
	private ItemStack enchant(ItemStack it) {
		int dif = 5;
		int difs2 = 3;
		int difs3 = 5;
		int difs4 = 10;
		int difs5 = 30;
		int difF = 33;
		ItemMeta im = it.getItemMeta();
		if(rand.nextInt(dif)+1 == 1) {
			if(rand.nextInt(difs5)+1 == 1) {
				im.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
			}else if(rand.nextInt(difs4)+1 == 1) {
				im.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
			}else if(rand.nextInt(difs3)+1 == 1) {
				im.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
			}else if(rand.nextInt(difs2)+1 == 1) {
				im.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
			}else {
				
				im.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
			}
		}
		if(rand.nextInt(difF)+1 == 1) {
			im.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		}
		it.setItemMeta(im);
		return it;
	}
	}


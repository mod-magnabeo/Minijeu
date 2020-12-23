package com.Wolf_IV.MiniJeu.HikaBrain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class HikaMatch {
	public static int hikaNum = 0;
	public HikaMatch(Team team, Team team2, MainJ main) {
		HikaTimer tasks =new HikaTimer(team , team2);
		tasks.runTaskTimer(main, 0, 20);
		Location loc = new Location(Bukkit.getWorld("worldSpawn"), 750*hikaNum, 240+8+4, 1000000);
		team.setLoc(loc);
		team.locTp();
		team.setHikaTimer(tasks);
		loc = new Location(Bukkit.getWorld("worldSpawn"), 750*hikaNum, 240+8+4, 1000000+60, 180.0F, 0.0F);
		team2.setLoc(loc);
		team2.locTp();
		team2.setHikaTimer(tasks);
		tasks.inHika = true;
		tasks.freeze = true;
		hikaNum++;
		
		ItemStack sword =new ItemStack(Material.WOOD_SWORD);
		ItemMeta swordMeta =sword.getItemMeta();
		swordMeta.spigot().setUnbreakable(true);
		sword.setItemMeta(swordMeta);
		
		ItemStack gapple =new ItemStack(Material.GOLDEN_APPLE, 64);
		ItemMeta gappleMeta =gapple.getItemMeta();
		gappleMeta.setLore(Arrays.asList("Regen toute ta vie"));
		gapple.setItemMeta(gappleMeta);
		
		ItemStack pickaxe =new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta pickaxeMeta =pickaxe.getItemMeta();
		pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 0, true);
		pickaxeMeta.spigot().setUnbreakable(true);
		pickaxe.setItemMeta(pickaxeMeta);
		
		ItemStack blocks =new ItemStack(Material.HARD_CLAY, 64);
		
		for(int i = 1; i<=4; i++) {
			if(team.getHikaTimer().t1.getPlayer(i) != null) {
			team.getHikaTimer().t1.getPlayer(i).getInventory().setItem(0, sword);
			team.getHikaTimer().t1.getPlayer(i).getInventory().setItem(1, pickaxe);
			team.getHikaTimer().t1.getPlayer(i).getInventory().setItem(5, gapple);
			team.getHikaTimer().t1.getPlayer(i).getInventory().setItem(6, blocks);
			
			team.getHikaTimer().t1.getPlayer(i).getInventory().setHelmet(armorColor(Material.LEATHER_HELMET, Color.GREEN));
			team.getHikaTimer().t1.getPlayer(i).getInventory().setChestplate(armorColor(Material.LEATHER_CHESTPLATE, Color.GREEN));
			team.getHikaTimer().t1.getPlayer(i).getInventory().setLeggings(armorColor(Material.LEATHER_LEGGINGS, Color.GREEN));
			team.getHikaTimer().t1.getPlayer(i).getInventory().setBoots(armorColor(Material.LEATHER_BOOTS, Color.GREEN));
			}
		}
		for(int i = 1; i<=4; i++) {
			if(team.getHikaTimer().t2.getPlayer(i) != null) {
			team.getHikaTimer().t2.getPlayer(i).getInventory().setItem(0, sword);
			team.getHikaTimer().t2.getPlayer(i).getInventory().setItem(1, pickaxe);
			team.getHikaTimer().t2.getPlayer(i).getInventory().setItem(5, gapple);
			team.getHikaTimer().t2.getPlayer(i).getInventory().setItem(6, blocks);
			
			team.getHikaTimer().t2.getPlayer(i).getInventory().setHelmet(armorColor(Material.LEATHER_HELMET, Color.AQUA));
			team.getHikaTimer().t2.getPlayer(i).getInventory().setChestplate(armorColor(Material.LEATHER_CHESTPLATE, Color.AQUA));
			team.getHikaTimer().t2.getPlayer(i).getInventory().setLeggings(armorColor(Material.LEATHER_LEGGINGS, Color.AQUA));
			team.getHikaTimer().t2.getPlayer(i).getInventory().setBoots(armorColor(Material.LEATHER_BOOTS, Color.AQUA));
			}
		}
	}
	
	ItemStack armorColor(Material mat, Color color) {
		ItemStack armor =new ItemStack(mat);
		LeatherArmorMeta armorMeta =(LeatherArmorMeta)armor.getItemMeta();
		armorMeta.spigot().setUnbreakable(true);
		armorMeta.setColor(color);
		armor.setItemMeta(armorMeta);
		return armor;
	}
}

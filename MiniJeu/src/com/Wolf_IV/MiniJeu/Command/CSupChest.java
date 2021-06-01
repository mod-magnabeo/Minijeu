package com.Wolf_IV.MiniJeu.Command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.HungerGame.HungerChest;

public class CSupChest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("supchest")) {
				//Player player = (Player)sender;
				int i=0;
				for(Location loc: HungerChest.cLoc) {
					try {
					Chest chest = (Chest)loc.getBlock().getState();
					if(chest.getInventory() != null) {
					chest.getInventory().clear();
					}else {
						Bukkit.broadcastMessage("oula");
					}
					loc.getBlock().setType(Material.AIR);
					}catch(Exception e) {
						Bukkit.broadcastMessage(loc.getX()+"  "+loc.getZ());
					}
					
					i++;
				}
				sender.sendMessage("Les coffres on etait détruit");
				return true;
			}
		//}
		return false;
	}

}

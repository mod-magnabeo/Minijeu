package com.Wolf_IV.MiniJeu.BuildBattle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class BuildTimer extends BukkitRunnable{
	public int timeS = 0;
	public int timeM = 5;
	public static boolean vote=false;
	public static boolean constru=false;
	public static int voteT = 0;
	public String timeA = "0:00";
	public String phase = "§eConstruction";
	public boolean cancel = false;



	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		boolean WizUHCb = false;
		String WizUHC;
		
		if(WizUHCb==true) {
			WizUHC="§aBuild §eBattle";
			WizUHCb=false;
		}else {
			WizUHC="§eBuild §aBattle";
			WizUHCb=true;
		}
		if(timeM==0 && timeS<=0 ) {
			timeS=45;
			if(vote==false) {
				phase = "§eVote";
			vote=true;
			constru = false;
			for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
				playerO.getInventory().clear();
				playerO.getInventory().setHelmet(null);
				playerO.getInventory().setLeggings(null);
				playerO.getInventory().setBoots(null);
				playerO.getInventory().setChestplate(null);
				
				Wool wool = new Wool(DyeColor.PURPLE);
				ItemStack Disgusting = wool.toItemStack(1);
    			ItemMeta customDisgusting =Disgusting.getItemMeta();
    			customDisgusting.setDisplayName("§5Disgusting +1");//fait gaffe de le changer aussi dans la method on Interact
    			Disgusting.setItemMeta(customDisgusting);
    			playerO.getInventory().setItem(2, Disgusting);
    			
    			wool = new Wool(DyeColor.RED);
				ItemStack Bad = wool.toItemStack(1);
    			ItemMeta customBad =Bad.getItemMeta();
    			customBad.setDisplayName("§4Bad +2");//fait gaffe de le changer aussi dans la method on Interact
    			Bad.setItemMeta(customBad);
				playerO.getInventory().setItem(3, Bad);
    			
				wool = new Wool(DyeColor.ORANGE);
				ItemStack Ok = wool.toItemStack(1);
    			ItemMeta customOk =Ok.getItemMeta();
    			customOk.setDisplayName("§6Ok +3");//fait gaffe de le changer aussi dans la method on Interact
    			Ok.setItemMeta(customOk);
				playerO.getInventory().setItem(4, Ok);
				
				wool = new Wool(DyeColor.YELLOW);
				ItemStack Good = wool.toItemStack(1);
    			ItemMeta customGood =Good.getItemMeta();
    			customGood.setDisplayName("§eGood +4");//fait gaffe de le changer aussi dans la method on Interact
    			Good.setItemMeta(customGood);
				playerO.getInventory().setItem(5, Good);
				
				wool = new Wool(DyeColor.GREEN);
				ItemStack VeryGood = wool.toItemStack(1);
    			ItemMeta customVeryGood =VeryGood.getItemMeta();
    			customVeryGood.setDisplayName("§aVery Good +5");//fait gaffe de le changer aussi dans la method on Interact
    			VeryGood.setItemMeta(customVeryGood);
				playerO.getInventory().setItem(6, VeryGood);
				}
			}
			if(voteT < CStart.nubTeamC){
				voteT++;
				TeamC.setAllTeamVote(false);
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.teleport(TeamC.getTeam(BuildBattle.getTeam(voteT)).getLoc());
					}
				
			}else {
				vote=false;
				cancel = true;
				timeS=0;
				phase = "§eEnd";
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.teleport(new Location(Bukkit.getWorld("worldSpawn"), 30000, 80, 3000));
					playerO.getInventory().clear();
					playerO.getInventory().setHelmet(null);
					playerO.getInventory().setLeggings(null);
					playerO.getInventory().setBoots(null);
					playerO.getInventory().setChestplate(null);
					}
			}
			
		}else if(timeS == 0) {
			timeM--;
			timeS=59;
		}else {
			timeS--;
		}
		
		timeA = timeM+":"+timeS;
		
		
		
		//p.resetBoard();
		 ScoreboardManager scoreM = Bukkit.getScoreboardManager();
		Scoreboard score = scoreM.getNewScoreboard();
		/*if(score.getObjective("health") != null) {
			score.getObjective("health").unregister();
		}*/
		Objective oH= score.registerNewObjective("health", "health");
		oH.setDisplayName(ChatColor.RED+"♡");
		oH.setDisplaySlot(DisplaySlot.BELOW_NAME);
		
		Objective o = score.registerNewObjective("Debut", "Pvp");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(WizUHC);
		Score temps = o.getScore("§bTemps restant: "+timeA);
		//Score debut2 = o.getScore("voir le temps écoulrré");
		Score pvp = o.getScore(phase);
		Score wolf = o.getScore("§9-Wolf_IV");
		Score WU = o.getScore("      "+WizUHC);
		temps.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(3);
		wolf.setScore(2);
		WU.setScore(1);
		if(cancel==true) {
			cancel();
		}
		
		for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
			playerO.setScoreboard(score);
			}
		
	}

}

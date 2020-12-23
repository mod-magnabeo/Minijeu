package com.Wolf_IV.MiniJeu.HikaBrain;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.MiniJeu.Team.Team;

public class HikaTimer extends BukkitRunnable {
	Team t1 = new Team();
	Team t2 = new Team();
	boolean inHika = true;
	int pts1 = 0;
	int pts2 = 0;
	int coold = 3;
	boolean freeze = false;
	boolean ingame = false;
	int timeS = 0;
	int timeM = 5;
	String timeA = "0:0";

	public HikaTimer(Team team, Team team2) {
		this.t1=team;
		this.t2=team2;
	}

	@Override
	public void run() {
		if(coold == 0) {
			if(ingame == false) {
				ingame = true;
				t1.locTp();
				t2.locTp();
				Constru();
				freeze = false;
			}
		}else {
			for(int i = 1; i<=4; i++) {
				if(t1.getPlayer(i) != null) {
				t1.getPlayer(i).sendMessage("§bSa redémarre dans "+coold);
				}
			}
			for(int i = 1; i<=4; i++) {
				if(t2.getPlayer(i) != null) {
				t2.getPlayer(i).sendMessage("§bSa redémarre dans "+coold);
				}
			}
			coold--;
		}
		if(timeS == 0) {
			timeM--;
			timeS=59;
		}else {
			timeS--;
		}
		if((timeS == 0 && timeM == 0) || timeM < 0) {
			
			if(pts1 > pts2) {
				for(int i = 1; i<=4; i++) {
					if(t1.getPlayer(i) != null) {
					t1.getPlayer(i).sendMessage("§bVous avez remporter la partie §e+20 points");
					}
				}
				for(int i = 1; i<=4; i++) {
					if(t2.getPlayer(i) != null) {
					t2.getPlayer(i).sendMessage("§dVous avez perdu la partie");
					}
				}
				t1.addCoins(20);
			}else if(pts1 < pts2) {
				for(int i = 1; i<=4; i++) {
					if(t2.getPlayer(i) != null) {
					t2.getPlayer(i).sendMessage("§bVous avez remporter la partie §e+20 points");
					}
				}
				for(int i = 1; i<=4; i++) {
					if(t1.getPlayer(i) != null) {
					t1.getPlayer(i).sendMessage("§dVous avez perdu la partie");
					}
				}
				t2.addCoins(20);
			}else{
				for(int i = 1; i<=4; i++) {
					if(t1.getPlayer(i) != null) {
					t1.getPlayer(i).sendMessage("§bExéquaut §e+10 points");
					}
				}
				for(int i = 1; i<=4; i++) {
					if(t2.getPlayer(i) != null) {
					t2.getPlayer(i).sendMessage("§bExéquaut §e+10 points");
					}
				}
				t1.addCoins(10);
				t2.addCoins(10);
			}
			Location loc =new Location(Bukkit.getWorld("worldSpawn"), 30000, 80, 3000);
			t1.setLoc(loc);
			t2.setLoc(loc);
			t1.locTp();
			t2.locTp();
			freeze = false;
			inHika =false;
			cancel();
		}
		
		timeA = timeM+":"+timeS;
		
		 ScoreboardManager scoreM = Bukkit.getScoreboardManager();
		Scoreboard score = scoreM.getNewScoreboard();
		/*if(score.getObjective("health") != null) {
			score.getObjective("health").unregister();
		}*/
		/*Objective oH= score.registerNewObjective("health", "health");
		oH.setDisplayName(ChatColor.RED+"♡");
		oH.setDisplaySlot(DisplaySlot.BELOW_NAME);*/
		
		Objective o = score.registerNewObjective("Debut", "Pvp");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§aHika§eBrain");
		Score temps = o.getScore("§bTemps restant: "+timeA);
		//Score debut2 = o.getScore("voir le temps écoulrré");
		Score pvp = o.getScore("§a"+t1.getTeamName()+": "+pts1);
		Score wolf = o.getScore("§b"+t2.getTeamName()+": "+pts2);
		Score WU = o.getScore("      "+"§eHika§aBrain");
		temps.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(3);
		wolf.setScore(2);
		WU.setScore(1);
		for(int i = 1; i<=4; i++) {
			if(t1.getPlayer(i) != null) {
			t1.getPlayer(i).setScoreboard(score);
			}
		}
		for(int i = 1; i<=4; i++) {
			if(t2.getPlayer(i) != null) {
			t2.getPlayer(i).setScoreboard(score);
			}
		}

	}
	
	public void Constru() {
		int x = t1.getLoc().getBlockX();
		int y = t1.getLoc().getBlockY();
		int z = t1.getLoc().getBlockZ();
		for(int i = 0; i <=60;i++) {
			for(int i2 = -7; i2 <=7;i2++) {
				for(int i3 = -12; i3 <=4;i3++) {
				Location bloc =new Location(Bukkit.getWorld("worldSpawn"), x+i2, y+i3, z+i);
				bloc.getBlock().setType(Material.AIR);
				}
			}
		}
		for(int i = 0; i <=60;i++) {
			for(int i2 = -12; i2 <=-4;i2++) {
				Location bloc =new Location(Bukkit.getWorld("worldSpawn"), x, y+i2, z+i);
				bloc.getBlock().setType(Material.HARD_CLAY);
			}
		}
		Location bloc =new Location(Bukkit.getWorld("worldSpawn"), x, y-4, z);
		bloc.getBlock().setType(Material.EMERALD_BLOCK);
		bloc =new Location(Bukkit.getWorld("worldSpawn"), x, y-4, z+60);
		bloc.getBlock().setType(Material.DIAMOND_BLOCK);
		for(int zi = 0; zi <=2;zi++) {
		for(int xi = -1; xi <=1;xi++) {
		bloc =new Location(Bukkit.getWorld("worldSpawn"), x+xi, y-1, z+zi);
		bloc.getBlock().setType(Material.GLASS);
		bloc =new Location(Bukkit.getWorld("worldSpawn"), x+xi, y-1, z+60-zi);
		bloc.getBlock().setType(Material.GLASS);
		}
		}
	}

}

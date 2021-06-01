package com.Wolf_IV.MiniJeu.HungerGame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;


public class HungerListen implements Listener{
	static boolean start = false;
	static Player[] alive = new Player[150];
	static int ai = 0;
	public static void start() {
		start = true;
		ai = 0;
		for(int i = 0; i<=CStart.nubTeamC; i++) {
			Team team = TeamC.getTeam(i);
			if(team != null) {
				Location loc =new Location(Bukkit.getWorld("worldSpawn"), 0, 125, 0);
				team.setLoc(loc);
				team.locTp();
				for(int i2 = 1; i2<=4; i2++) {
				if(team.getPlayer(i2) != null) {
					alive[ai] = team.getPlayer(i2);
					ai++;
				}
				}
			}
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set "+HungerGame.spaceS*2);
	}
	public static void win(Team team) {
		start = false;
		if(team!= null) {
		Bukkit.broadcastMessage("§aLa victoire du Hunger Game est atribué au §e"+team.getTeamName()+" §ail reçoive donc 100 points");
		team.addCoins(100);
		}else {
			Bukkit.broadcastMessage("§aPersonne n'a gagné cette partie");
		}
		HungerTimer.stop = true;
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 29999999");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "supchest");
		for(int i = 0; i<=CStart.nubTeamC; i++) {
			Team t = TeamC.getTeam(i);
			if(t != null) {
				Location loc =new Location(Bukkit.getWorld("worldSpawn"), 30000, 80, 3000);
				t.setLoc(loc);
				t.locTp();
			}
		}
	}
	@EventHandler
	public static void onDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		boolean aEnlever  = false;
		for(int i = 0; i<=ai; i++) {
			if(alive[i] != null && player == alive[i]/*a enlever*/ && aEnlever == false) {
				alive[i] = null;
				aEnlever = true;
			}
		}
		
		Team[] teamAlive = new Team[CStart.nubTeamC+1];
		Team winner = null;
		int teamNb = 0;
		for(int i = 0; i<=ai; i++) {
			if(alive[i] != null) {
				boolean tR = false;
				for(Team team :teamAlive) {
					if(team != null && team == TeamC.getTeamWithPlayer(alive[i])) {
						Bukkit.broadcastMessage("team");
						tR = true;
					}
				}
				if(!tR) {
						winner = TeamC.getTeamWithPlayer(alive[i]);
						teamNb++;
						}
					}
				}
		
		if(teamNb == 1 && winner != null) {
			win(winner);
		}
	}
	
	@EventHandler
    public void onDamage(EntityDamageEvent event) {
		if(start && HungerTimer.start !=0) {
		event.setCancelled(true);
		}
	}
}

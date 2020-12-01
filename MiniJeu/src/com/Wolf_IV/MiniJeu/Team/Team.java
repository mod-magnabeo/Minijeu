package com.Wolf_IV.MiniJeu.Team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Team {
	protected String teamName;
	protected String[] player =new String[6];
	protected boolean[] playerVoted =new boolean[6];
	protected Location warp =null;
	protected int coins =0;

	public void setTeam(String player, String player2, String player3, String player4, String teamName) {
		Bukkit.broadcastMessage("salut");
		this.teamName = teamName;
		this.player[1]=player;
		this.player[2]=player2;
		this.player[3]=player3;
		this.player[4]=player4;
	}
	
	public void setString(String player) {
		
		
	}
	
	public Player getPlayer(int i) {
		
	return Bukkit.getPlayer(this.player[i]);
	}
	
	public String getPlayerName(int i) {
		
		return this.player[i];
		}
	
	public String getTeamName() {
		return this.teamName;
		
	}
	
	public void setLoc(Location loc) {
		this.warp = loc;
	}
	
	public Location getLoc() {
		return this.warp;
	}
	
	public void locTp() {
		getPlayer(1).teleport(this.warp);
		getPlayer(2).teleport(this.warp);
		getPlayer(3).teleport(this.warp);
		getPlayer(4).teleport(this.warp);
	}
	//New
	public int getNumPlayer(Player player) {
		for(int i = 0; i<=4; i++) {
		if(player.getName().equals(this.player[i])) {
			return i;
		}
			
		}
		return 0;
	}
	
	public void setCoins(int set) {
		this.coins = set;
	}
	
	public void addCoins(int add) {
		this.coins = this.coins+add;
	}
	
	public int getCoins() {
		return this.coins;
	}
	
	public boolean playerHasVoted(int playNub) {
		return playerVoted[playNub];
		
	}
	
	public void setPlayerVote(int playNub, boolean vote) {
		playerVoted[playNub]=vote;
	}
}

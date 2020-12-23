package com.Wolf_IV.MiniJeu.BuildBattle;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class BuildBattle {
	static int[] teamNub = new int[CStart.nubTeamC+1];
	Random rand = new Random();
	
	BuildTimer tasks = new BuildTimer();
	public BuildBattle() {
		
		
	}
	public void start(MainJ main) {
		BuildTimer.voteT=0;
		BuildTimer.constru = true;
		int y= 100;
		int z=5000000;
		for(int i=1; i<=CStart.nubTeamC;i++) {
			Bukkit.broadcastMessage("hello"+i+" = "+CStart.nubTeamC);
			TeamC.getTeam(i).setLoc(new Location(Bukkit.getWorld("worldSpawn"), 750*i, y, z));
			TeamC.getTeam(i).locTp();
			teamNub[i]=i;
			for(int i2=1; i2<=4;i2++) {
				TeamC.getTeam(i).getPlayer(i2).setGameMode(GameMode.CREATIVE);
			}
		}
		
		for(int i=rand.nextInt(50)+20; i != 0; i--) {
			int chose1 = teamNub[rand.nextInt(CStart.nubTeamC-1)+1];
			int chose2 = teamNub[rand.nextInt(CStart.nubTeamC-1)+1];
			int container = chose1;
			chose1=chose2;
			chose2=container;
		}
		tasks.runTaskTimer(main, 0, 20);
		
		
	}
	
	public static int getTeam(int x) {
		return teamNub[x];
	}

}

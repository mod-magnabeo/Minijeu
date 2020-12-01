package com.Wolf_IV.MiniJeu.Team;

import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.Command.CStart;

public class TeamC {
	public static Team getTeam(int x) {
		
		if(x==1 && CStart.team1 != null) {
			return CStart.team1;
		}else if(x==2 && CStart.team2 != null) {
			return CStart.team2;
		}else if(x==3 && CStart.team3 != null) {
			return CStart.team3;
		}else if(x==4 && CStart.team4 != null) {
			return CStart.team4;
		}else if(x==5 && CStart.team5 != null) {
			return CStart.team5;
		}
		return null;
		
	}
	
	public static void setAllTeamVote(boolean vote) {
		for(int i = 1; i<=CStart.nubTeamC; i++) {
			getTeam(i).setPlayerVote(1, vote);
			getTeam(i).setPlayerVote(2, vote);
			getTeam(i).setPlayerVote(3, vote);
			getTeam(i).setPlayerVote(4, vote);
		}
	}
	
	public static Team getTeamWithPlayer(Player player) {
		for(int i = 1; i<=CStart.nubTeamC; i++) {
			if(getTeam(i).getNumPlayer(player) != 0) {
				return getTeam(i);
			}
		}
		return null;
	}
}

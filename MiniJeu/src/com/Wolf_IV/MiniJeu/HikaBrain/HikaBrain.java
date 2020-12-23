package com.Wolf_IV.MiniJeu.HikaBrain;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class HikaBrain {
	private MainJ main;
	static int mat=0;
	public HikaBrain(MainJ mainJ) {
		this.main= mainJ;
		if(mat==0) {
			MatchMaking.init();
		}
		for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
			playerO.setGameMode(GameMode.SURVIVAL);
		}
		
		if(mat<=MatchMaking.maxMatch) {
			MatchMaking.match(mat);
			for(int x = 1; x <= 4; x++) {
			if(MatchMaking.mAtT>=x) {
				//Bukkit.broadcastMessage(x+": "+MatchMaking.t1[x]+" "+MatchMaking.t2[x]);
				HikaMatch match = new HikaMatch(TeamC.getTeam(MatchMaking.t1[x]), TeamC.getTeam(MatchMaking.t2[x]), main);
			}
			}
			mat++;
		}
		
	}
	
	
}

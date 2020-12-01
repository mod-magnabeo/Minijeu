package com.Wolf_IV.MiniJeu.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.BuildBattle.BuildBattle;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class CStart implements CommandExecutor {

	public static int nubTeam = 5;
	public static int nubTeamC = 0;
	//public static Team[] team =new Team[nubTeam+1];
	public static Team team1 =new Team();
	public static Team team2 =new Team();
	public static Team team3 =new Team();
	public static Team team4 =new Team();
	public static Team team5 =new Team();
	private MainJ main;
	public CStart(MainJ mainJ) {
		this.main= mainJ;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startjeu")) {
				nubTeamC=0;
				Player player = (Player)sender;
				TeamC.getTeam(1);
				for(int i=1;i<=nubTeam;i++) {
					if(TeamC.getTeam(i).getTeamName() != null) {
					nubTeamC++;
					}
					for(int i2=1; i2<=4;i2++) {
						if(TeamC.getTeam(i).getTeamName() != null) {
						Bukkit.broadcastMessage(TeamC.getTeam(i).getPlayerName(i2));
						
						}else {
							Bukkit.broadcastMessage("end");
						}
					}
				}
				BuildBattle buildBattle =new BuildBattle();
				buildBattle.start(main);
				return true;
			}
		}
		return false;
	}

}

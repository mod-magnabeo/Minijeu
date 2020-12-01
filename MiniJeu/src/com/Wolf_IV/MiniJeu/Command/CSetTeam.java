package com.Wolf_IV.MiniJeu.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.BuildBattle.BuildBattle;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class CSetTeam implements CommandExecutor {
	public static int teamCount = 1;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("setteam")) {
				Bukkit.broadcastMessage("hello");
				Player player = (Player)sender;
				if(args.length != 5) {
					player.sendMessage("§4/setteam [pseudo] [pseudo] [pseudo] [pseudo] TeamName");
					return false;
				}
				/*if(Bukkit.getPlayer(args[0]) == null || Bukkit.getPlayer(args[1]) == null || Bukkit.getPlayer(args[2]) == null || Bukkit.getPlayer(args[3]) == null) {
					player.sendMessage("§4Un des joueur n'est pas connecter");
					return false;
				}*/
		
				/*CStart.team[teamCount].setTeam(args[0],args[1],args[2],args[3], args[4]);
				teamCount++;
				Bukkit.broadcastMessage("team="+teamCount);*/
				
				//Team tim =new Team();
				if(CStart.team1.getTeamName()==null) {
					Bukkit.broadcastMessage("Tpabo");
				}
				TeamC.getTeam(teamCount).setTeam(args[0],args[1],args[2],args[3], args[4]);
				teamCount++;
				
				/*Team[] tim1 = new Team[5];
				tim1[1]=tim;
				tim1[1].setTeam(args[0],args[1],args[2],args[3], args[4]);*/
				//Bukkit.broadcastMessage("yes="+tim.getPlayerName(1));
				
				//Bukkit.broadcastMessage("salut");
				
				return true;
			}
		}
		return false;
	}

}

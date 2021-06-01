package com.Wolf_IV.MiniJeu.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.MiniJeu.MainJ;
import com.Wolf_IV.MiniJeu.BuildBattle.BuildBattle;
import com.Wolf_IV.MiniJeu.HikaBrain.HikaBrain;
import com.Wolf_IV.MiniJeu.HungerGame.HungerChest;
import com.Wolf_IV.MiniJeu.HungerGame.HungerGame;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;
import com.Wolf_IV.MiniJeu.CoinView;

public class CStart implements CommandExecutor {
	public static int gTime = 0;
	public static int nubTeam = 8;
	public static int nubTeamC = 0;
	//public static Team[] team =new Team[nubTeam+1];
	public static Team team1 =new Team();
	public static Team team2 =new Team();
	public static Team team3 =new Team();
	public static Team team4 =new Team();
	public static Team team5 =new Team();
	public static Team team6 =new Team();
	public static Team team7 =new Team();
	public static Team team8 =new Team();
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
						//Bukkit.broadcastMessage(TeamC.getTeam(i).getPlayerName(i2));
						
						}else {
							//Bukkit.broadcastMessage("end");
						}
					}
				}
				gTime++;
				CoinView.create();
				//HikaBrain hikaBrain =new HikaBrain(main);
				//BuildBattle buildBattle =new BuildBattle();
				//buildBattle.start(main);
				if(gTime == 1) {
				HungerGame hungerGame = new HungerGame(main);
				}else if(gTime == 2) {
					BuildBattle buildBattle =new BuildBattle();
					buildBattle.start(main);
				}else if(gTime == 3) {
					BuildBattle buildBattle =new BuildBattle();
					buildBattle.start(main);
				}else if(gTime == 4) {
					HikaBrain hikaBrain =new HikaBrain(main);
				}else if(gTime == 5) {
					BuildBattle buildBattle =new BuildBattle();
					buildBattle.start(main);
				}else {
					CoinView.win();
				}
				
				
				
				
				return true;
			}
		}
		return false;
	}
	private Object CoinView() {
		// TODO Auto-generated method stub
		return null;
	}

}

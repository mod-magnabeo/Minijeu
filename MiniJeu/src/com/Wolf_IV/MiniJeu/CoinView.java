package com.Wolf_IV.MiniJeu;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class CoinView {
	public static Team tOrder[] = new Team[CStart.nubTeamC+1+1];
	static int[] tClass = new int[CStart.nubTeam+1];
	static int test = 0;
	static ArmorStand stand;
	static int glass;
	public static void create() {
		ArrayList<Integer> points = new ArrayList<Integer>();
		points.add(1);
		int order[] = new int[CStart.nubTeamC+1+1];
		
		for(int i = 1 ; i<=CStart.nubTeamC; i++) {
			points.add(i, TeamC.getTeam(i).getCoins());
		}
		Collections.sort(points);
		int o = 1;
		for(int i = CStart.nubTeamC ; i>=1; i--) {
			order[o] = points.get(i);
			o++;
		}
		
		Bukkit.broadcastMessage("§6TOP TEAM");
		Bukkit.broadcastMessage("§6--------------");
		for(int i = 1 ; i<=CStart.nubTeamC; i++) {
			for(int ordre : order) {
				if(TeamC.getTeam(i).getCoins() == ordre) {
				tOrder[i] = TeamC.getTeam(i);
				Bukkit.broadcastMessage("§a"+i+": §b"+TeamC.getTeam(i).getTeamName()+" §5"+ordre+" points");
			}
			}
		}
		Bukkit.broadcastMessage("§6--------------");
	}


	public static void win() {
		Bukkit.broadcastMessage("§6VICTOIRE DE L'EQUIPE "+tOrder[1]);
		Location loc =new Location(Bukkit.getWorld("worldSpawn"), 30000, 84, 3010);
		tOrder[1].setLoc(loc);
		tOrder[1].locTp();
	}
}
		/*[14:04:45 INFO]: i1 tClas1
		[14:04:45 INFO]: i2 tClas2
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i2 tClas2
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i2 tClas2
		[14:04:45 INFO]: i1 tClas1
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i2 tClas2
		[14:04:45 INFO]: i2 tClas2
		[14:04:45 INFO]: i1 tClas1
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i3 tClas3
		[14:04:45 INFO]: i4 tClas4
		[14:04:45 INFO]: i1 tClas1
		[14:04:46 INFO]: i4 tClas4
		[14:04:46 INFO]: i1 tClas1
		[14:04:46 INFO]: i2 tClas2
		[14:04:46 INFO]: i1 tClas1
		[14:04:46 INFO]: i2 tClas2
		[14:04:46 INFO]: i1 tClas1
		[14:04:46 INFO]: i4 tClas4
		[14:04:46 INFO]: i1 tClas1*/
		/*if(stand != null) {
			int[] tClas = new int[CStart.nubTeam+1];
			for(int i=1;i<=CStart.nubTeamC;i++) {
				tClas[i]=i;
			}
			
			
			boolean mod = true;
			while(mod == true) {
				for(int i2=1;i2<=CStart.nubTeamC;i2++) {
					Bukkit.broadcastMessage("i"+i2+" tClas"+tClas[i2]);
					tClas[TeamC.getTeam(i2).getClas()] = i2;
				}
				mod = false;
			for(int i=CStart.nubTeamC;i>=1;i--) {
				boolean done = false;
				int im = 0;
				while(done == false) {
					if(tClas[i-im] == 1) {
						done = true;
					}else if(TeamC.getTeam(tClas[i-im]).getCoins() > TeamC.getTeam(tClas[i-1-im]).getCoins()) {
						glass= tClas[i];
						tClas[i] = tClas[i-1];
						tClas[i-1] = glass;
						im++;
						mod = true;
						
					}else {
						done = true;
					}
				}
				for(int i2=1;i2<=CStart.nubTeamC;i2++) {
					Bukkit.broadcastMessage("i"+i2+" tClas"+tClas[i2]);
					TeamC.getTeam(tClas[i2]).setClas(i2);
				}
			}
			Bukkit.broadcastMessage("mod"+mod);
			}
			for(int i=1;i<=CStart.nubTeamC;i++) {
				Bukkit.broadcastMessage("§a"+i+": "+TeamC.getTeam(tClas[i]).getTeamName()+"    §a"+TeamC.getTeam(tClas[i]).getCoins()+" coins");
			}
			stand.setCustomName("coins2");
		}else {
			/*for(int i=1;i<=CStart.nubTeamC;i++) {
				tClas[i]=i;
			}*//*
		Location loc =new Location(Bukkit.getWorld("worldSpawn"), 30005, 80, 3000);
		ArmorStand as = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setCustomName("coins");
        as.setCustomNameVisible(true);
        as.setVisible(false);
        //as.setPassenger(player);
		stand = as;
		}*/
		

/*ScoreboardManager scoreM = Bukkit.getScoreboardManager();
Scoreboard score = scoreM.getNewScoreboard();
Objective o= score.registerNewObjective("coins", "teamClass");
o.setDisplaySlot(DisplaySlot.BELOW_NAME);

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
	//playerO.setScoreboard(score);
for(int i=1;i<=CStart.nubTeamC;i++) {
	s[i] = o.getScore("§e"+i+": "+TeamC.getTeam(i));
	s[i].setScore(TeamC.getTeam(i).getCoins());
}
((Player) stand).setScoreboard(score);*/
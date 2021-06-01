package com.Wolf_IV.MiniJeu.HungerGame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.TeamC;


public class HungerTimer extends BukkitRunnable {
	boolean ingame = false;
	static boolean stop = false;
	int timeS = 0;
	int timeM = 20;
	static int start = 10;
	String timeA = "0:0";
	private HungerGame hungerGame;
	public HungerTimer(HungerGame hungerGame) {
		this.hungerGame= hungerGame;
		}

	@Override
	public void run() {
		if(stop == true) {
			cancel();
		}
		if(start != 0) {
			start--;
			Bukkit.broadcastMessage("§aLa partie commence dans "+start);
			return;
		}
		if(timeS == 0) {
			timeM--;
			timeS=59;
		}else {
			timeS--;
		}
		if(timeM == 10 && timeS==0) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set "+HungerGame.spaceF+" "+HungerGame.borderT);
		}
		if((timeS == 0 && timeM == 0) || timeM < 0) {
			HungerListen.win(null);
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
		o.setDisplayName("§aHunger§eGame");
		Score temps = o.getScore("§bTemps restant: "+timeA);
		//Score debut2 = o.getScore("voir le temps écoulrré");
		Score pvp = o.getScore("§aBordur 10 min");
		Score WU = o.getScore("      "+"§eHunger§aGame");
		temps.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(3);
		WU.setScore(1);
		
		for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
			playerO.setScoreboard(score);
			}
		
		

	}

}

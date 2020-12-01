package com.Wolf_IV.MiniJeu.BuildBattle;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class BuildListen implements Listener {

	@EventHandler
	public static void placeEvent(BlockPlaceEvent event) {
		if(BuildTimer.vote == true) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void breakEvent(BlockBreakEvent event) {
		if(BuildTimer.vote == true) {
			event.setCancelled(true);
		}
	}

	/*@EventHandler
	public static void moveEvent(PlayerMoveEvent event) {
		if(BuildTimer.constru == false) {
			return;
		}
		Player player = event.getPlayer();
		for(int i=1; i<=CStart.nubTeamC;i++) {
			if(TeamC.getTeam(i).isPlayerHere(player)) {
				int x = TeamC.getTeam(i).getLoc().getBlockX();
				int z = TeamC.getTeam(i).getLoc().getBlockZ();
				if(x > x+200 || x < x-200 || z > z+200 || z < z-200) {
					player.teleport(TeamC.getTeam(i).getLoc());
					player.sendMessage("§aVa pas si loin");
					event.setCancelled(true); 
					return;
				}
			}
		}
	}*/
	
	@EventHandler
	public static void clickEvent(PlayerInteractEvent event) {
		Player player =event.getPlayer();
		Action action =event.getAction();
		ItemStack it =event.getItem();
		if(BuildTimer.vote == false) {
			return;
		}
		if(it == null) {
			return;
		}
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			
		Team team = TeamC.getTeamWithPlayer(player);
		Team teamVotée = TeamC.getTeam(BuildTimer.voteT);
		if(team==null) {
			return;
		}
		int pNub = team.getNumPlayer(player);
		
		boolean hasVoted = false;
		int coinsGiven = 0;
		
		
		
		if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("§5Disgusting +1")) {
			hasVoted = true;
			coinsGiven = 1;
		}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("§4Bad +2")) {
			hasVoted = true;
			coinsGiven = 2;
		}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("§6Ok +3")) {
			hasVoted = true;
			coinsGiven = 3;
		}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("§eGood +4")) {
			hasVoted = true;
			coinsGiven = 4;
		}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("§aVery Good +5")) {
			hasVoted = true;
			coinsGiven = 5;
		}
		if(hasVoted == false) {
			return;
		}
		
		if(team.playerHasVoted(pNub)) {
			player.sendMessage("§4Vous avez déjà voter");
			return;
		}
		
		if(team.getTeamName().equals(teamVotée.getTeamName())) {
			player.sendMessage("§4Vous ne pouver pas voter pour votre propre équipe");
			return;
		}
		teamVotée.addCoins(coinsGiven);
		team.setPlayerVote(pNub, true);
		player.sendMessage("§aVous avez voter");
		Bukkit.broadcastMessage(teamVotée.getTeamName()+" has "+teamVotée.getCoins()+" coins(A sup dans BuildListen l.117)");
		
		
		//weird teamVotée = null si c'est le cas sa commence a 2, 3, null
	
	}
  }
	
}

package com.Wolf_IV.MiniJeu.HikaBrain;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.MiniJeu.Team.Team;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class HikaListen implements Listener {
	public static void kill(Player player) {
		Team team = TeamC.getTeamWithPlayer(player);
		Location loc = team.getLoc();
		player.teleport(loc);
		player.setHealth(20.0F);
		player.setFoodLevel(20);
		player.setFallDistance(0.0F);
		player.removePotionEffect(PotionEffectType.ABSORPTION);
		player.removePotionEffect(PotionEffectType.REGENERATION);
		player.setGameMode(GameMode.SURVIVAL);
	}
	
	@EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
		Player player = event.getPlayer();
		if(TeamC.getTeamWithPlayer(player).getHikaTimer().inHika == false) {
			return;
		}
		if(event.getItem().getType() == Material.GOLDEN_APPLE) {
		player.removePotionEffect(PotionEffectType.ABSORPTION);
		player.removePotionEffect(PotionEffectType.REGENERATION);
		player.setHealth(20.0F);
		}
	}
	@EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		Player victim = (Player) event.getEntity();
		Player killer = (Player) event.getDamager();
		Team team = TeamC.getTeamWithPlayer(victim);
		if(team.getNumPlayer(killer) != 0) {
			event.setCancelled(true);
			return;
		}
	}
	@EventHandler
    public void onDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Team team = TeamC.getTeamWithPlayer(player);
			if(team.getHikaTimer().inHika == false) {
				return;
			}
		if(player.getHealth()-event.getDamage() <=0) {
			kill(player);
			event.setCancelled(true);
		}
		}
	}
	@EventHandler
	public static void breakEvent(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Team team = TeamC.getTeamWithPlayer(player);
		if(team.getHikaTimer().inHika == true) {
			if(event.getBlock().getType() != Material.HARD_CLAY) {
				player.sendMessage("§4You cannot break this block");
				event.setCancelled(true);
			}
		}
	}
	/*@EventHandler
	public static void deathEvent(EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Team team = TeamC.getTeamWithPlayer(player);
			if(team.getHikaTimer().inHika == true) {
				
				Bukkit.broadcastMessage("marche");
				kill(player);
				/*player.setGameMode(GameMode.SURVIVAL);
				//player.closeInventory();
			}
		}
	}*/
	@EventHandler
	public static void placeEvent(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Team team = TeamC.getTeamWithPlayer(player);
		double x = event.getBlock().getLocation().getBlockX();
		double y = event.getBlock().getLocation().getBlockY();
		double z = event.getBlock().getLocation().getBlockZ();
		if(team.getHikaTimer().inHika == true) {
			if(event.getBlock().getType() == Material.HARD_CLAY) {
				if(z < 1000000 || z > 1000000+60) {
					player.sendMessage("§4Va pas trop loin!");
					event.setCancelled(true);
					return;
				}else if(x <= team.getLoc().getX()+2 && x >= team.getLoc().getX()-2 && y > 248 && y < 248+7) {
					if(z <= 1000000+2 || z >= 1000000+60-2) {
						player.sendMessage("§4Trop près du spawn");
						event.setCancelled(true);
						return;
					}
				}
				if(x <= team.getLoc().getX()+7 && x >= team.getLoc().getX()-7) {
				player.getInventory().setItemInHand(new ItemStack(Material.HARD_CLAY, 64));
				return;
				}else {
					player.sendMessage("§4Va pas trop loin!");
					event.setCancelled(true);
				}
			}
		}
	}
	@EventHandler
	public static void moveEvent(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Team team = TeamC.getTeamWithPlayer(player);
		Location ploc1 = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY()-1, player.getLocation().getZ());
		if(team.getHikaTimer().inHika == true) {
			/*if(team.getHikaTimer().freeze == true) {
				event.setCancelled(true);
			}*/
			if(player.getLocation().getY() < 240) {
				
				kill(player);
				return;
			}else if(ploc1.getBlock().getType() == Material.DIAMOND_BLOCK && team == team.getHikaTimer().t1) {
				for(int i = 1; i<=4; i++) {
					if(team.getHikaTimer().t1.getPlayer(i) != null) {
					team.getHikaTimer().t1.getPlayer(i).sendMessage("§6"+player.getDisplayName()+" a marquer un but §e+5 points");
					}
				}
				for(int i = 1; i<=4; i++) {
					if(team.getHikaTimer().t2.getPlayer(i) != null) {
					team.getHikaTimer().t2.getPlayer(i).sendMessage("§4"+player.getDisplayName()+" a marquer un but");
					}
				}
				team.getHikaTimer().pts1++;
				team.addCoins(5);
			}else if(ploc1.getBlock().getType() == Material.EMERALD_BLOCK && team == team.getHikaTimer().t2) {
				for(int i = 1; i<=4; i++) {
					if(team.getHikaTimer().t1.getPlayer(i) != null) {
					team.getHikaTimer().t1.getPlayer(i).sendMessage("§4"+player.getDisplayName()+" a marquer un but");
					}
				}
				for(int i = 1; i<=4; i++) {
					if(team.getHikaTimer().t2.getPlayer(i) != null) {
					team.getHikaTimer().t2.getPlayer(i).sendMessage("§6"+player.getDisplayName()+" a marquer un but §e+5 points");
					}
				}
				team.getHikaTimer().pts2++;
				team.addCoins(5);
			}else {
				return;
			}
			team.getHikaTimer().coold = 3;
			team.getHikaTimer().t1.locTp();
			team.getHikaTimer().t2.locTp();
			team.getHikaTimer().ingame = false;
			team.getHikaTimer().freeze = true;
			
		}
	}
}

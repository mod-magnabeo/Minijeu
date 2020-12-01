package com.Wolf_IV.MiniJeu;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.MiniJeu.BuildBattle.BuildListen;
import com.Wolf_IV.MiniJeu.Command.CSetTeam;
import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.Team;

public class MainJ extends JavaPlugin implements Listener{
	//public static MainJ main = this;
	
	@Override
	public void onEnable() {
		getCommand("setteam").setExecutor(new CSetTeam());

	getCommand("startjeu").setExecutor(new CStart(this));
	
	getServer().getPluginManager().registerEvents(new BuildListen(), this);
	}
}
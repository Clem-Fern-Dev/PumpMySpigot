package fr.mrfern.pumpmylobby.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mrfern.pumpmylobby.server.ServerManager;

public class NavBarManager {

	private Inventory inv;
	private Player player;
	
	public NavBarManager(Player p) {
		setInv(p.getInventory());
		setPlayer(p);
	}
	
	@SuppressWarnings("deprecation")
	public void giveNavInv(ServerManager manager) {
		
		inv.clear();
		
		ItemStack item = null;
		String serverName;
		
		if(!player.hasPermission("server.ragna1") | !manager.getServerState("ragna1")) {
			serverName = ChatColor.RED + "PumpMyRagna#1";
			item = new ItemStack(166); //barriere invisible
		}else {
			serverName = ChatColor.LIGHT_PURPLE + "PumpMyRagna#1";
			item = new ItemStack(Material.APPLE);			
		}		
		giveItem(serverName, 2, item);
		
		if(!player.hasPermission("server.ragna2") | !manager.getServerState("ragna2")) {
			serverName = ChatColor.RED + "PumpMyRagna#2";
			item = new ItemStack(166); //barriere invisible
		}else {
			serverName = ChatColor.LIGHT_PURPLE + "PumpMyRagna#2";
			item = new ItemStack(Material.BREAD);			
		}		
		giveItem(serverName, 6, item);
		
		if(!player.hasPermission("server.dev")){
			serverName = ChatColor.GOLD + "" + ChatColor.MAGIC + "abcd" + ChatColor.RESET + "" + ChatColor.RED + " SECRET " + ChatColor.RESET + "" + ChatColor.GOLD + "" + ChatColor.MAGIC + "abcd" ;
			item = new ItemStack(166); //barriere invisible
		}else if(!manager.getServerState("dev")) {
			serverName = ChatColor.RED + "Serveur developpement";
			item = new ItemStack(166); //barriere invisible
		}else {
			serverName = ChatColor.GREEN + "Serveur developpement";
			item = new ItemStack(Material.BEDROCK);			
		}		
		giveItem(serverName, 4, item);
		
	}
	
	public void giveItem(String serverName,int pos,ItemStack item) {
			ItemMeta navItemMeta = item.getItemMeta();						
			navItemMeta.setDisplayName(serverName);
			item.setItemMeta(navItemMeta);			
			inv.setItem(pos, item);		
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}

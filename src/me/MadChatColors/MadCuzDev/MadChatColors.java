package me.MadChatColors.MadCuzDev;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

public class MadChatColors extends JavaPlugin implements Listener{

	@Override
    public void onEnable() {
       getLogger().info("MadChatColors Enabled");
       this.saveDefaultConfig();
       getServer().getPluginManager().registerEvents(this, this);
    }
   
    @Override
    public void onDisable() {
        getLogger().info("MadChatColors Disabled");
    }
    
    public String underline = null;
    public String italic = null;
    public String strike = null;
    public String bold = null;
    
    @EventHandler
    public void chatColor1(AsyncPlayerChatEvent event) {
    	Player player = (Player) event.getPlayer();
    	
    	if (underline != null && getConfig().getBoolean("underlineEnable." + player.getName()) == true) {
    		underline = getConfig().getString("underline." + player.getName());
    	} else {
    	underline = "";
    	} if (italic != null && getConfig().getBoolean("italicEnable." + player.getName()) == true) {
    		italic = getConfig().getString("italic." + player.getName());
    	} else {
    	italic = "";
    	} if (strike != null && getConfig().getBoolean("strikeEnable." + player.getName()) == true) {
    		italic = getConfig().getString("strike." + player.getName());
    	} else {
    	strike = "";
    	} if (bold != null && getConfig().getBoolean("boldEnable." + player.getName()) == true) {
    		bold = getConfig().getString("bold." + player.getName());
    	} else {
    	bold = "";
    	}
	if (getConfig().getBoolean("colorEnable." + player.getName())) {
		if (getConfig().getString("color." + player.getName()).equals("lightRed")) {
			event.setMessage("§c" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("lightGreen")) {
			event.setMessage("§a" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("darkRed")) {
			event.setMessage("§4" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("gold")) {
			event.setMessage("§6" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("darkGreen")) {
			event.setMessage("§2" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("lightBlue")) {
			event.setMessage("§b" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("cyan")) {
			event.setMessage("§3" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("darkBlue")) {
			event.setMessage("§1" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("blue")) {
			event.setMessage("§9" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("yellow")) {
			event.setMessage("§e" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("pink")) {
			event.setMessage("§d" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("purple")) {
			event.setMessage("§5" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("white")) {
			event.setMessage("§f" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("lightGray")) {
			event.setMessage("§7" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("darkGray")) {
			event.setMessage("§8" + underline + strike + italic + bold + event.getMessage());
		} else if (getConfig().getString("color." + player.getName()).equals("black")) {
			event.setMessage("§0" + underline + strike + italic + bold + event.getMessage());
		}
	} else if (!getConfig().getBoolean("colorEnable." + player.getName())) {
		event.setMessage(underline + strike + italic + bold + event.getMessage());
	} else {
		event.setMessage(underline + strike + italic + bold + event.getMessage());
	}
    }
    
    @EventHandler
    public void onClick1(InventoryClickEvent event){
     if(event.getInventory().getName().equals("§c§lChat Colors")) {
      event.setCancelled(true);
     }
    }
    
    @EventHandler
    public void onClickLightRedColor(InventoryClickEvent event){
     
    	if(event.getInventory().getName().equals("§c§lChat Colors")) {
    		Player whoClick = (Player) event.getWhoClicked();
    	if(event.getCurrentItem().getDurability() == DyeColor.RED.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.lightred")) {
    	 getConfig().addDefault("color." + whoClick.getName(), "lightRed");
         getConfig().set("color." + whoClick.getName(), "lightRed");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §c§n§lred§c§l chat color");
    	} else {
   		 whoClick.sendMessage("§c§lYou don't have access to §c§n§llight red§c§l chat color");
   	 }
     } else if(event.getCurrentItem().getType().equals(Material.REDSTONE_BLOCK)) {
    	 
    	 if (whoClick.hasPermission("mcc.darkred")) {
    	 getConfig().addDefault("color." + whoClick.getName(), "darkRed");
         getConfig().set("color." + whoClick.getName(), "darkRed");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §4§n§ldark red§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §4§n§ldark red§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.LIME.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.lightgreen")) {
         getConfig().addDefault("color." + whoClick.getName(), "lightGreen");
         getConfig().set("color." + whoClick.getName(), "lightGreen");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §a§n§llight green§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §a§n§llight green§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getType().equals(Material.BARRIER)) {
    	 
         getConfig().addDefault("colorEnable." + whoClick.getName(), false);
         getConfig().set("colorEnable." + whoClick.getName(), false);
         saveConfig();
         whoClick.sendMessage("§c§lReset Chat Color");
     } else if(event.getCurrentItem().getDurability() == (short) 4 && event.getCurrentItem().getType().equals(Material.STAINED_CLAY)) {
    	 
    	 if (whoClick.hasPermission("mcc.gold")) {
         getConfig().addDefault("color." + whoClick.getName(), "gold");
         getConfig().set("color." + whoClick.getName(), "gold");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §6§n§lgold§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §6§n§lgold§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.GREEN.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.darkgreen")) {
         getConfig().addDefault("color." + whoClick.getName(), "darkGreen");
         getConfig().set("color." + whoClick.getName(), "darkGreen");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §2§n§ldark green§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §2§n§ldark green§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.LIGHT_BLUE.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.lightblue")) {
         getConfig().addDefault("color." + whoClick.getName(), "lightBlue");
         getConfig().set("color." + whoClick.getName(), "lightBlue");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §b§n§llight blue§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §b§n§llight blue§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.CYAN.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.cyan")) {
         getConfig().addDefault("color." + whoClick.getName(), "cyan");
         getConfig().set("color." + whoClick.getName(), "cyan");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §3§n§lcyan§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §3§n§lcyan§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.BLUE.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.darkblue")) {
         getConfig().addDefault("color." + whoClick.getName(), "darkBlue");
         getConfig().set("color." + whoClick.getName(), "darkBlue");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §1§n§ldark blue§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §1§n§ldark blue§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getType().equals(Material.IRON_BLOCK)) {
    	 
    	 if (whoClick.hasPermission("mcc.underline")) {
         if (getConfig().getBoolean("underlineEnable." + whoClick.getName()) != true) {
    		 getConfig().addDefault("underline." + whoClick.getName(), "§n");
         getConfig().set("underline." + whoClick.getName(), "§n");
         getConfig().addDefault("underlineEnable." + whoClick.getName(), true);
         getConfig().set("underlineEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lEnabled §8§n§lunderline§c§l format");
    	 } else {
    		 whoClick.sendMessage("§c§lDisabled §8§n§lunderline§c§l format");
    		 getConfig().addDefault("underlineEnable." + whoClick.getName(), false);
             getConfig().set("underlineEnable." + whoClick.getName(), false);
             saveConfig();
    	 }
     } else {
    	 whoClick.sendMessage("§c§lYou don't have access to §8§n§lunderline§c§l format");
     }
     } else if(event.getCurrentItem().getType().equals(Material.GOLD_BLOCK)) {
    	 
    	 if (whoClick.hasPermission("mcc.italic")) {
         if (getConfig().getBoolean("italicEnable." + whoClick.getName()) != true) {
    		 getConfig().addDefault("italic." + whoClick.getName(), "§o");
         getConfig().set("italic." + whoClick.getName(), "§o");
         getConfig().addDefault("italicEnable." + whoClick.getName(), true);
         getConfig().set("italicEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lEnabled §8§n§litalic§c§l format");
    	 } else {
    		 whoClick.sendMessage("§c§lDisabled §8§n§litalic§c§l format");
    		 getConfig().addDefault("italicEnable." + whoClick.getName(), false);
             getConfig().set("italicEnable." + whoClick.getName(), false);
             saveConfig();
    	 }
     } else {
    	 whoClick.sendMessage("§c§lYou don't have access to §8§n§litalic§c§l format");
     }
     } else if(event.getCurrentItem().getType().equals(Material.DIAMOND_BLOCK)) {
    	 
    	 if (whoClick.hasPermission("mcc.strike")) {
         if (getConfig().getBoolean("strikeEnable." + whoClick.getName()) != true) {
    		 getConfig().addDefault("strike." + whoClick.getName(), "§m");
         getConfig().set("strike." + whoClick.getName(), "§m");
         getConfig().addDefault("strikeEnable." + whoClick.getName(), true);
         getConfig().set("strikeEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lEnabled §8§n§lstrike§c§l format");
    	 } else {
    		 whoClick.sendMessage("§c§lDisabled §8§n§lstrike§c§l format");
    		 getConfig().addDefault("strikeEnable." + whoClick.getName(), false);
             getConfig().set("strikeEnable." + whoClick.getName(), false);
             saveConfig();
    	 }
     } else {
    	 whoClick.sendMessage("§c§lYou don't have access to §8§n§lstrike§c§l format");
     }
     } else if(event.getCurrentItem().getDurability() == (short) 3 && event.getCurrentItem().getType().equals(Material.STAINED_CLAY)) {
    	 
    	 if (whoClick.hasPermission("mcc.blue")) {
         getConfig().addDefault("color." + whoClick.getName(), "blue");
         getConfig().set("color." + whoClick.getName(), "blue");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §9§n§lblue§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §9§n§lblue§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
    	 
    	 if (whoClick.hasPermission("mcc.bold")) {
         if (getConfig().getBoolean("boldEnable." + whoClick.getName()) != true) {
    		 getConfig().addDefault("bold." + whoClick.getName(), "§l");
         getConfig().set("bold." + whoClick.getName(), "§l");
         getConfig().addDefault("boldEnable." + whoClick.getName(), true);
         getConfig().set("boldEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lEnabled §8§n§lbold§c§l format");
    	 } else {
    		 whoClick.sendMessage("§c§lDisabled §8§n§lbold§c§l format");
    		 getConfig().addDefault("boldEnable." + whoClick.getName(), false);
             getConfig().set("boldEnable." + whoClick.getName(), false);
             saveConfig();
    	 }
     } else {
    	 whoClick.sendMessage("§c§lYou don't have access to §8§n§lbold§c§l format");
     }
     } else if(event.getCurrentItem().getDurability() == DyeColor.YELLOW.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.yellow")) {
         getConfig().addDefault("color." + whoClick.getName(), "yellow");
         getConfig().set("color." + whoClick.getName(), "yellow");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §e§n§lyellow§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §e§n§lyellow§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.PINK.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.pink")) {
         getConfig().addDefault("color." + whoClick.getName(), "pink");
         getConfig().set("color." + whoClick.getName(), "pink");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §d§n§lpink§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §d§n§lpink§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.PURPLE.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.purple")) {
         getConfig().addDefault("color." + whoClick.getName(), "purple");
         getConfig().set("color." + whoClick.getName(), "purple");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §5§n§lpurple§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §5§n§lpurple§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.WHITE.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.white")) {
         getConfig().addDefault("color." + whoClick.getName(), "white");
         getConfig().set("color." + whoClick.getName(), "white");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §f§n§lwhite§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §f§n§lwhite§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.SILVER.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.lightgray")) {
         getConfig().addDefault("color." + whoClick.getName(), "lightGray");
         getConfig().set("color." + whoClick.getName(), "lightGray");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §7§n§llight gray§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §7§n§llight gray§c§l chat color");
    	 }
     } else if(event.getCurrentItem().getDurability() == DyeColor.GRAY.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.darkgray")) {
         getConfig().addDefault("color." + whoClick.getName(), "darkGray");
         getConfig().set("color." + whoClick.getName(), "darkGray");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §8§n§ldark gray§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §8§n§ldark gray§c§l chat color");
    	 }
      }else if(event.getCurrentItem().getDurability() == DyeColor.BLACK.ordinal() && event.getCurrentItem().getType().equals(Material.WOOL)) {
    	 
    	 if (whoClick.hasPermission("mcc.black")) {
         getConfig().addDefault("color." + whoClick.getName(), "black");
         getConfig().set("color." + whoClick.getName(), "black");
         getConfig().addDefault("colorEnable." + whoClick.getName(), true);
         getConfig().set("colorEnable." + whoClick.getName(), true);
         saveConfig();
         whoClick.sendMessage("§c§lChanged to §0§n§lblack§c§l chat color");
    	 } else {
    		 whoClick.sendMessage("§c§lYou don't have access to §0§n§lblack§c§l chat color");
    	 }
     }  else {}
    	whoClick.closeInventory();
    }
    }
    
    	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    		Player player = (Player) sender;
    		
    		String currentColor = getConfig().getString("color." + player.getName());
    		if (currentColor == null) {
    			currentColor = "";
    		}
    		
    		if (cmd.getName().equalsIgnoreCase("color") && sender instanceof Player) {
    			player.sendMessage("§6§lOpening chat color selection");
        		
        		Inventory chatColors = Bukkit.createInventory(null, 9*4, "§c§lChat Colors");
                
                ItemStack darkRedColor = new ItemStack(Material.REDSTONE_BLOCK);
                ItemMeta im = darkRedColor.getItemMeta();
                im.setDisplayName("§4§lDark Red");
                if (player.hasPermission("mcc.darkred")) {
                im.setLore(Arrays.asList("§8Access: §aYes"));
                } else if (!player.hasPermission("mcc.darkred")) {
                    im.setLore(Arrays.asList("§8Access: §cNo"));
                } if (currentColor.equals("darkRed")) {
                	if (getConfig().getBoolean("colorEnable." + player.getName())) {
                		im.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                    im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                	} else {}
                	} else {} darkRedColor.setItemMeta(im);
                
                
                Wool redWool = new Wool(DyeColor.RED);
                ItemStack lightRedColor = redWool.toItemStack(1);
                ItemMeta im1 = lightRedColor.getItemMeta();
                im1.setDisplayName("§c§lLight Red");
                if (player.hasPermission("mcc.lightred")) {
                    im1.setLore(Arrays.asList("§8Access: §aYes"));
                    } else if (!player.hasPermission("mcc.lightred")) {
                        im1.setLore(Arrays.asList("§8Access: §cNo"));
                    } if (getConfig().getBoolean("colorEnable." + player.getName())) { 
                    	if (currentColor.equals("lightRed")) {
                    	im1.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                        im1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    } else {}
                	} else {} lightRedColor.setItemMeta(im1);
                
                ItemStack goldColor = new ItemStack(Material.STAINED_CLAY);
                goldColor.setDurability((short) 4);
                ItemMeta im4 = goldColor.getItemMeta();
                im4.setDisplayName("§6§lGold");
                if (player.hasPermission("mcc.gold")) {
                im4.setLore(Arrays.asList("§8Access: §aYes"));
                } else if (!player.hasPermission("mcc.gold")) {
                    im4.setLore(Arrays.asList("§8Access: §cNo"));
                } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                	if (currentColor.equals("gold")) {
                	im4.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                    im4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                } else {}
            	} else {} goldColor.setItemMeta(im4);
                
                Wool limeWool = new Wool(DyeColor.LIME);
                ItemStack lightGreenColor = limeWool.toItemStack(1);
                ItemMeta im2 = lightGreenColor.getItemMeta();
                im2.setDisplayName("§a§lLight Green");
                if (player.hasPermission("mcc.lightgreen")) {
                    im2.setLore(Arrays.asList("§8Access: §aYes"));
                    } else if (!player.hasPermission("mcc.lightgreen")) {
                        im2.setLore(Arrays.asList("§8Access: §cNo"));
                    } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                    	if (currentColor.equals("lightGreen")) {
                    	im2.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                        im2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    } else {}
                	} else {} lightGreenColor.setItemMeta(im2);
                    
                    Wool greenWool = new Wool(DyeColor.GREEN);
                    ItemStack darkGreenColor = greenWool.toItemStack(1);
                    ItemMeta im5 = darkGreenColor.getItemMeta();
                    im5.setDisplayName("§2§lDark Green");
                    if (player.hasPermission("mcc.darkgreen")) {
                        im5.setLore(Arrays.asList("§8Access: §aYes"));
                        } else if (!player.hasPermission("mcc.darkgreen")) {
                            im5.setLore(Arrays.asList("§8Access: §cNo"));
                        } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                        	if (currentColor.equals("darkGreen")) {
                        	im5.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                            im5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        } else {}
                    	} else {} darkGreenColor.setItemMeta(im5);
                        
                        Wool lightBlueWool = new Wool(DyeColor.LIGHT_BLUE);
                        ItemStack lightBlueColor = lightBlueWool.toItemStack(1);
                        ItemMeta im6 = darkGreenColor.getItemMeta();
                        im6.setDisplayName("§b§lLight Blue");
                        if (player.hasPermission("mcc.lightblue")) {
                            im6.setLore(Arrays.asList("§8Access: §aYes"));
                            } else if (!player.hasPermission("mcc.lightblue")) {
                                im6.setLore(Arrays.asList("§8Access: §cNo"));
                            } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                            	if (currentColor.equals("lightBlue")) {
                            	im6.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                im6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            } else {}
                        	} else {} lightBlueColor.setItemMeta(im6);
                            
                            Wool cyanWool = new Wool(DyeColor.CYAN);
                            ItemStack cyanColor = cyanWool.toItemStack(1);
                            ItemMeta im7 = cyanColor.getItemMeta();
                            im7.setDisplayName("§3§lCyan");
                            if (player.hasPermission("mcc.cyan")) {
                                im7.setLore(Arrays.asList("§8Access: §aYes"));
                                } else if (!player.hasPermission("mcc.cyan")) {
                                    im7.setLore(Arrays.asList("§8Access: §cNo"));
                                } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                	if (currentColor.equals("cyan")) {
                                	im7.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                    im7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                } else {}
                            	} else {} cyanColor.setItemMeta(im7);
                                
                                Wool darkBlueWool = new Wool(DyeColor.BLUE);
                                ItemStack darkBlueColor = darkBlueWool.toItemStack(1);
                                ItemMeta im8 = darkBlueColor.getItemMeta();
                                im8.setDisplayName("§1§lDark Blue");
                                if (player.hasPermission("mcc.darkblue")) {
                                    im8.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.darkblue")) {
                                        im8.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                    	if (currentColor.equals("darkBlue")) {
                                    	im8.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                        im8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                    } else {}
                                	} else {} darkBlueColor.setItemMeta(im8);
                                    
                                    ItemStack underline = new ItemStack(Material.IRON_BLOCK);
                                    ItemMeta im9 = goldColor.getItemMeta();
                                    im9.setDisplayName("§8§lUnderline");
                                    if (player.hasPermission("mcc.underline")) {
                                    im9.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.underline")) {
                                        im9.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("underlineEnable." + player.getName()) == true) {
                                    im9.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                    im9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                    } underline.setItemMeta(im9);
                                    
                                    
                                    ItemStack italic = new ItemStack(Material.GOLD_BLOCK);
                                    ItemMeta im10 = italic.getItemMeta();
                                    im10.setDisplayName("§8§lItalic");
                                    if (player.hasPermission("mcc.italic")) {
                                    im10.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.italic")) {
                                        im10.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("italicEnable." + player.getName()) == true) {
                                        im10.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                        im10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                        }
                                    italic.setItemMeta(im10);
                                    
                                    ItemStack strike = new ItemStack(Material.DIAMOND_BLOCK);
                                    ItemMeta im11 = strike.getItemMeta();
                                    im11.setDisplayName("§8§lStrike");
                                    if (player.hasPermission("mcc.strike")) {
                                    im11.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.strike")) {
                                        im11.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("strikeEnable." + player.getName()) == true) {
                                        im11.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                        im11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                        }
                                    strike.setItemMeta(im11);
                                    
                                    ItemStack blueColor = new ItemStack(Material.STAINED_CLAY);
                                    blueColor.setDurability((short) 3);
                                    ItemMeta im12 = blueColor.getItemMeta();
                                    im12.setDisplayName("§9§lBlue");
                                    if (player.hasPermission("mcc.blue")) {
                                    im12.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.blue")) {
                                        im12.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                    	if (currentColor.equals("blue")) {
                                    	im12.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                        im12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                    } else {}
                                	} else {} blueColor.setItemMeta(im12);
                                    
                                    ItemStack bold = new ItemStack(Material.EMERALD_BLOCK);
                                    ItemMeta im13 = bold.getItemMeta();
                                    im13.setDisplayName("§8§lBold");
                                    if (player.hasPermission("mcc.bold")) {
                                    im13.setLore(Arrays.asList("§8Access: §aYes"));
                                    } else if (!player.hasPermission("mcc.bold")) {
                                        im13.setLore(Arrays.asList("§8Access: §cNo"));
                                    } if (getConfig().getBoolean("boldEnable." + player.getName()) == true) {
                                        im13.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                        im13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                        }
                                    bold.setItemMeta(im13);
                                    
                                    Wool yellowWool = new Wool(DyeColor.YELLOW);
                                    ItemStack yellowColor = yellowWool.toItemStack(1);
                                    ItemMeta im14 = yellowColor.getItemMeta();
                                    im14.setDisplayName("§e§lYellow");
                                    if (player.hasPermission("mcc.yellow")) {
                                        im14.setLore(Arrays.asList("§8Access: §aYes"));
                                        } else if (!player.hasPermission("mcc.yellow")) {
                                            im14.setLore(Arrays.asList("§8Access: §cNo"));
                                        } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                        	if (currentColor.equals("yellow")) {
                                        	im14.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                            im14.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                        } else {}
                                    	} else {} yellowColor.setItemMeta(im14);
                                        
                                        Wool pinkWool = new Wool(DyeColor.PINK);
                                        ItemStack pinkColor = pinkWool.toItemStack(1);
                                        ItemMeta im15 = pinkColor.getItemMeta();
                                        im15.setDisplayName("§d§lPink");
                                        if (player.hasPermission("mcc.pink")) {
                                            im15.setLore(Arrays.asList("§8Access: §aYes"));
                                            } else if (!player.hasPermission("mcc.pink")) {
                                                im15.setLore(Arrays.asList("§8Access: §cNo"));
                                            } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                            	if (currentColor.equals("pink")) {
                                            	im15.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                im15.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                            } else {}
                                        	} else {} pinkColor.setItemMeta(im15);
                                            
                                            Wool purpleWool = new Wool(DyeColor.PURPLE);
                                            ItemStack purpleColor = purpleWool.toItemStack(1);
                                            ItemMeta im16 = purpleColor.getItemMeta();
                                            im16.setDisplayName("§5§lPurple");
                                            if (player.hasPermission("mcc.purple")) {
                                                im16.setLore(Arrays.asList("§8Access: §aYes"));
                                                } else if (!player.hasPermission("mcc.pink")) {
                                                    im16.setLore(Arrays.asList("§8Access: §cNo"));
                                                } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                                	if (currentColor.equals("purple")) {
                                                	im16.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                    im16.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                } else {}
                                            	} else {} purpleColor.setItemMeta(im16);
                                                
                                                Wool whiteWool = new Wool(DyeColor.WHITE);
                                                ItemStack whiteColor = whiteWool.toItemStack(1);
                                                ItemMeta im17 = whiteColor.getItemMeta();
                                                im17.setDisplayName("§f§lWhite");
                                                if (player.hasPermission("mcc.white")) {
                                                    im17.setLore(Arrays.asList("§8Access: §aYes"));
                                                    } else if (!player.hasPermission("mcc.white")) {
                                                        im17.setLore(Arrays.asList("§8Access: §cNo"));
                                                    } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                                    	if (currentColor.equals("white")) {
                                                    	im17.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                        im17.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                    } else {}
                                                	} else {} whiteColor.setItemMeta(im17);
                                                    
                                                    Wool lightGrayWool = new Wool(DyeColor.SILVER);
                                                    ItemStack lightGrayColor = lightGrayWool.toItemStack(1);
                                                    ItemMeta im18 = lightGrayColor.getItemMeta();
                                                    im18.setDisplayName("§7§lLight Gray");
                                                    if (player.hasPermission("mcc.lightgray")) {
                                                        im18.setLore(Arrays.asList("§8Access: §aYes"));
                                                        } else if (!player.hasPermission("mcc.lightgray")) {
                                                            im18.setLore(Arrays.asList("§8Access: §cNo"));
                                                        } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                                        	if (currentColor.equals("lightGray")) {
                                                        	im18.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                            im18.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                        } else {}
                                                    	} else {} lightGrayColor.setItemMeta(im18);
                                                        
                                                        Wool darkGrayWool = new Wool(DyeColor.GRAY);
                                                        ItemStack darkGrayColor = darkGrayWool.toItemStack(1);
                                                        ItemMeta im19 = darkGrayColor.getItemMeta();
                                                        im19.setDisplayName("§8§lDark Gray");
                                                        if (player.hasPermission("mcc.darkgray")) {
                                                            im19.setLore(Arrays.asList("§8Access: §aYes"));
                                                            } else if (!player.hasPermission("mcc.darkgray")) {
                                                                im19.setLore(Arrays.asList("§8Access: §cNo"));
                                                            } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                                            	if (currentColor.equals("darkGray")) {
                                                            	im19.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                                im19.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                            } else {}
                                                        	} else {} darkGrayColor.setItemMeta(im19);
                                                            
                                                            Wool blackWool = new Wool(DyeColor.BLACK);
                                                            ItemStack blackColor = blackWool.toItemStack(1);
                                                            ItemMeta im20 = blackColor.getItemMeta();
                                                            im20.setDisplayName("§0§lBlack");
                                                            if (player.hasPermission("mcc.black")) {
                                                                im20.setLore(Arrays.asList("§8Access: §aYes"));
                                                                } else if (!player.hasPermission("mcc.black")) {
                                                                    im20.setLore(Arrays.asList("§8Access: §cNo"));
                                                                } if (getConfig().getBoolean("colorEnable." + player.getName())) {
                                                                	if (currentColor.equals("black")) {
                                                                	im20.addEnchant(Enchantment.FIRE_ASPECT, 1, true); 
                                                                    im20.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                                } else {}
                                                            	} else {} blackColor.setItemMeta(im20);
                
                ItemStack resetColor = new ItemStack(Material.BARRIER);
                ItemMeta im3 = resetColor.getItemMeta();
                im3.setDisplayName("§lReset Chat Color");
                resetColor.setItemMeta(im3);
        		
                chatColors.setItem(1, new ItemStack(darkRedColor));
                chatColors.setItem(2, new ItemStack(lightRedColor));
            	chatColors.setItem(3, new ItemStack(goldColor));
            	chatColors.setItem(4, new ItemStack(yellowColor));
            	chatColors.setItem(6, new ItemStack(underline));
            	chatColors.setItem(10, new ItemStack(darkGreenColor));
            	chatColors.setItem(11, new ItemStack(lightGreenColor));
            	chatColors.setItem(12, new ItemStack(lightBlueColor));
            	chatColors.setItem(15, new ItemStack(italic));
            	chatColors.setItem(13, new ItemStack(cyanColor));
            	chatColors.setItem(19, new ItemStack(darkBlueColor));
            	chatColors.setItem(20, new ItemStack(blueColor));
            	chatColors.setItem(21, new ItemStack(pinkColor));
            	chatColors.setItem(22, new ItemStack(purpleColor));
            	chatColors.setItem(24, new ItemStack(strike));
            	chatColors.setItem(28, new ItemStack(whiteColor));
            	chatColors.setItem(29, new ItemStack(lightGrayColor));
            	chatColors.setItem(30, new ItemStack(darkGrayColor));
            	chatColors.setItem(31, new ItemStack(blackColor));
            	chatColors.setItem(33, new ItemStack(bold));
            	
            	chatColors.setItem(0, new ItemStack(resetColor));
            	chatColors.setItem(8, new ItemStack(resetColor));
            	chatColors.setItem(9, new ItemStack(resetColor));
            	chatColors.setItem(17, new ItemStack(resetColor));
            	chatColors.setItem(18, new ItemStack(resetColor));
            	chatColors.setItem(26, new ItemStack(resetColor));
            	chatColors.setItem(27, new ItemStack(resetColor));
            	chatColors.setItem(35, new ItemStack(resetColor));
            	player.openInventory(chatColors);
    	} if (cmd.getName().equalsIgnoreCase("chatcolor") && sender instanceof Player) {
    		if (player.hasPermission("mcc.admin")) {
    			if (args.length == 2) { 
    			String t1 = args[0];
        		String value = args[1];
    			 getConfig().addDefault("color." + t1, value);
    	         getConfig().set("color." + t1, value);
    	         saveConfig();
    	         sender.sendMessage("§c§l" + t1 + "'s chat color changed to " + value);
    		} else {
    			sender.sendMessage("§c§lUsage: /chatcolor (player) (value)");
    		} } else {
    				sender.sendMessage("§c§lYou do not have access to this commmand");
    		}
    	}
    return true;
    }
}
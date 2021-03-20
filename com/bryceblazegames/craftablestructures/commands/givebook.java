package com.bryceblazegames.craftablestructures.commands;

import com.bryceblazegames.craftablestructures.items.itemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class givebook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("The console cannot run that command.");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("givebook")) {

            player.getInventory().addItem(itemManager.recipeBook);

        }

        return true;
    }
}

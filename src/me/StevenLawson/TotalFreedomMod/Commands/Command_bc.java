package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;

import me.confuser.barapi.BarAPI;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(
        description = "Make an announcement", 
        usage = "/<command> <message> ")
        public class Command_bc extends TFM_Command
{
@Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
        {

                String message = "";
                for (int i = 1; i < args.length; i++)
                {
                    if (i > 1)
                    {
                        message += " ";
                    }
                    message += args[i];
                }
                for (Player player : server.getOnlinePlayers()) 
                {
                    BarAPI.setMessage(message.replaceAll("&", "§"), 60); 
                }
                TFM_Util.bcastMsg(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Broadcast" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + message);
                return false;
            }
}


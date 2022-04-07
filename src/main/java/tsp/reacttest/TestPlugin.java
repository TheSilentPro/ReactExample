package tsp.reacttest;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.react.React;
import tsp.react.reactable.Reactable;

public class TestPlugin extends JavaPlugin implements CommandExecutor {

    private static TestPlugin instance;
    private React react;

    @Override
    public void onEnable() {
        instance = this;
        react = new React(this);
        Reacts.CUSTOM_ITEM.register(react);
        Reacts.INFINITE_CAKE.register(react);
        Reacts.POOF_BLOCK.register(react);
        Reacts.UNBREAKABLE_BLOCK.register(react);

        getCommand("testreact").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("testreact")) {
            Player player = (Player) sender;

            player.getInventory().addItem(fromItemStack(new ItemStack(Material.STICK), Reacts.CUSTOM_ITEM));
            player.getInventory().addItem(fromItemStack(new ItemStack(Material.CAKE), Reacts.INFINITE_CAKE));
            player.getInventory().addItem(fromItemStack(new ItemStack(Material.DIAMOND_BLOCK), Reacts.POOF_BLOCK));
            player.getInventory().addItem(fromItemStack(new ItemStack(Material.DIRT), Reacts.UNBREAKABLE_BLOCK));
        }
        return true;
    }

    private ItemStack fromItemStack(ItemStack item, Reactable reactable) {
        ItemMeta meta = item.getItemMeta();
        react.mark(meta, reactable);
        item.setItemMeta(meta);
        return item;
    }

    public React getReact() {
        return react;
    }

    public static TestPlugin getInstance() {
        return instance;
    }

}

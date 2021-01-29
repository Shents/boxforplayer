package os.protect.create;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.ChatColor;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class main extends JavaPlugin
{
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents((Listener)new create(), (Plugin)this);
        this.craft();
    }
    
    public void onDisable() {
    }
    
    private void craft() {
        final ItemStack item1 = new ItemStack(Material.STAINED_GLASS);
        final ItemMeta meta = item1.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Protecter");
        final List<String> lore = new ArrayList<String>();
        lore.add("Click");
        meta.setLore((List)lore);
        item1.setItemMeta(meta);
        final ShapedRecipe c = new ShapedRecipe(item1);
        c.shape(new String[] { "A A", " B ", "A A" });
        c.setIngredient('A', Material.GOLD_INGOT);
        c.setIngredient('B', Material.WOOL);
        Bukkit.getServer().addRecipe((Recipe)c);
    }
}

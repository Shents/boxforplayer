package os.protect.create;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.block.*;
import org.bukkit.event.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class create implements Listener
{
    @EventHandler
    public void use(final PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (e.getPlayer().getItemInHand().getType() != Material.STAINED_GLASS) {
            return;
        }
        final Player p = e.getPlayer();
        final ItemStack item = e.getPlayer().getItemInHand();
        if (!item.getItemMeta().hasDisplayName()) {
            return;
        }
        if (!item.getItemMeta().hasLore()) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Protecter")) {
            return;
        }
        if (!item.getItemMeta().getLore().get(0).equals("Click")) {
            return;
        }
        final Location loc = e.getPlayer().getLocation();
        final World w = loc.getWorld();
        loc.setY(loc.getY() - 2.0);
        final Block b = w.getBlockAt(loc);
        if (b.getType() == Material.AIR) {
            b.setType(Material.WOOL);
        }
        loc.setY(loc.getY() + 1.0);
        loc.setX(loc.getX() + 1.0);
        this.addBlock(b, w, loc);
        loc.setY(loc.getY() + 1.0);
        this.addBlock(b, w, loc);
        loc.setX(loc.getX() - 2.0);
        this.addBlock(b, w, loc);
        loc.setY(loc.getY() - 1.0);
        this.addBlock(b, w, loc);
        loc.setX(loc.getX() + 1.0);
        loc.setZ(loc.getZ() + 1.0);
        this.addBlock(b, w, loc);
        loc.setY(loc.getY() + 1.0);
        this.addBlock(b, w, loc);
        loc.setZ(loc.getZ() - 2.0);
        this.addBlock(b, w, loc);
        loc.setY(loc.getY() - 1.0);
        this.addBlock(b, w, loc);
        loc.setZ(loc.getZ() + 1.0);
        loc.setY(loc.getY() + 2.0);
        this.addBlock(b, w, loc);
        loc.setY(loc.getY() - 2.0);
        p.teleport(loc);
        this.removeItem(p);
    }
    
    private void addBlock(Block b, final World w, final Location loc) {
        b = w.getBlockAt(loc);
        if (b.getType() == Material.AIR) {
            b.setType(Material.WOOL);
        }
    }
    
    private void removeItem(final Player p) {
        final ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Protecter_reloading");
        final List<String> lore = new ArrayList<String>();
        lore.add("Wait_plise");
        meta.setLore((List)lore);
        item.setItemMeta(meta);
        p.setItemInHand(item);
    }
}

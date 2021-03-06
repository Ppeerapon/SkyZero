package ppeerapon.mc.skyzero.Utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import ppeerapon.mc.skyzero.SkyZero;

public class Recipe {

    SkyZero skyZero;

    public Recipe(SkyZero skyZero) {
        this.skyZero = skyZero;
    }

    public void loadRecipe() {
        ItemStack elytra = new ItemStack(Material.ELYTRA);
        NamespacedKey key = new NamespacedKey(skyZero, "elytra");
        ShapedRecipe recipe = new ShapedRecipe(key, elytra);
        recipe.shape("^^^", "%^%", "%$%");
        recipe.setIngredient('^', Material.PHANTOM_MEMBRANE);
        recipe.setIngredient('%', Material.LEATHER);
        recipe.setIngredient('$', Material.NETHER_STAR);
        skyZero.getServer().addRecipe(recipe);
    }

}

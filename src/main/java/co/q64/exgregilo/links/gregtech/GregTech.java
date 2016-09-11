package co.q64.exgregilo.links.gregtech;

import exnihilo.ENBlocks;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import co.q64.exgregilo.api.links.LinkBase;
import co.q64.exgregilo.api.links.ModLink;
import co.q64.exgregilo.data.ModData;

@ModLink(modName = "GregTech", modId = ModData.GREGTECH_ID)
public class GregTech implements LinkBase {
	private Map<Block, Map<ItemStack, Integer>> sifting = new HashMap<Block, Map<ItemStack, Integer>>();

	@Override
	public void loadLink() {
		//addCrushed(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Naquadah, 1), 1);
		// Coal
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Lignite, 1), 10);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Coal, 1), 10);
		// Iron
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Magnetite, 1), 6);
		// Tin
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Cassiterite, 1), 33);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Tin, 1), 33);
		// Copper
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Chalcopyrite, 1), 10);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Tetrahedrite, 1), 20);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Copper, 1), 20);
		// Bauxite
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Bauxite, 1), 33);
		// Gold
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Gold, 1), 50);
		// Lead
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Lead, 1), 50);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Wulfenite, 1), 12);
		// Silver
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Galena, 1), 15);
		addGravel(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Silver, 1), 50);

		// Salt
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.RockSalt, 1), 12);
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Salt, 1), 12);
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Lepidolite, 1), 25);

		// Soapstone?
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Soapstone, 1), 50);
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Talc, 1), 50);
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Glauconite, 1), 50);

		// Nickel
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Garnierite, 1), 12);
		addSand(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Nickel, 1), 50);

		// Iridium/Osmium
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iridium, 1), 500);
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Osmiridium, 1), 500);
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Platinum, 1), 500);
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Chrome, 1), 500);
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Osmium, 1), 100);

		// Vanadium Magnetite
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.VanadiumMagnetite, 1), 100);

		// Stibnite
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Stibnite, 1), 100);

		// Ilmenite
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ilmenite, 1), 100);

		// Spodumene
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Spodumene, 1), 100);

		// Cinnabar
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Cinnabar, 1), 100);

		// Lithium
		addDust(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lithium, 1), 100);
	}

	@Override
	public void enableLink() {

	}

	private Map<ItemStack, Integer> getSubMap(Block block) {
		Map<ItemStack, Integer> map = sifting.get(block);
		if (map == null) {
			map = new HashMap<ItemStack, Integer>();
			sifting.put(block, map);
		}
		return map;
	}

	private void addGravel(ItemStack is, int chance) {
		getSubMap(Blocks.gravel).put(is, chance);
	}

	private void addSand(ItemStack is, int chance) {
		getSubMap(Blocks.sand).put(is, chance);
	}

	private void addDust(ItemStack is, int chance) {
		getSubMap(ENBlocks.Dust).put(is, chance); // TODO This shouldn't go here
	}

	public Map<Block, Map<ItemStack, Integer>> getSiftingMap() {
		return sifting;
	}
}

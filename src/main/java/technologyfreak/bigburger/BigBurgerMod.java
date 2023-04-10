package technologyfreak.bigburger;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import technologyfreak.bigburger.block.BigBurgerBlock;
import technologyfreak.bigburger.item.BigBurgerFoodComponents;
import technologyfreak.bigburger.item.BurgerItem;

public class BigBurgerMod implements ModInitializer {
	public static String NAMESPACE = "big-burger-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

	public static final Item BURGER_ITEM = Registry.register(Registry.ITEM,
			new Identifier(NAMESPACE, "burger_item"),
			new BurgerItem(new FabricItemSettings().food(BigBurgerFoodComponents.BURGER).group(ItemGroup.FOOD)));

	public static final Block BIG_BURGER_BLOCK = new BigBurgerBlock(
			FabricBlockSettings.of(Material.ORGANIC_PRODUCT).hardness(0.5f).resistance(0.5f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Registering Blocks...");
		Registry.register(Registry.BLOCK, new Identifier(NAMESPACE, "big_burger_block"), BIG_BURGER_BLOCK);
		LOGGER.info("Registering Block Items...");
		Registry.register(Registry.ITEM, new Identifier(NAMESPACE, "big_burger_block"),
				new BlockItem(BIG_BURGER_BLOCK, new Item.Settings().group(ItemGroup.FOOD)));
		LOGGER.info("Finished registration...");
	}

	public static class BigBurgerEnglishLangProvider extends FabricLanguageProvider {

		protected BigBurgerEnglishLangProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(BURGER_ITEM, "Burger");
			translationBuilder.add(BIG_BURGER_BLOCK, "BIG Burger");

			try {
				Path existingFilePath = dataGenerator.getModContainer()
						.findPath("assets/big-burger-mod/lang/en_us.existing.json").get();
				translationBuilder.add(existingFilePath);
			} catch (Exception e) {
				throw new RuntimeException("Failed to add existing language file!", e);
			}
		}
	}
}
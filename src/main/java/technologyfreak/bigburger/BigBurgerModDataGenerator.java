package technologyfreak.bigburger;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import technologyfreak.bigburger.BigBurgerMod.BigBurgerEnglishLangProvider;

public class BigBurgerModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(BigBurgerEnglishLangProvider::new);
	}
}

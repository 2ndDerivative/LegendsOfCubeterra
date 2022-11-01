package cubeterra;

import cubeterra.entity.effect.ModStatusEffects;
import cubeterra.item.ModItems;
import cubeterra.structure.ModStructurePieceType;
import cubeterra.structure.ModStructureSets;
import cubeterra.world.gen.structure.ModStructureType;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrypoint implements ModInitializer {
	public static final String modname = "Legends of Cubeterra";
	public static final String modid = "cubeterra";
	public static final Logger MAINLOGGER = LoggerFactory.getLogger(modname);

	@Override
	public void onInitialize() {
		MAINLOGGER.info("Hello Fabric world, I'm " + modname + "!");
		ModItems.initialize();
		ModStatusEffects.initialize();
		ModStructureType.initialize();
		ModStructureSets.initialize();
		ModStructurePieceType.initialize();
	}
	public static Identifier identify(String id){ return new Identifier(modid, id);}
}

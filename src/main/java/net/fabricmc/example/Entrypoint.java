package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entrypoint implements ModInitializer {
	public static final String modname = "Mod Template";
	public static final String modid = "mod_template";
	public static final Logger MAINLOGGER = LoggerFactory.getLogger(modname);

	@Override
	public void onInitialize() {
		MAINLOGGER.info("Hello Fabric world, I'm " + modname + "!");
	}
	public static Identifier identify(String id){ return new Identifier(modid, id);}
}

package mods.eln.sim.process.destruct;

import mods.eln.misc.Coordonate;

public interface IDestructable {
	void destructImpl();
	String describe();
	Coordonate coords();
}

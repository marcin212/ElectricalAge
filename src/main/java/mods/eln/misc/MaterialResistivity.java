package mods.eln.misc;

public enum MaterialResistivity {
	SILVER(1.59e-8),
	COPPER(1.72e-8),
	GOLD(2.44e-8),
	ALUMINIUM(2.82e-8),
	TUNGSTEN(5.60e-8),
	NICKEL(6.99e-8),
	IRON(9.8e-8),
	TIN(10.9e-8),
	PLATINUM(11e-8),
	LEAD(22e-8),
	NICHROME(150e-8),
	COAL(3.5e-5),
	GERMAN(0.46),
	SILICON(640),
	GLASS(10e12),
	RUBBER(10e13),
	SULFUR(10e15),
	BRASS(7.5e-8),
	CASTIRON(4e-6);

	double resistivity;

	MaterialResistivity(double resistivity) {
		this.resistivity = resistivity;
	}

	public double getPerBlock(double diameter) {
		return resistivity / ((diameter / 2) * (diameter / 2) * Math.PI);
	}

	public double getPerDistance(double diameter, double distance) {
		return resistivity * distance / ((diameter / 2) * (diameter / 2) * Math.PI);
	}
}

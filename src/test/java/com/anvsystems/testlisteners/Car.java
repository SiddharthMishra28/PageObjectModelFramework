package com.anvsystems.testlisteners;

public class Car extends CommonVehicleFunctions{
	
	Engine engine;
	String model;
	
	public Car(Engine e) {
		super(e);
		this.engine = e;
	}
	
	public static void main(String[] args) {
		Engine e = new Engine();
		Car santro = new Car(e);
		Truck tataTruck = new Truck(e);
		santro.engine.startEngine();
		santro.startVehicle();
		tataTruck.startVehicle();
	}
}

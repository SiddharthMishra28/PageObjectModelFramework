package com.anvsystems.testlisteners;

public class CommonVehicleFunctions {
	
	Engine e;
	
	public CommonVehicleFunctions(Engine e) {
		this.e = e;
	}
	
	public void startVehicle() {
		System.out.println("Started");
	}
	
	public void stopVehicle() {
		System.out.println("Stopped!");
	}
	
	public void moveVehicle() {
		System.out.println("Vehicle Moving");
	}
}

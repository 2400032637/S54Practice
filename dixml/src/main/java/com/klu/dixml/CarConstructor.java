package com.klu.dixml;

public class CarConstructor {


		private Engine engine;
		CarConstructor(Engine engine) {
			this.engine=engine;
		}
		
		public void drive() {
			engine.start();
			System.out.println("Dependency of CarConstructor..");
		}
}

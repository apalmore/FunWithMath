package com.austinpalmore.fun_with_math.numbers;
public class LatLon {
	public static void init() {
		System.out.println("This program calculates the distence over the curviture of the earth between two points");

		double lat1 = com.austinpalmore.fun_with_math.util.Display.getIntFromUser("Enter The first lattitude cordinit [-180,180]", new com.austinpalmore.fun_with_math.util.Tester() {
			@Override
			public boolean test(int n) {
				return n < -180 || n > 180;
			}	
		});
		double lon1 = com.austinpalmore.fun_with_math.util.Display.getIntFromUser("Enter The first Longitude cordinit [-180,180]", new com.austinpalmore.fun_with_math.util.Tester() {
			@Override
			public boolean test(int n) {
				return n < -180 || n > 180;
			}	
		});
		double lat2 = com.austinpalmore.fun_with_math.util.Display.getIntFromUser("Enter The Second lattitude cordinit [-180,180]", new com.austinpalmore.fun_with_math.util.Tester() {
			@Override
			public boolean test(int n) {
				return n < -180 || n > 180;
			}	
		});
		double lon2 = com.austinpalmore.fun_with_math.util.Display.getIntFromUser("Enter The Second Longitude cordinit [-180,180]", new com.austinpalmore.fun_with_math.util.Tester() {
			@Override
			public boolean test(int n) {
				return n < -180 || n > 180;
			}	
		});
		System.out.println(Point.getDist(new Point(lat1,lon1),new Point(lat2,lon2)) + " Meters"); 	

	}
}

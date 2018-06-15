package com.austinpalmore.fun_with_math.numbers;
import java.util.Scanner;
public class Point {
	private double φ,λ;
	public Point(double lat,double lon) {
		this.φ = lat;
		this.λ = lon;
	}
	public double getLat() {
		return this.φ;
	}
	public double getLon() {
		return this.λ;
	}
	public static double getDist(Point p,Point b) {
		/* formula from https://www.movable-type.co.uk/scripts/latlong.html */
		double R = 6371e3; // metres
		double φ1 = Math.toRadians(p.getLat());
		double φ2 = Math.toRadians(b.getLat());
		double Δφ = Math.toRadians(b.getLat()- p.getLat());
		double Δλ = Math.toRadians(b.getLon() - p.getLon());
		double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ/2) * Math.sin(Δλ/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return R * c / 1000;
	}
	public static double getDistSum(Point p[]) {
		double sum = 0;
		for (int i = 0;i < p.length - 1;i++)
			sum += getDist(p[i],p[i+1]);
		return sum;
	}
}

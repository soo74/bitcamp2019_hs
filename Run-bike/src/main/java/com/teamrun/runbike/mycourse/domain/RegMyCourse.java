package com.teamrun.runbike.mycourse.domain;

public class RegMyCourse {

	private double mc_startPoint_lon;
	private double mc_startPoint_lat;
	private double mc_endPoint_lon;
	private double mc_endPoint_lat;;
	private String mc_descript;
	private String mc_name;
	private double mc_distance;
	private double mc_time;
	
	
	public double getMc_time() {
		return mc_time;
	}
	public void setMc_time(double mc_time) {
		this.mc_time = mc_time;
	}
	
	public double getMc_distance() {
		return mc_distance;
	}
	
	public void setMc_distance(double mc_distance) {
		this.mc_distance = mc_distance;
	}
	
	public double getMc_startPoint_lon() {
		return mc_startPoint_lon;
	}
	public void setMc_startPoint_lon(double mc_startPoint_lon) {
		this.mc_startPoint_lon = mc_startPoint_lon;
	}
	public double getMc_startPoint_lat() {
		return mc_startPoint_lat;
	}
	public void setMc_startPoint_lat(double mc_startPoint_lat) {
		this.mc_startPoint_lat = mc_startPoint_lat;
	}
	public double getMc_endPoint_lon() {
		return mc_endPoint_lon;
	}
	public void setMc_endPoint_lon(double mc_endPoint_lon) {
		this.mc_endPoint_lon = mc_endPoint_lon;
	}
	public double getMc_endPoint_lat() {
		return mc_endPoint_lat;
	}
	public void setMc_endPoint_lat(double mc_endPoint_lat) {
		this.mc_endPoint_lat = mc_endPoint_lat;
	}
	public String getMc_descript() {
		return mc_descript;
	}
	public void setMc_descript(String mc_descript) {
		this.mc_descript = mc_descript;
	}
	public String getMc_name() {
		return mc_name;
	}
	public void setMc_name(String mc_name) {
		this.mc_name = mc_name;
	}
	
	public RegMyCourse(double mc_startPoint_lon, double mc_startPoint_lat, double mc_endPoint_lon, double mc_endPoint_lat, String mc_descript, String mc_name, double mc_distance, double mc_time) {
		this.mc_startPoint_lon = mc_startPoint_lon;
		this.mc_startPoint_lat = mc_startPoint_lat;
		this.mc_endPoint_lon = mc_endPoint_lon;
		this.mc_endPoint_lat = mc_endPoint_lat;
		this.mc_descript = mc_descript;
		this.mc_name = mc_name;
		this.mc_distance = mc_distance;
		this.mc_time = mc_time;
	}
	public RegMyCourse() {
	
	}
	
	@Override
	public String toString() {
		return "RegMyCourse [mc_startPoint_lon=" + mc_startPoint_lon + ", mc_startPoint_lat=" + mc_startPoint_lat
				+ ", mc_endPoint_lon=" + mc_endPoint_lon + ", mc_endPoint_lat=" + mc_endPoint_lat + ", mc_descript="
				+ mc_descript + ", mc_name=" + mc_name + ", mc_distance=" + mc_distance + ", mc_time=" + mc_time + "]";
	}
	
	public MyCourse toMyCourse() {
		
		MyCourse myCourse = new MyCourse();
		
		myCourse.setMc_startPoint_lon(this.mc_startPoint_lon);
		myCourse.setMc_startPoint_lat(this.mc_startPoint_lat);
		myCourse.setMc_endPoint_lon(this.mc_endPoint_lon);
		myCourse.setMc_endPoint_lat(this.mc_endPoint_lat);
		myCourse.setMc_name(this.mc_name);
		myCourse.setMc_descript(this.mc_descript);
		myCourse.setMc_distance(this.mc_distance);
		myCourse.setMc_time(this.mc_time);
		
		return myCourse;
	}
}

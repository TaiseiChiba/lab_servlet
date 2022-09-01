package model;

import java.io.Serializable;

public class Health implements Serializable {
	// 身長
	private double height;
	
	// 体重
	private double weight;
	
	// bmi
	private double bmi;
	
	// 体型
	private String bodyType;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
}

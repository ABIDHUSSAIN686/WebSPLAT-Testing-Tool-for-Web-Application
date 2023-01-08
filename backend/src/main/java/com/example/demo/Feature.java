package com.example.demo;


/****
 * 
 *  Feature class is used to store information
 *  of each feature in feature model
 * 
 * ****/
public class Feature {
	protected String featureName;
	protected String featureType;
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getFeatureType() {
		return featureType;
	}
	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}
	
}

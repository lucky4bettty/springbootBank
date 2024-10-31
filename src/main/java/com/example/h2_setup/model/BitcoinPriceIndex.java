package com.example.h2_setup.model;

import java.util.Map;

public class BitcoinPriceIndex {
	private TimeData time;
    private String disclaimer;
    private String chartName;
    private Map<String, Currency> bpi;
    
	public Map<String, Currency> getBpi() {
		return bpi;
	}
	public void setBpi(Map<String, Currency> bpi) {
		this.bpi = bpi;
	}
	public TimeData getTime() {
		return time;
	}
	public void setTime(TimeData time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
}

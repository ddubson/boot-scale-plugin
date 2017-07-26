package com.dmitriydubson.boot.scale;

public class BootScalePluginExtension {
    private int numberOfInstances = 1;

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }
}

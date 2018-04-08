package com.maxxitsolution.a1networkspte.ModelClass;

import java.io.Serializable;

/**
 * Created by TOSHIBA on 1/30/2018.
 */

public class CloudServer implements Serializable{

    private String model;
    private String cpu;
    private String cores;
    private String freq;
    private String ram;
    private String disk;
    private String network;
    private String ip;
    private String collocation;
    private String price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCollocation() {
        return collocation;
    }

    public void setCollocation(String collocation) {
        this.collocation = collocation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

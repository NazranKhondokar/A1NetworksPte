package com.maxxitsolution.a1networkspte.ModelClass;

import java.io.Serializable;

/**
 * Created by TOSHIBA on 3/6/2018.
 */

public class VOS3000 implements Serializable {

    private String concurrent_calls;
    private String processor;
    private String cores;
    private String memory;
    private String hard_disk;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getConcurrent_calls() {
        return concurrent_calls;
    }

    public void setConcurrent_calls(String concurrent_calls) {
        this.concurrent_calls = concurrent_calls;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHard_disk() {
        return hard_disk;
    }

    public void setHard_disk(String hard_disk) {
        this.hard_disk = hard_disk;
    }
}

package com.mlc.server;

import java.io.Serializable;

/**
 * Created by ahmad on 7/1/16.
 */
public class Message implements Serializable {
    private String text;
    private String sayerName;

    public Message(String text, String sayerName){
        this.text = text;
        this.sayerName = sayerName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSayerName(String sayerName) {
        this.sayerName = sayerName;
    }

    public String getSayerName() {
        return sayerName;
    }
}

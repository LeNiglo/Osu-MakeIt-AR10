package com.lefrantguillaume.ar10;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Guillaume on 25/07/2016.
 */
public class Map {

    private String name;
    private String version;
    private int approachRate;
    private int overallDifficulty;
    private int circleSize;
    private int hpDrainRate;

    public int getApproachRate() {
        return approachRate;
    }

    public void setApproachRate(int approachRate) {
        this.approachRate = approachRate;
    }

    public int getOverallDifficulty() {
        return overallDifficulty;
    }

    public void setOverallDifficulty(int overallDifficulty) {
        this.overallDifficulty = overallDifficulty;
    }

    public int getCircleSize() {
        return circleSize;
    }

    public void setCircleSize(int circleSize) {
        this.circleSize = circleSize;
    }

    public int getHpDrainRate() {
        return hpDrainRate;
    }

    public void setHpDrainRate(int hpDrainRate) {
        this.hpDrainRate = hpDrainRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStringStats() {
        return String.format("CS=%d, AR=%d, OD=%d, HP=%d", this.circleSize, this.approachRate, this.overallDifficulty, this.hpDrainRate);
    }
}

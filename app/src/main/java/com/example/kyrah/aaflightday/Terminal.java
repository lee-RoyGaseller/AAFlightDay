package com.example.kyrah.aaflightday;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terminal {

    Random rand = new Random();
    Integer name = rand.nextInt(16) +1;
    List<Gate> gates = new ArrayList<Gate>();
    List<PointOfInterest> poiList = new ArrayList<PointOfInterest>();

    public String getGatesInfo() {
        return this.gates.toString();
    }

    public String  getPoiInfo() {return  this.poiList.toString(); }

    public void addGates(Gate... gates) {
        for (Gate gate : gates) {
            this.gates.add(gate);
        }
    }

    public void addGates(List<Gate> gates) {
        this.gates = gates;
    }

    public void addPOIs(PointOfInterest... pois) {
        for (PointOfInterest poi : pois) {
            this.poiList.add(poi);
        }
    }

    public void addPOIs(List<PointOfInterest> pois) {
        this.poiList = pois;
    }

    public void generateRandomGates() {
        List<Gate> gates = new ArrayList();
        EnumClasses letters = new EnumClasses();
        int numGates = rand.nextInt(10) +1;
        for (int i = 0; i < numGates; i++) {
            Gate newGate = new Gate(letters.getLetterAtIndex(i));
            newGate.setTerminal(this.name);
            gates.add(newGate);
        }

        this.gates = gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public void generateRandomPOIs() {
        List<PointOfInterest> poiList = new ArrayList();
        EnumClasses POIType = new EnumClasses();
        int numPOI = rand.nextInt(5) +1;
        for (int i = 0; i < numPOI; i++) {
            String type = POIType.randomPOIType();
            String name = POIType.randomPOINameFromType(type);
            PointOfInterest newPOI = new PointOfInterest(name, type);
            newPOI.setWaitTime(rand.nextInt(30) +1);
            poiList.add(newPOI);
        }

        this.poiList = poiList;
    }
}

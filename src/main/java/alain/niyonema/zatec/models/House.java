package alain.niyonema.zatec.models;

import java.util.List;


public class House {

    int id;

    String name;
    String region;
    String coatOfArms;
    String words;
    String currentLord;
    String heir;
    String overlord;
    String founded;
    String founder;
    String diedOut;
    String ancestralWeapons;
    String cadetBranches;

    List<String> titles;
    List<String> seats;
    List<String> swornMembers;


    // setors methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public void setCurrentLord(String currentLord) {
        this.currentLord = currentLord;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    public void setOverlord(String overlord) {
        this.overlord = overlord;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public void setDiedOut(String diedOut) {
        this.diedOut = diedOut;
    }

    public void setAncestralWeapons(String ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    public void setCadetBranches(String cadetBranches) {
        this.cadetBranches = cadetBranches;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public void setSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
    }


    // getters methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public String getWords() {
        return words;
    }

    public String getCurrentLord() {
        return currentLord;
    }

    public String getHeir() {
        return heir;
    }

    public String getOverlord() {
        return overlord;
    }

    public String getFounded() {
        return founded;
    }

    public String getFounder() {
        return founder;
    }

    public String getDiedOut() {
        return diedOut;
    }

    public String getAncestralWeapons() {
        return ancestralWeapons;
    }

    public String getCadetBranches() {
        return cadetBranches;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getSeats() {
        return seats;
    }

    public List<String> getSwornMembers() {
        return swornMembers;
    }

}
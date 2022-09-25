/*
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
*/
package alain.niyonema.zatec.models;

import java.util.List;

/**
 *  A House is a house branch within the Ice And Fire universe
 */
public class House {

    /**
     * The hypermedia ID of this resource
     */
    private int id;


    /**
     * The hypermedia URL of this resource
     */
    private String url;


    /**
     * The name of this house
     */
    private String name;

    /**
     * The region that this house resides in
     */
    private String region;

    /**
     * Text describing the coat of arms of this house
     */
    private String coatOfArms;

    /**
     * The words of this house
     */
    private String words;

    /**
     * The Character resource URL of this house's current lord
     */
    private String currentLord;

    /**
     * The Character resource URL of this house's heir
     */
    private String heir;

    /**
     * The House resource URL that this house answers to
     */
    private String overlord;

    /**
     * The year that this house was founded
     */
    private String founded;

    /**
     * The Character resource URL that founded this house
     */
    private String founder;

    /**
     * The year that this house died out
     */
    private String diedOut;

    /**
     * An array of names of the noteworthy weapons that this house owns
     */

    private List<String> ancestralWeapons;

    /**
     * An array of House resource URLs that was founded from this house
     */
    private List<String> cadetBranches;

    /**
     * The titles that this house holds
     */
    private List<String> titles;

    /**
     * The seats that this house holds
     */
    private List<String> seats;

    /**
     * An array of Character resource URLs that are sworn to this house
     */
    private List<String> swornMembers;


    // setters methods

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    public void setCadetBranches(List<String> cadetBranches) {
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

    public String getUrl() {
        return url;
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

    public List<String> getAncestralWeapons() {
        return ancestralWeapons;
    }

    public List<String> getCadetBranches() {
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
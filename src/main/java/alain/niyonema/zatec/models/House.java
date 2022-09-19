package alain.niyonema.zatec.models;

import java.util.List;


public class House {

    /**
     * The hypermedia ID of this resource
     */
    private int id;


    /**
     *
     */
    private String url;


    /**
     *
     */
    private String name;

    /**
     *
     */
    private String region;

    /**
     *
     */
    private String coatOfArms;

    /**
     *
     */
    private String words;

    /**
     *
     */
    private String currentLord;

    /**
     *
     */
    private String heir;

    /**
     *
     */
    private String overlord;

    /**
     *
     */
    private String founded;

    /**
     *
     */
    private String founder;

    /**
     *
     */
    private String diedOut;

    /**
     *
     */

    private List<String> ancestralWeapons;

    /**
     *
     */
    private List<String> cadetBranches;

    /**
     *
     */
    private List<String> titles;

    /**
     *
     */
    private List<String> seats;

    /**
     *
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
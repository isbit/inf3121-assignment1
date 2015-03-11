package com.example.login;

public class AlarmList {

	private String tagname = "";
    private String alarmtxt = "";
    private String alarmon = "";
    private String alarmoff = "";
    
    /**
     * Setter for tagnavn, setter tagname likt som input.
     * 
     * @param tagname stringen som benyttes til å sette tagnavn
     */
    public void setTagName(String tagname) {
     this.tagname = tagname;
    }
    
    /**
     * Getter for tagnavn.
     * 
     * @return satt tagnavn
     */
    public String getTagName() {
     return tagname;
    }
    
    /**
     * Setter for alarmteksten, setter alarmtxt likt som input.
     * 
     * @param alarmtxt stringen som benyttes til å sette alarmtekst
     */
    public void setAlarmTxt(String alarmtxt) {
     this.alarmtxt = alarmtxt;
    }
    /**
     * 
     * @return satt alarmtekst
     */
    public String getAlarmTxt() {
     return alarmtxt;
    }
    /**
     * Setter for alarmtidspunkt, setter alarmon likt som input.
     * 
     * @param alarmon stringen som benyttes til å sette alarmtispunkt
     */
    public void setAlarmOn(String alarmon) {
     this.alarmon = alarmon;
    }
    /**
     * 
     * @return satt alarmtidspunkt
     */
    public String getAlarmOn() {
     return alarmon;
    }
    /**
     * Setter for alarmens avsluttningstidspunkt, setter alarmoff likt som input.
     * 
     * @param alarmoff stringen som benyttes til å sette alarmens avsluttningstidspunkt
     */
    public void setAlarmOff(String alarmoff) {
     this.alarmoff = alarmoff;
    }
    /**
     * 
     * @return satt avsluttningstidspunkt for alarmen
     */
    public String getAlarmOff() {
     return alarmoff;
    }
}

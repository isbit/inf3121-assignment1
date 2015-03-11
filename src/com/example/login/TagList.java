package com.example.login;

public class TagList {

	private String tagname = "";
    private String value = "";
    private String unit = "";
    private String quality = "";

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
     * Setter for verdien, setter value likt som input.
     * 
     * @param value stringen som benyttes til å sette verdi
     */

    public void setValue(String value) {
     this.value = value;
    }
    
    /**
     * Getter for verdi.
     * 
     * @return satt verdi
     */
    public String getValue() {
     return value;
    }
    
    /**
     * Setter for enheten, setter unit likt som input.
     * 
     * @param unit stringen som benyttes til å sette enhet
     */
    public void setUnit(String unit) {
     this.unit = unit;
    }

    /**
     * Getter for enhet.
     * 
     * @return satt enhet
     */
    public String getUnit() {
     return unit;
    }
    
    /**
     * Setter for kvalitet, setter quality likt som input.
     * 
     * @param quality stringen som benyttes til å sette kvalitet
     */
    public void setQuality(String quality) {
     this.quality = quality;
    }

    /**
     * Getter for kvalitet.
     * 
     * @return satt kvalitet
     */
    public String getQuality() {
     return quality;
    }
}

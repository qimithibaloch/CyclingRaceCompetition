
package main.java.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Manager {
    private CyclistList cylistList;
    private Object cyclistList;

    public Manager() {
        this.cylistList = new CyclistList();
    }

    /**
     
     * @return 
     */
    public CyclistList getCyclistList() {
        return this.cylistList;
    }

    /**
    
     * @param list 
     */
    public void setCyclistList(CyclistList list) {
        this.cylistList = list;
    }

    /**
     
     * @param filename 
     */
    public void loadCyclistsFromFile(String filename) {
        ((Manager) this.cyclistList).loadCyclistsFromFile(filename);
    }

    /**
   
     * @param filename 
     */
    public void produceFinalReport(String filename) {
        ((Manager) this.cyclistList).produceFinalReport(filename);
    }

    /**
     */
    public void displayCyclistShortDetails() {
        this.cylistList.displayCyclistShortDetails();
    }
}



package com.bharath.main;

public class TaxTableTools {
	/** This class searches the 'search' table with a search argument and
		returns the corresponding value in the 'value' table. Variable
		'nEntries' has the number of entries in each table.
     */
	private int[] search =   {   0,  20000, 50000, 100000, Integer.MAX_VALUE };
    private double[] value = { 0.0,   0.10,  0.20,   0.30, 0.40 };
    private int nEntries;

    // *********************************************************************** 
    //adding in overloading constructor
    public TaxTableTools(int[] baseSalary, double[] taxRate) {
    	search = baseSalary;
    	value = taxRate;
    }
    // Default constructor 
    public TaxTableTools () {
    		nEntries  = search.length;  // Set the length of the search table
    } 
    
    public void setTables(int[] search, double[] value) {
    		for(int i = 0;i < search.length; i++) {
    			this.nEntries = search.length;
    			this.search[i] = search[i];
    			this.value[i] = value[i];
    		}
    }
		   
    // Method to get a value from one table based on a range in the other table
    public double getValue(int searchArgument) {
    		double result = 0.0;
    		boolean keepLooking = true;
    		int i = 0;

    		while ((i < nEntries) && keepLooking) {
    			if (searchArgument <= search[i]) {
    				result = value[i];
    				keepLooking = false;
    			}
    			else {
    				++i;
    			}
    		}
    		return result;
    }  
}

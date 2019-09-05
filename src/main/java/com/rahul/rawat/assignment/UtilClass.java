package com.rahul.rawat.assignment;

import java.io.File;
/**
 * @author Rahul Singh Rawat
 *
 */
public class UtilClass { 
	/**
	 * @param directoryToBeDeleted 
	 * @return boolean based on the deleted directory path
	 * 
	 * Deletes a nested directory and files recursively for given path.
	 */
	public boolean deleteDirectory(File directoryToBeDeleted) {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteDirectory(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}
}

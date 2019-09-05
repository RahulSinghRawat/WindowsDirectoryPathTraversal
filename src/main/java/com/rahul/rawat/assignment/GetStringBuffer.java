package com.rahul.rawat.assignment;


/**
 * @author Rahul Singh Rawat
 *
 */
public class GetStringBuffer {

	private static StringBuffer instance;
	
	/**
	 * default constructor
	 */
	private GetStringBuffer(){
		
	}
	
	/**
	 * @return StringBuffer
	 */
	public static StringBuffer getStringBuffer() {
		
		if(instance == null) {
			synchronized (GetStringBuffer.class) {
				if(instance == null) {
					instance = new StringBuffer();
				}
			}
		}
		return instance;
		
	}
}

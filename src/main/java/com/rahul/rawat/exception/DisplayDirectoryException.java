package com.rahul.rawat.exception;


/**
 * @author Rahul Singh Rawat
 *
 */
public class DisplayDirectoryException extends RuntimeException {

    /**
	 * an universal version identifier
	 */
	private static final long serialVersionUID = -3317157117900310990L;

    
    
    /**
     * This variable holds the errorCode for exception.
     */
    private String errorCode;


    /**
     * Constructor with error code parameter.
     * 
     * @param errorCode
     *            errorCode
     */
    public DisplayDirectoryException(final String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    /**
     * Constructor with errorCode, cause parameter.
     * 
     * @param errorCode
     *            errorCode
     * @param cause
     *            cause
     */
    public DisplayDirectoryException(final String errorCode, final Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
    }

    /**
     * Gets the errorCode.
     * 
     * @return the errorCode
     */
    public final String getErrorCode() {
        if (this.errorCode != null && !this.errorCode.isEmpty()) {
            return this.errorCode;
        } else {
            return ApplicationConstants.PATH_DOSE_NOT_EXIST;
        }
    }

 


}

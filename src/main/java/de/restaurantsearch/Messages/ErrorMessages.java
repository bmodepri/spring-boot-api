package de.restaurantsearch.Messages;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Required Field is missing, please reffer to the documentation for required fields"),
    INVALID_ID("The provided id is invalid, check documentation for correct types"),
    RECORD_ALREADY_EXISTS("Records already exists"),
    NO_RECORD_FOUND("Record not found"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    DATABASE_IS_EMPTY("No records found"),
    COULD_NOT_DELETE_RECORD("Could not delete record");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     *
     * @param errorMessage to set the error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

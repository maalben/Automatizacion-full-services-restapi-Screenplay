package co.com.practice.exceptions;

public class AssertionsServices extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String THE_FIELDS_SERVICE_IS_NOT_EXPECTED = "The fields services response is not expected";
    public static final String SCHEMA_SERVICE_IS_NOT_EXPECTED = "Schema service response is not expected";
    public static final String QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED = "Quantity fields services is not expected";
    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response is not expected";
    public static final String THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED = "The fields and values post services response is not expected";

    public AssertionsServices(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsServices(String message) {
        super(message);
    }

}

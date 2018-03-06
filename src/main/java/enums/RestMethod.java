package enums;

public enum RestMethod {
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE");

    private String methodName;

    RestMethod(String name) {
        this.methodName = name;
    }

    public String toString() {
        return this.methodName;
    }
}

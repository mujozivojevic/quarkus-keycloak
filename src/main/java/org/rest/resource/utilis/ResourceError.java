package org.rest.resource.utilis;

public class ResourceError {
    public String code;
    public String description;

    public ResourceError(String code, String description) {
        this.code = code;
        this.description = description;
    }
}

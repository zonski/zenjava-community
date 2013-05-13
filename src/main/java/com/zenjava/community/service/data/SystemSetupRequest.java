package com.zenjava.community.service.data;

public class SystemSetupRequest {

    private String name;
    private String description;
    private String baseUrl;
    private String emailServer;
    private String emailPort;
    private String emailUsername;
    private String emailPassword;

    public SystemSetupRequest() {
    }

    public SystemSetupRequest(String name, String description, String baseUrl,
                              String emailServer, String emailPort, String emailUsername) {
        this.name = name;
        this.description = description;
        this.baseUrl = baseUrl;
        this.emailServer = emailServer;
        this.emailPort = emailPort;
        this.emailUsername = emailUsername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
}

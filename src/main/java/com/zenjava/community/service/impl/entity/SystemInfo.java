package com.zenjava.community.service.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "system_info")
@SequenceGenerator(name = "sequence_generator", sequenceName = "system_info_id_seq")
public class SystemInfo extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "email_server")
    private String emailServer;

    @Column(name = "email_port")
    private String emailPort;

    @Column(name = "email_username")
    private String emailUsername;

    @Column(name = "email_password")
    private String emailPassword;

    public SystemInfo() {
    }

    public SystemInfo(String name, String description, String baseUrl,
                      String emailServer, String emailPort, String emailUsername, String emailPassword) {
        this.name = name;
        this.description = description;
        this.baseUrl = baseUrl;
        this.emailServer = emailServer;
        this.emailPort = emailPort;
        this.emailPassword = emailPassword;
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

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
}

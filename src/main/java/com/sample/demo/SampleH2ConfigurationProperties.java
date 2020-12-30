package com.sample.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceInitializationMode;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sample")
public class SampleH2ConfigurationProperties {

	private String datasourceUrl ;
	private String datasourceDriverClassname;
	private String username;
	private String password;
	private String repoBasepackage;
	private String entityBasepackage;
	private DataSourceInitializationMode initializationMode;
	
	public String getDatasourceUrl() {
		return datasourceUrl;
	}
	public void setDatasourceUrl(String datasourceUrl) {
		this.datasourceUrl = datasourceUrl;
	}
	public String getDatasourceDriverClassname() {
		return datasourceDriverClassname;
	}
	public void setDatasourceDriverClassname(String datasourceDriverClassname) {
		this.datasourceDriverClassname = datasourceDriverClassname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepoBasepackage() {
		return repoBasepackage;
	}
	public void setRepoBasepackage(String repoBasepackage) {
		this.repoBasepackage = repoBasepackage;
	}
	public String getEntityBasepackage() {
		return entityBasepackage;
	}
	public void setEntityBasepackage(String entityBasepackage) {
		this.entityBasepackage = entityBasepackage;
	}
	public DataSourceInitializationMode getInitializationMode() {
		return initializationMode;
	}
	public void setInitializationMode(DataSourceInitializationMode initializationMode) {
		this.initializationMode = initializationMode;
	}
	
}

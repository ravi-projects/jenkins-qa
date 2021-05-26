package org.pk.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    @Value("${server.port}")
    private String serverPort;

    private final AthmaBucket athmaBucket = new AthmaBucket();

    private final Configs configs = new Configs();

    private final List<Menu> menu =  new ArrayList<>();

    public List<Menu> getMenu() {
        return menu;
    }

    public String getServerPort() {
        return serverPort;
    }

    public AthmaBucket getAthmaBucket() {
        return athmaBucket;
    }

    public Configs getConfigs() {
        return configs;
    }

    public static class Menu {

        private String name;
        private String path;
        private String title;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class AthmaBucket {

        private String masterExport;
        private String tempExport;
        private String reportFilePath;
        private String admissionFilePath;
        private String printSaveFile;
        private String inPatientAttachmentsPath;
        private String logoFilePath;

        public String getMasterExport() {
            return masterExport;
        }

        public void setMasterExport(String masterExport) {
            this.masterExport = masterExport;
        }

        public String getTempExport() {
            return tempExport;
        }

        public void setTempExport(String tempExport) {
            this.tempExport = tempExport;
        }

        public String getReportFilePath() {
            return reportFilePath;
        }

        public void setReportFilePath(String reportFilePath) {
            this.reportFilePath = reportFilePath;
        }

        public String getAdmissionFilePath() {
            return admissionFilePath;
        }

        public void setAdmissionFilePath(String admissionFilePath) {
            this.admissionFilePath = admissionFilePath;
        }

        public String getPrintSaveFile() {
            return printSaveFile;
        }

        public void setPrintSaveFile(String printSaveFile) {
            this.printSaveFile = printSaveFile;
        }

        public String getInPatientAttachmentsPath() {
            return inPatientAttachmentsPath;
        }

        public void setInPatientAttachmentsPath(String inPatientAttachmentsPath) {
            this.inPatientAttachmentsPath = inPatientAttachmentsPath;
        }

        public String getLogoFilePath() {
            return logoFilePath;
        }

        public void setLogoFilePath(String logoFilePath) {
            this.logoFilePath = logoFilePath;
        }
    }

    public static class Configs {

        private Integer indexPageSize;
        private Integer exportRowsCount;

        public Integer getIndexPageSize() {
            return indexPageSize;
        }

        public void setIndexPageSize(Integer indexPageSize) {
            this.indexPageSize = indexPageSize;
        }

        public Integer getExportRowsCount() {
            return exportRowsCount;
        }

        public void setExportRowsCount(Integer exportRowsCount) {
            this.exportRowsCount = exportRowsCount;
        }
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "serverPort='" + serverPort + '\'' +
                ", athmaBucket=" + athmaBucket +
                ", configs=" + configs +
                ", menu=" + menu +
                '}';
    }
}

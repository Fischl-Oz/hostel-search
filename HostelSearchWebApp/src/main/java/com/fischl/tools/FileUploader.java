package com.fischl.tools;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileUploader {
    private HttpServletRequest request;
    private Collection<Part> parts;
    private String upload_directory;
    private String append_to_file_name;
    private String file_name;
    public FileUploader(HttpServletRequest request){
        append_to_file_name = "";
        this.request = request;
    }
    public void setUploadDirectory(String upload_directory) {
        this.upload_directory = upload_directory;
    }
    public void appendToFileName(String text) {
        this.append_to_file_name += text;
    }
    public void resetAppendToFileName() {
        this.append_to_file_name = "";
    }
    public void setFileName(String file_name) {
        this.file_name = file_name;
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                clientFileName = clientFileName.substring(i + 1);
                String fileExtension = clientFileName.substring(clientFileName.lastIndexOf("."));
                return append_to_file_name + "_" + this.file_name + fileExtension;
            }
        }
        return null;
    }
    public String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    private String getFullSavePath() {
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        String fullSavePath = null;
        if (appPath.endsWith("/")) {
            fullSavePath = appPath + upload_directory;
        } else {
            fullSavePath = appPath + "/" + upload_directory;
        }
        return fullSavePath;
    }
    public void saveFile() throws IOException {
        String fullSavePath = getFullSavePath();
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        try {
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    String filePath = fullSavePath + File.separator + fileName;
                    System.out.println("Write attachment to file: " + filePath);

                    part.write(filePath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Upload Files: " + e.getMessage());
        }
    }

    public String saveFile(Part part){
        String fullSavePath = getFullSavePath();
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        try {
            String fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = fullSavePath + File.separator + fileName;
                System.out.println("Write attachment to file: " + filePath);
                part.write(filePath);
                return filePath;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Upload Files: " + e.getMessage());
            return null;
        }
        return null;
    }
}

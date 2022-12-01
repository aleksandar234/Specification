package org.raf.specification;

import java.util.Date;
import java.util.List;

public interface Specification {

    void init(); //
    void makeDirs(int numberOfDirectories); //
    void setMaxFileSize(int size); //
    void setBlockedExtensions(List<String> blockedExtensions); //

    void download(String corePath, String newPath); //
    void upload(String pathFrom, String pathTo); //
    void rename(String filePath ,String newName); //
    void createFile(String filePath); //
    void delete(String filePath); //

    void getAllFilesInDir(String pathToDir); //
    void getAllFilesFromAllDirsInDir(String pathToDir); //
    void getFilesWithExtension(String pathToDir, String extension); //
    void getFilesWithSubstring(String pathToDir, String s); //
    boolean getFilesWithName(String pathToDir, String... fileNames); //
    boolean getDirFromNameOfFile(String fileName); //
    void getAllFilesSortedByName(String pathToDir, String order); //
    void getAllFilesSortedByDate(String pathToDir, String order); //
    void getFilesCreatedInCertainTime(String pathToDir, String date); //

}

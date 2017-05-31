package com.photo.album.photoAlbum.runner;

import com.photo.album.photoAlbum.model.PhotoAlbum;
import com.photo.album.photoAlbum.service.PhotoAlbumServiceIfc;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by arvindpazare on 5/27/17.
 */

@Component
public class ApplicationStarter implements ApplicationStarterIfc {

    public static final String ENTER_ALBUM_ID_MESSAGE = "Please enter the photo-album id to see albums. Q to quit";
    public static final String INVALID_ID = "Invalid id : %s";
    public static final String QUIT = "q";
    public static final String INPUT_CONSOLE = "\n>";
    public static final String NO_DATA_FOUND_FOR_ALBUM_ID_S = "No data found for album id : %s";

    @Autowired
    private PhotoAlbumServiceIfc photoAlbumServiceIfc;

    @Autowired
    private PhotoAlbumConsole photoAlbumConsole;

    @Autowired
    private ExitApplication exitApplication;

    @Override
    public void start() {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.printf(ENTER_ALBUM_ID_MESSAGE);
        printWriter.format(INPUT_CONSOLE);
        startAlbumApp(printWriter);
    }

    public void startAlbumApp(PrintWriter printWriter) {
        do {
            String albumId = photoAlbumConsole.readFromConsole();
            if (isValidAlbumId(albumId)) {
                displayPhotoAlbum(albumId, printWriter);
            } else if (QUIT.equalsIgnoreCase(albumId)) {
                exitApplication.exit(0);
            } else {
                printWriter.printf(INVALID_ID, albumId + "\n");
            }
        } while (photoAlbumConsole.isSystemConsolePresent());
    }

    private boolean isValidAlbumId(String albumId) {
        return StringUtils.isNotBlank(albumId) && StringUtils.isNumeric(albumId);
    }

    private void displayPhotoAlbum(String albumId, PrintWriter printWriter) {
        List<PhotoAlbum> photoAlbums = photoAlbumServiceIfc.getPhotoAlbumById(Long.valueOf(albumId));
        if (photoAlbums.size() > 0) {
            photoAlbums.stream().forEach(e -> printWriter.format("[" + e.getId() + "]" + " " + e.getTitle() + "\n"));
            printWriter.print(">");
        } else {
            printWriter.printf(NO_DATA_FOUND_FOR_ALBUM_ID_S, albumId + "\n>");
        }
    }

}

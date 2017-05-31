package com.photo.album.photoAlbum.runner;

import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.logging.Logger;

/**
 * Created by arvindpazare on 5/30/17.
 */

@Component
public class PhotoAlbumConsole {

    public static final String CONSOLE_NOT_AVAILABLE = "Console not available";
    private static Logger logger = Logger.getLogger(PhotoAlbumConsole.class.getName());

    public String readFromConsole() {
        String str = null;
        try {
            Console con = System.console();
            str = con.readLine();
        } catch (Exception ex) {
            logger.finest(CONSOLE_NOT_AVAILABLE);
        }
        return str;
    }

    public boolean isSystemConsolePresent() {
        Console console = System.console();
        if (console == null) {
            return false;
        }
        return true;
    }
}

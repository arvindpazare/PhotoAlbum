package com.photo.album.photoAlbum.runner;

import org.springframework.stereotype.Component;

/**
 * Created by arvindpazare on 5/30/17.
 */

@Component
public class ExitApplication {

    public void exit(int status) {
        System.exit(status);
    }
}

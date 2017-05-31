package com.photo.album.photoAlbum;

import com.photo.album.photoAlbum.runner.ApplicationStarterIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

@SpringBootApplication(exclude = {EmbeddedServletContainerAutoConfiguration.class, WebMvcAutoConfiguration.class})
public class PhotoAlbumApplication implements CommandLineRunner {

    @Autowired
    private ApplicationStarterIfc applicationStarterIfc;

    public static void main(String[] args) {
        SpringApplication.run(PhotoAlbumApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        applicationStarterIfc.start();
    }
}

package com.photo.album.photoAlbum.config;

import com.photo.album.photoAlbum.runner.ApplicationStarter;
import com.photo.album.photoAlbum.runner.ExitApplication;
import com.photo.album.photoAlbum.runner.PhotoAlbumConsole;
import com.photo.album.photoAlbum.service.PhotoAlbumService;
import com.photo.album.photoAlbum.service.PhotoAlbumServiceIfc;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by arvindpazare on 5/30/17.
 */

@Profile("test")
@Configuration
public class PhotoAlbumTestConfiguration {

    @Bean
    @Primary
    public PhotoAlbumService photoAlbumService() {
        return Mockito.mock(PhotoAlbumService.class);
    }

    @Bean
    @Primary
    public ApplicationStarter applicationStarter() {
        return Mockito.mock(ApplicationStarter.class);
    }

    @Bean
    @Primary
    public PhotoAlbumServiceIfc photoAlbumServiceIfc() {
        return Mockito.mock(PhotoAlbumService.class);
    }

    @Bean
    @Primary
    public PhotoAlbumConsole photoAlbumConsole() {
        return Mockito.mock(PhotoAlbumConsole.class);
    }

    @Bean
    @Primary
    public ExitApplication exitApplication() {
        return Mockito.mock(ExitApplication.class);
    }

}

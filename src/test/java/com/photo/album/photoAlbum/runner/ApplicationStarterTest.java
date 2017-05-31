package com.photo.album.photoAlbum.runner;

import com.photo.album.photoAlbum.model.PhotoAlbum;
import com.photo.album.photoAlbum.service.PhotoAlbumService;
import com.photo.album.photoAlbum.service.PhotoAlbumServiceIfc;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationStarter.class, PhotoAlbumService.class,
        PhotoAlbumConsole.class, ExitApplication.class})
public class ApplicationStarterTest extends TestCase {

    @InjectMocks
    ApplicationStarter applicationStarter;

    @Mock
    private PhotoAlbumServiceIfc photoAlbumServiceIfc;

    @Mock
    private PhotoAlbumConsole photoAlbumConsole;

    @Mock
    private ExitApplication exitApplication;

    @Test
    public void testShouldReturnDataFromRestService() throws Exception {
        when(photoAlbumConsole.isSystemConsolePresent()).thenReturn(false);
        when(photoAlbumConsole.readFromConsole()).thenReturn("2");
        applicationStarter.start();
        Mockito.verify(photoAlbumServiceIfc, atLeastOnce()).getPhotoAlbumById(anyLong());
    }

    @Test
    public void testShouldExitApplicationOnQInput() throws Exception {
        when(photoAlbumConsole.isSystemConsolePresent()).thenReturn(false);
        when(photoAlbumConsole.readFromConsole()).thenReturn("Q");
        applicationStarter.start();
        Mockito.verify(exitApplication, atLeastOnce()).exit(0);
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        when(photoAlbumServiceIfc.getPhotoAlbumById(anyLong())).thenReturn(new ArrayList<PhotoAlbum>());
    }

}
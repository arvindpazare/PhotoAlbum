package com.photo.album.photoAlbum.service;

import com.photo.album.photoAlbum.model.PhotoAlbum;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PhotoAlbumService.class)
public class PhotoAlbumServiceTest extends TestCase {

    @InjectMocks
    @Spy
    private PhotoAlbumService photoAlbumService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void testThatServiceReturnsDataByPhotoAlbumId() throws Exception {
        when(restTemplate.getForObject(Mockito.anyString(), anyObject())).thenReturn(getPhotoAlbum());
        List<PhotoAlbum> albums = photoAlbumService.getPhotoAlbumById(1L);
        assertEquals("TestAlbum1", albums.get(0).getTitle());
    }

    public PhotoAlbum[] getPhotoAlbum() {
        PhotoAlbum[] photoAlbums = new PhotoAlbum[1];
        PhotoAlbum photoAlbum = new PhotoAlbum();
        photoAlbum.setAlbumId(1L);
        photoAlbum.setTitle("TestAlbum1");
        photoAlbums[0] = photoAlbum;
        return photoAlbums;
    }

}
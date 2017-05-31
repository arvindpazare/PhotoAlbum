package com.photo.album.photoAlbum.service;

import com.photo.album.photoAlbum.model.PhotoAlbum;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by arvindpazare on 5/26/17.
 */

@Service
public class PhotoAlbumService implements PhotoAlbumServiceIfc {

    public static final String ALBUM_SERVICE_URL = "https://jsonplaceholder.typicode.com/photos?albumId=";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<PhotoAlbum> getPhotoAlbumById(Long id) {
        PhotoAlbum [] photoAlbum = restTemplate.getForObject(ALBUM_SERVICE_URL + id, PhotoAlbum[].class);
        return Arrays.asList(photoAlbum);
    }

}

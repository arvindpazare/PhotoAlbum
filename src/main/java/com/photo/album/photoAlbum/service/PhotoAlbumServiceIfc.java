package com.photo.album.photoAlbum.service;

import com.photo.album.photoAlbum.model.PhotoAlbum;
import java.util.List;

/**
 * Created by arvindpazare on 5/25/17.
 */
public interface PhotoAlbumServiceIfc {
    public List<PhotoAlbum> getPhotoAlbumById(Long id);
}

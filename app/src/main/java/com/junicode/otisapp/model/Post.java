package com.junicode.otisapp.model;

import java.io.Serializable;

public class Post implements Serializable {
    private String photoPath;
    private String comentario;

    public Post(String photoPath, String comentario) {
        this.photoPath = photoPath;
        this.comentario = comentario;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

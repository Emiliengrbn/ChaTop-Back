package com.openclassrooms.DTO;

import org.springframework.web.multipart.MultipartFile;

public class RentalMultipartFileDTO extends RentalDTO{

    private MultipartFile picture;

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }


}

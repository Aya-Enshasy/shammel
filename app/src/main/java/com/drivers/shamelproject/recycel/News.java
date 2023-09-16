package com.drivers.shamelproject.recycel;

public class News {
    String title,body,image;


    public News(String title, String body, String image) {
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public News(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

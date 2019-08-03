package model;

import java.time.LocalDate;

public class BlogPost {
    private String writer;
    private String title;
    private LocalDate date;
    private String text;
    private String photoUrl;
    private int nrOfComments;
    private String url;

    public BlogPost(String writer, String title, LocalDate date, String text, String photoUrl) {
        this.writer = writer;
        this.title = title;
        this.date = date;
        this.text = text;
        this.photoUrl = photoUrl;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public int getNrOfComments() {
        return nrOfComments;
    }

    public String getUrl() {
        return url;
    }
}

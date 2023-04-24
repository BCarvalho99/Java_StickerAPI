package br.com.vlad.langapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topLanguages")
public class Lang {
    @Id
    private String id;
    private String title;
    private String image;
    private int rank;
    
    public Lang(){};

    public Lang(String title, String image, int rank) {
        this.title = title;
        this.image = image;
        this.rank = rank;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRank() {
        return rank;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
     this.id = id;
    }
    
}

package week13.exercises;

/**
 * This class is a DTO(Data Transfer Object)
 * DTOs do not have logic. They have only fields and getter setters
 * This class is an example of Encapsulation
* */
public class News {

    private String title;
    private String author;
    private String link;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

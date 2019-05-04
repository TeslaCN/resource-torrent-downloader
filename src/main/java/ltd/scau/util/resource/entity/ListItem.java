package ltd.scau.util.resource.entity;

import java.util.List;

/**
 * @author Weijie Wu
 */
public class ListItem {

    private String urn;

    private Long id;

    private String category;

    private List<String> tags;

    private String title;

    private ThreadType threadType;

    @Override
    public String toString() {
        return "ListItem{" +
                "urn='" + urn + '\'' +
                ", id=" + id +
                ", category='" + category + '\'' +
                ", tags=" + tags +
                ", title='" + title + '\'' +
                ", threadType=" + threadType +
                '}';
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ThreadType getThreadType() {
        return threadType;
    }

    public void setThreadType(ThreadType threadType) {
        this.threadType = threadType;
    }
}

package ltd.scau.util.resource.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Weijie Wu
 */
@Entity
public class Attachment {

    @Id
    private Long id;

    private String name;

    private String uri;

    private String price;

    private String size;

    private String date;

    private String download;

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", date='" + date + '\'' +
                ", download='" + download + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

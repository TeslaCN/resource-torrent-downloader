package ltd.scau.util.resource.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Weijie Wu
 */
@Entity
public class FileData {

    @Id
    private String uri;

    private String name;

    private byte[] bytes;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}

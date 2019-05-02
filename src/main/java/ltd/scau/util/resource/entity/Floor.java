package ltd.scau.util.resource.entity;

import java.util.List;

/**
 * @author Weijie Wu
 */
public class Floor {

    private String content;

    private List<Attachment> attachments;

    @Override
    public String toString() {
        return "Floor{" +
                "content='" + content + '\'' +
                ", attachments=" + attachments +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}

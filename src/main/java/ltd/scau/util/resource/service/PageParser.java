package ltd.scau.util.resource.service;

import ltd.scau.util.resource.entity.Floor;
import ltd.scau.util.resource.entity.ListItem;

import java.util.List;

/**
 * @author Weijie Wu
 */
public interface PageParser {

    /**
     * @param html
     * @return
     */
    List<ListItem> parseList(String html);

    /**
     * @param html
     */
    List<Floor> parsePost(String html);
}

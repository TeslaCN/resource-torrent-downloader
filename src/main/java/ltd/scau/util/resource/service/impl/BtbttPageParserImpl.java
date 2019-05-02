package ltd.scau.util.resource.service.impl;

import ltd.scau.util.resource.entity.Attachment;
import ltd.scau.util.resource.entity.Floor;
import ltd.scau.util.resource.entity.ListItem;
import ltd.scau.util.resource.service.PageParser;
import ltd.scau.util.resource.service.UriFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Weijie Wu
 */
@Service
public class BtbttPageParserImpl implements PageParser {

    @Override
    public List<ListItem> parseList(String html) {
        return Jsoup.parse(html)
                .getElementsByClass("subject")
                .stream()
                .filter(e -> e.childNodeSize() > 1)
                .map(e -> {
                    ListItem item = new ListItem();

                    String category = e.getElementsByTag("a").get(1).text();
                    category = category.substring(1, category.length() - 1);
                    item.setCategory(category);

                    List<String> tags = e.getElementsByClass("subject_type").stream()
                            .map(Element::text)
                            .map(s -> s.substring(1, s.length() - 1))
                            .collect(Collectors.toList());
                    item.setTags(tags);

                    Element subjectLink = e.getElementsByClass("subject_link").first();
                    String title = subjectLink.text();
                    item.setTitle(title);
                    String urn = subjectLink.attr("href");
                    item.setUrn(urn);

                    return item;
                })
                .collect(Collectors.toList());
    }

    @Autowired
    private UriFormat uriFormat;

    @Override
    public List<Floor> parsePost(String html) {
        return Jsoup.parse(html)
                .getElementsByClass("post_td")
                .stream()
                .filter(e -> !e.getElementsByClass("attachlist").isEmpty())
                .map(e -> {
                    Floor floor = new Floor();
                    floor.setContent(e.getElementsByClass("message").text());
                    Element attachList = e.getElementsByClass("attachlist").first();
                    List<Attachment> attachments = attachList.getElementsByTag("tr").stream()
                            .filter(r -> !r.getElementsByTag("a").isEmpty())
                            .map(r -> {
                                Attachment attachment = new Attachment();

                                attachment.setUri(
                                        uriFormat.format(
                                                r.getElementsByTag("a")
                                                        .first()
                                                        .attr("href")
                                                        .replaceFirst("dialog", "download")));

                                Elements tds = r.getElementsByTag("td");
                                attachment.setName(tds.get(0).text());
                                attachment.setPrice(tds.get(1).text());
                                attachment.setSize(tds.get(2).text());
                                attachment.setDownload(tds.get(3).text());
                                attachment.setDate(tds.get(4).text());

                                return attachment;
                            }).collect(Collectors.toList());
                    floor.setAttachments(attachments);
                    return floor;
                })
                .collect(Collectors.toList());
    }
}

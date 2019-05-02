package ltd.scau.util.resource.service.impl;

import ltd.scau.util.resource.service.UriFormat;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Weijie Wu
 */
@Service
public class BtbttUriFormatImpl implements UriFormat {

    @Override
    public String baseUri() {
        return "http://www.btbtt.co/";
    }

    @Override
    public String format(String urn) {
        return baseUri() + Optional.ofNullable(urn).orElse("");
    }
}

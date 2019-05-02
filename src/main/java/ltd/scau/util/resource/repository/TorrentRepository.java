package ltd.scau.util.resource.repository;

import ltd.scau.util.resource.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Weijie Wu
 */
public interface TorrentRepository extends JpaRepository<Attachment, Long> {
}

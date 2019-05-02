package ltd.scau.util.resource.repository;

import ltd.scau.util.resource.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Weijie Wu
 */
public interface FileDataRepository extends JpaRepository<FileData, String> {
}

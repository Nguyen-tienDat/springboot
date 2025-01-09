package demo.com.springboot_fw10.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "images")
public class Image {
    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    String path;
    Long productId;
    Integer isThumbnail = 0;

}

package demo.com.springboot_fw10.models;

import lombok.Data;

@Data
public class Post {
    int id;
    String title;
    String content;
    int viewCount;
}

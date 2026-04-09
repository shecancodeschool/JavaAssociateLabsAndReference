package com.umaxcode.blog_post.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "postImages")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "imageSequence",
            sequenceName = "imageSequence",
            allocationSize = 1
    )
    private Long id;

    private String imageName;

    private String imageType;

    @Lob
    private byte[] imageData;
}

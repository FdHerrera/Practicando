package com.herrera.practicando.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_report_id")
    private Long id;

    private String title;
    private String subTitle;
    private String footer;
    private String paragraph;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "video_report_id", referencedColumnName = "video_report_id")
    private Video video;

}

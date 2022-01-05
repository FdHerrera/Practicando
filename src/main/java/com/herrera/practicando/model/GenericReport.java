package com.herrera.practicando.model;

import com.herrera.practicando.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericReport {

    private String title;
    private String subTitle;
    private Integer priority;
    @Enumerated(EnumType.STRING)
    private Enum<Status> status;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @OneToOne
    private Stats stats;

}

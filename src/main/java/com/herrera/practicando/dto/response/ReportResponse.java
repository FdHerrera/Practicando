package com.herrera.practicando.dto.response;

import com.herrera.practicando.dto.request.PhotoRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class ReportResponse {
    private String title;
    private String subtitle;
    private String body;
    private Set<PhotoRequest> photos;
}

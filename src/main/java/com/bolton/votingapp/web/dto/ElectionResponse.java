package com.bolton.votingapp.web.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ElectionResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
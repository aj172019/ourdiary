package com.example.ourdiary.sentimentreport.entity;

import com.example.ourdiary.entry.entity.Entry;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sentiment_report")
public class SentimentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @Column(name = "sentiment_category", nullable = false, length = 50)
    private String sentimentCategory;

    @Column(name = "sentiment_score", nullable = false)
    private Integer sentimentScore;

}
package gis.Taxi;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "taxi")
@EntityListeners(AuditingEntityListener.class) // 엔티티 리스너 추가
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer baseFare;
    private Integer distanceFare;
    private Integer nightBaseFare;
    private Integer nightDistanceFare;

    private LocalTime nightStartTime;
    private LocalTime nightEndTime;
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Builder
    public Taxi(Long id, Integer baseFare, Integer distanceFare, Integer nightBaseFare, Integer nightDistanceFare,
            LocalTime nightStartTime, LocalTime nightEndTime, String description, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.baseFare = baseFare;
        this.distanceFare = distanceFare;
        this.nightBaseFare = nightBaseFare;
        this.nightDistanceFare = nightDistanceFare;
        this.nightStartTime = nightStartTime;
        this.nightEndTime = nightEndTime;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
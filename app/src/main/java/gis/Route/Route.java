package gis.Route;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import gis.Region.Region;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "route_tb")
@EntityListeners(AuditingEntityListener.class) // 엔티티 리스너 추가
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region originRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region destination;

    private String password;

    @Enumerated(EnumType.STRING)
    private TransportMode transportMode;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    public enum TransportMode {
        WALK, CAR
    }

    @Builder
    public Route(Long id, Region originRegion, Region destination, String password, TransportMode transportMode,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.originRegion = originRegion;
        this.destination = destination;
        this.password = password;
        this.transportMode = transportMode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
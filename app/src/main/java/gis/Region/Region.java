package gis.Region;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "region_tb")
@EntityListeners(AuditingEntityListener.class) // 엔티티 리스너 추가
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String regionName;
    private String latitude; // 위도
    private String longitude; // 경도

    @Enumerated(EnumType.STRING)
    private ReginType reginType;

    private String imgName;
    private String imgPath;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    public enum ReginType {
        METROPOLITAN, // 광역시
        PROVINCE, // 도
        CAPITAL_AREA // 수도권
    }

    @Builder
    public Region(Integer id, String regionName, String latitude, String longitude, ReginType reginType, String imgName,
            String imgPath, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.regionName = regionName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reginType = reginType;
        this.imgName = imgName;
        this.imgPath = imgPath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
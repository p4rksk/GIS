package gis.User;

import java.time.LocalDateTime;

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
@Table(name = "user_tb")
@EntityListeners(AuditingEntityListener.class) // 엔티티 리스너 추가
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private String imgName;
    private String imgPath;

    private LocalDateTime requestedAt;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = true)
    private LocalDateTime updatedAt;
    //

    // private String provider; kakao, apple, naver

    @Builder
    public User(Integer id, String username, String password, String nickName, String phone, String imgName,
            String imgPath, LocalDateTime requestedAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.phone = phone;
        this.imgName = imgName;
        this.imgPath = imgPath;
        this.requestedAt = requestedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
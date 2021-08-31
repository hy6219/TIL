package com.example.jpa_entity.domain;

import com.example.jpa_entity.domain.listener.Auditable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(value=AuditingEntityListener.class)
public class BaseEntity implements Auditable{
    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime cratedAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Override
    public LocalDateTime getCreatedAt() {
        return this.cratedAt;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.cratedAt=createdAt;
    }
}

package com.example.jpa_entity.domain.listener;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();

    public void setCreatedAt(LocalDateTime createdAt);
    public void setUpdatedAt(LocalDateTime updatedAt);


}

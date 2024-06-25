package com.Bankify.Cards.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class MetaDataEntity {

    @Column(updatable = false, insertable = true)
    private LocalDate createdAt;

    @Column(updatable = false, insertable = true)
    private String createdBy;

    @Column(updatable = true, insertable = false)
    private LocalDate updatedAt;

    @Column(updatable = true, insertable = false)
    private String updatedBy;
}

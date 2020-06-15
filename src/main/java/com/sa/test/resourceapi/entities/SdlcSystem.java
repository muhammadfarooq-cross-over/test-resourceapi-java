package com.sa.test.resourceapi.entities;

//import org.hibernate.validator.constraints.URL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sdlc_system")
@EntityListeners(AuditingEntityListener.class)
public class SdlcSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotEmpty
    //@URL
    @Column(name = "base_url", nullable = false)
    private String baseUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    private Instant createdDate;

    @Column(name = "last_modified_date", nullable = false)
    @LastModifiedDate
    private Instant lastModifiedDate;
}

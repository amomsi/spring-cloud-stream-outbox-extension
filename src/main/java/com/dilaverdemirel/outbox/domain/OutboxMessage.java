package com.dilaverdemirel.outbox.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dilaverdemirel
 * @since 10.05.2020
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OutboxMessage implements Serializable {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String sourceId;

    @Column(nullable = false)
    private String channel;

    @Lob
    @Column(nullable = false)
    private String payload;

    @Column(length = 6, nullable = false)
    @Enumerated(EnumType.STRING)
    private OutboxMessageStatus status;

    @Column(nullable = false)
    private String messageClass;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;

}

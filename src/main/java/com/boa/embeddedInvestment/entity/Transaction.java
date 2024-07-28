package com.boa.embeddedInvestment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String referenceId;

    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName = "id", nullable=false)
    private User user;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long amount;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}

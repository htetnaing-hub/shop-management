package com.glowmart.shop_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Represents a transaction log in the shopping system.
 * <p>
 * This entity stores details about transactions, including the associated order,
 * payment method, status, amount, and creation timestamp.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TransactionLog {

    /**
     * Unique identifier for the transaction log.
     * <p>
     * This field is automatically generated by the database.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionLogId;

    /**
     * The order associated with the transaction.
     * <p>
     * This field establishes a one-to-one relationship between the transaction log and an order.
     * </p>
     */
    @OneToOne
    @JoinColumn(name = "order_order_id")
    private Orders order;

    /**
     * The payment method used for the transaction.
     * <p>
     * This field establishes a many-to-one relationship with the {@link PaymentMethod} entity.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "payment_method_payment_method_id")
    private PaymentMethod paymentMethod;

    /**
     * The status of the transaction.
     * <p>
     * This value represents the current status of the transaction (e.g., pending, completed, failed).
     * </p>
     */
    @Column(nullable = false, updatable = true)
    private Long status;

    /**
     * Timestamp indicating when the transaction was created.
     * <p>
     * This field is automatically set when the transaction is logged and cannot be updated.
     * </p>
     */
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * The total amount involved in the transaction.
     * <p>
     * This value represents the monetary amount for the associated order.
     * </p>
     */
    @Column(nullable = false)
    private double amount;

}

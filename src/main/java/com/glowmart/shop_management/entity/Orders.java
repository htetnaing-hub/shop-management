package com.glowmart.shop_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Represents an order placed by a user in the shopping system.
 * <p>
 * This entity stores details about user orders, including the user who placed the order,
 * the payment method used, total price, status, and timestamps for creation and updates.
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Orders {

    /**
     * Unique identifier for the order.
     * <p>
     * This field is automatically generated by the database when a new order is created.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    /**
     * The user who placed the order.
     * <p>
     * This field establishes a relationship between the order and the user who created it.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    /**
     * The payment method used for the order.
     * <p>
     * This field links the order to a specific payment method chosen by the user.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    @JsonIgnore
    private PaymentMethod paymentMethod;

    /**
     * The total price of the order.
     * <p>
     * This field represents the total cost of all items in the order.
     * </p>
     */
    @Column(nullable = false)
    private double totalPrice;

    /**
     * The status of the order.
     * <p>
     * Possible values include "Pending", "Shipped", "Delivered", "Cancelled", etc.
     * </p>
     */
    @Column(nullable = false)
    private String status;

    /**
     * The total quantity of items in the order.
     * <p>
     * This field represents the total number of products included in the order.
     * </p>
     */
    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private int quantity;

    /**
     * Timestamp indicating when the order was created.
     * <p>
     * This field is automatically set when the order is created and cannot be updated.
     * </p>
     */
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * Timestamp indicating when the order was last updated.
     * <p>
     * This field is optional and is set when the order details are modified.
     * </p>
     */
    @Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime updatedAt;
}

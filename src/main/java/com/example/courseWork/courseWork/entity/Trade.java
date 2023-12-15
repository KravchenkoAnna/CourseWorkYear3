package com.example.courseWork.courseWork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trade", uniqueConstraints = { @UniqueConstraint(columnNames = {"suppliers_id", "detal_artikul", "purchase_date" }) })
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_seq")
    @SequenceGenerator(name = "trade_seq", sequenceName = "trade_sequence", initialValue = 15, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "suppliers_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "detal_artikul")
    private Detal detal;

    @Column(name = "detal_quantity")
    private int detalQuantity;

    @Column(name = "purchase_date")

    private LocalDate purchaseDate;

}

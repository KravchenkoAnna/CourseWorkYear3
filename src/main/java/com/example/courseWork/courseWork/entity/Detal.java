package com.example.courseWork.courseWork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "detal", uniqueConstraints = { @UniqueConstraint(columnNames = {"artikul", "price", "date_of_setting_price" }) })
public class Detal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detal_seq")
    @SequenceGenerator(name = "detal_seq", sequenceName = "detals_sequence", initialValue = 15, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "artikul")
    private int artikul;

    @Column(name = "price")
    private double price;

    @Column(name = "date_of_setting_price")
    private LocalDate dateOfSettingPrice;
}

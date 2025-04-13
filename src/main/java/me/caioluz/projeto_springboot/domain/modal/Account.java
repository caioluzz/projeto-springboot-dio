package me.caioluz.projeto_springboot.domain.modal;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private BigDecimal monthValue;
    private BigDecimal yearValue;

    @Column(name = "account_value", precision = 13, scale = 2)
    private BigDecimal value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public BigDecimal getMonth() {
        return monthValue;
    }

    public void setMonth(BigDecimal month) {
        this.monthValue = month;
    }

    public BigDecimal getYear() {
        return yearValue;
    }

    public void setYear(BigDecimal year) {
        this.yearValue = year;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    }


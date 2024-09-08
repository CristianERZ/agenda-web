package com.analistas.agenda.model.orm;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
@SQLRestriction("activo = true")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Se requiere el nombre")
    @Column(name = "nombre", length = 30)
    private String nombre;

    @NotNull(message = "Se requiere el apellido")
    @Column(name = "apellido", length = 30)
    private String apellido;

    @NotNull(message = "Se requiere el DNI")
    @Column(name = "dni", length = 30)
    private String dni;

    @Column(name = "activo", columnDefinition = "boolean default 1")
    private boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    public Cliente (){
        activo = true;
    }

}

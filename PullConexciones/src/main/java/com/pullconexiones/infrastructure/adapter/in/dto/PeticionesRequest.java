package com.pullconexiones.infrastructure.adapter.in.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeticionesRequest {

    private Long id;
    private String cliente;
    private String unidadOrganizativa;
    private String nombreDelGestor;
    private String solicitanteMercado;
    private String razonSocial;
    private String prioridad;
    private int posiciones;
    private String tipoDeContratacion;
    private String codigoDeProyecto;
    private String nombreDelProyecto;
    private String elementoParaContrataciones;
    private int mesesDeAsignacion;
    private String modalidad;
    private String lugarDefinitivo;
    private String tipoDeAsignacion;
    private String planDeCarrera;
    private String rolDeDesarrollo;
    private String evaluadorDePermormanceTalent;
    private double tasa;
    private double tasaTope;
    private String tipoDeProyecto;
    private BigDecimal margenPresupuesto;
    private BigDecimal margenAcomulado;
    private String planDeRecuperacion;
    private String comentariosGenerales;
    private String perfil;
    private String nivel;
    private String conocimientosTecnicos;
    private String conocimientosFuncionales;

}


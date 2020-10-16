package com.sisivelco.eituxtepec.entities;

public class Usuarios {
    private Integer idUsr;
    private String Usuario;
    private String Contraseña;
    private Integer idsuc;
    private String RFC;
    private Integer Tipo;

    public Usuarios(Integer idUsr, String usuario, String contraseña, Integer idsuc, String RFC, Integer tipo) {
        this.idUsr = idUsr;
        Usuario = usuario;
        Contraseña = contraseña;
        this.idsuc = idsuc;
        this.RFC = RFC;
        Tipo = tipo;
    }

    public Integer getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(Integer idUsr) {
        this.idUsr = idUsr;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public Integer getIdsuc() {
        return idsuc;
    }

    public void setIdsuc(Integer idsuc) {
        this.idsuc = idsuc;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public Integer getTipo() {
        return Tipo;
    }

    public void setTipo(Integer tipo) {
        Tipo = tipo;
    }
}


package com.example.ferre_ixtacZ.DTOs;


public class articulosDTO {


private Long id;
private String artnom; 
private double pre;
private Integer existencia;

public articulosDTO() {}

public articulosDTO(Long id, String artnom, double pre, Integer existencia) {
    this.id = id;
    this.artnom = artnom;
    this.pre = pre;
    this.existencia = existencia;


}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getArtnom() {
    return artnom;
}
public void setArtnom(String artnom) {
    this.artnom = artnom;
}
public double getPre() {
    return pre;
}
public void setPre(double pre) {
    this.pre = pre;
}
public Integer getExistencia() {
    return existencia;
}
public void setExistencia(Integer existencia) {
    this.existencia = existencia;
}
@Override
public String toString() {
    return "articulosDTO [id=" + id + ", artnom=" + artnom + ", pre=" + pre + ", existencia=" + existencia + "]";
}



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inser.persistence.restful_crud;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = Producto.SELECT_findAll),
    @NamedQuery(name = "Producto.findByCodigoProducto", query = Producto.SELECT_findByCodigoProducto)
})
public class Producto implements Serializable {
    public static final String SELECT_findAll = "SELECT p FROM Producto p";
    public static final String SELECT_findAll_order = SELECT_findAll + " ORDER BY p.";
    public static final String SELECT_findByCodigoProducto = "SELECT p FROM Producto p WHERE p.descripcion like :descripcion";
    public static final String SELECT_findByCodigoProducto_order = SELECT_findByCodigoProducto + " ORDER BY p.";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_producto")
    private String codigoProducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dimensiones")
    private String dimensiones;
    @Column(name = "proveedor")
    private String proveedor;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidad_en_stock")
    private short cantidadEnStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Column(name = "precio_proveedor")
    private BigDecimal precioProveedor;
    @JoinColumn(name = "gama", referencedColumnName = "gama")
    @ManyToOne(optional = false)
    private GamaProducto gama;

    public Producto() {
    }

    public Producto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto(String codigoProducto, String nombre, short cantidadEnStock, BigDecimal precioVenta) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(short cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(BigDecimal precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public GamaProducto getGama() {
        return gama;
    }

    public void setGama(GamaProducto gama) {
        this.gama = gama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inser.restful.restful_crud.Producto[ codigoProducto=" + codigoProducto + " ]";
    }
    
}

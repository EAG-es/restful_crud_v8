/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inser.persistence.restful_crud;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "gama_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GamaProducto.findAll", query = "SELECT g FROM GamaProducto g"),
    @NamedQuery(name = "GamaProducto.findByGama", query = "SELECT g FROM GamaProducto g WHERE g.gama = :gama"),
    @NamedQuery(name = "GamaProducto.findByImagen", query = "SELECT g FROM GamaProducto g WHERE g.imagen = :imagen")})
public class GamaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gama")
    private String gama;
    @Lob
    @Column(name = "descripcion_texto")
    private String descripcionTexto;
    @Lob
    @Column(name = "descripcion_html")
    private String descripcionHtml;
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gama")
    private Collection<Producto> productoCollection;

    public GamaProducto() {
    }

    public GamaProducto(String gama) {
        this.gama = gama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gama != null ? gama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamaProducto)) {
            return false;
        }
        GamaProducto other = (GamaProducto) object;
        if ((this.gama == null && other.gama != null) || (this.gama != null && !this.gama.equals(other.gama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inser.restful.restful_crud.GamaProducto[ gama=" + gama + " ]";
    }
    
}

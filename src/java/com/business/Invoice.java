package com.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByStt", query = "SELECT i FROM Invoice i WHERE i.stt = :stt"),
    @NamedQuery(name = "Invoice.findByProductName", query = "SELECT i FROM Invoice i WHERE i.productName = :productName"),
    @NamedQuery(name = "Invoice.findByTime", query = "SELECT i FROM Invoice i WHERE i.time = :time"),
    @NamedQuery(name = "Invoice.findByProductQuantity", query = "SELECT i FROM Invoice i WHERE i.productQuantity = :productQuantity")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stt")
    private Integer stt;
    @Column(name = "productName")
    private String productName;
    @Column(name = "time")
    private String time;
    @Column(name = "productQuantity")
    private String productQuantity;

    public Invoice() {
    }

    public Invoice(Integer stt) {
        this.stt = stt;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stt != null ? stt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.stt == null && other.stt != null) || (this.stt != null && !this.stt.equals(other.stt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.business.Invoice[ stt=" + stt + " ]";
    }
    
}

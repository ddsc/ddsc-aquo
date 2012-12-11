/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.nelen_schuurmans.aquo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author carsten.byrman@nelen-schuurmans.nl
 */
@Entity
@Table(name = "ddsc_core_compartment")
@NamedQueries({
    @NamedQuery(name = "Compartment.findByCode", query = "SELECT c FROM Compartment c WHERE c.code = :code"),
    @NamedQuery(name = "Compartment.mostRecent", query = "SELECT c FROM Compartment c ORDER BY c.beginDate DESC")
})
public class Compartment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(columnDefinition = "CHAR(12)", nullable = false, unique = true)
    private String code;
    @Column(columnDefinition = "CHAR(60)", nullable = false, unique = true)
    private String description;
    @Column(name = "\"group\"", columnDefinition = "CHAR(60)")
    private String group;
    @Column(name = "numeric_code", columnDefinition = "CHAR(12)")
    private String numericCode;
    @Column(name = "begin_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date beginDate;
    @Column(name = "end_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;

    public Compartment() {
        super();
    }

    @Override
    public String toString() {
        return "Compartment{"
                + "code=" + code
                + ", description=" + description
                + ", group=" + group
                + ", numericCode=" + numericCode
                + ", beginDate=" + beginDate
                + ", endDate=" + endDate
                + '}';
    }

    public void update(Compartment compartment) {
        this.code = compartment.code;
        this.description = compartment.description;
        this.group = compartment.group;
        this.numericCode = compartment.numericCode;
        this.beginDate = compartment.beginDate;
        this.endDate = compartment.endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

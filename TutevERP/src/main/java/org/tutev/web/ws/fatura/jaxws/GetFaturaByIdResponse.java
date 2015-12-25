
package org.tutev.web.ws.fatura.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getFaturaByIdResponse", namespace = "http://fatura.ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFaturaByIdResponse", namespace = "http://fatura.ws.web.tutev.org/")
public class GetFaturaByIdResponse {

    @XmlElement(name = "Fatura", namespace = "")
    private org.tutev.web.ws.fatura.WsFatura fatura;

    /**
     * 
     * @return
     *     returns WsFatura
     */
    public org.tutev.web.ws.fatura.WsFatura getFatura() {
        return this.fatura;
    }

    /**
     * 
     * @param fatura
     *     the value for the fatura property
     */
    public void setFatura(org.tutev.web.ws.fatura.WsFatura fatura) {
        this.fatura = fatura;
    }

}

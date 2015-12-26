
package org.tutev.web.ws.fatura.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getFaturaById", namespace = "http://fatura.ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFaturaById", namespace = "http://fatura.ws.web.tutev.org/")
public class GetFaturaById {

    @XmlElement(name = "FaturaId", namespace = "")
    private Long faturaId;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getFaturaId() {
        return this.faturaId;
    }

    /**
     * 
     * @param faturaId
     *     the value for the faturaId property
     */
    public void setFaturaId(Long faturaId) {
        this.faturaId = faturaId;
    }

}

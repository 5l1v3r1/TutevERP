
package org.tutev.web.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getKisisByAd", namespace = "http://ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKisisByAd", namespace = "http://ws.web.tutev.org/")
public class GetKisisByAd {

    @XmlElement(name = "PersonName", namespace = "")
    private String personName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPersonName() {
        return this.personName;
    }

    /**
     * 
     * @param personName
     *     the value for the personName property
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

}

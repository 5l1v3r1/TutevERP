
package org.tutev.web.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getKisisBySoyad", namespace = "http://ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKisisBySoyad", namespace = "http://ws.web.tutev.org/")
public class GetKisisBySoyad {

    @XmlElement(name = "PersonSurname", namespace = "")
    private String personSurname;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPersonSurname() {
        return this.personSurname;
    }

    /**
     * 
     * @param personSurname
     *     the value for the personSurname property
     */
    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

}

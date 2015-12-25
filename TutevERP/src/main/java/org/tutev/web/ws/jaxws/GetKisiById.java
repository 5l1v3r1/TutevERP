
package org.tutev.web.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPersonById", namespace = "http://ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonById", namespace = "http://ws.web.tutev.org/")
public class GetKisiById {

    @XmlElement(name = "PersonId", namespace = "")
    private Long personId;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getPersonId() {
        return this.personId;
    }

    /**
     * 
     * @param personId
     *     the value for the personId property
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

}


package org.tutev.web.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPersonByIdResponse", namespace = "http://ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonByIdResponse", namespace = "http://ws.web.tutev.org/")
public class GetKisiByIdResponse {

    @XmlElement(name = "Person", namespace = "")
    private org.tutev.web.ws.response.WsKisi person;

    /**
     * 
     * @return
     *     returns WsKisi
     */
    public org.tutev.web.ws.response.WsKisi getPerson() {
        return this.person;
    }

    /**
     * 
     * @param person
     *     the value for the person property
     */
    public void setPerson(org.tutev.web.ws.response.WsKisi person) {
        this.person = person;
    }

}

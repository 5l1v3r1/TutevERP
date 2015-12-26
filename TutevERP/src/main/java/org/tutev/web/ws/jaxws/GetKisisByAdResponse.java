
package org.tutev.web.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getKisisByAdResponse", namespace = "http://ws.web.tutev.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKisisByAdResponse", namespace = "http://ws.web.tutev.org/")
public class GetKisisByAdResponse {

    @XmlElement(name = "return", namespace = "")
    private List<org.tutev.web.ws.response.WsKisi> _return;

    /**
     * 
     * @return
     *     returns List<WsKisi>
     */
    public List<org.tutev.web.ws.response.WsKisi> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<org.tutev.web.ws.response.WsKisi> _return) {
        this._return = _return;
    }

}

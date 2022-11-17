package com.founder.rhip.cdm.service.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2017-05-12T13:39:46.950+08:00
 * Generated source version: 2.6.0
 * 
 */
@WebServiceClient(name = "ExamCountWebserviceService2", 
                  wsdlLocation = "examCountservice2.wsdl",
                  targetNamespace = "http://web.medexa.founder.com/") 
public class ExamCountWebserviceService2 extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://web.medexa.founder.com/", "ExamCountWebserviceService2");
    public final static QName ExamCountWebservice2Port = new QName("http://web.medexa.founder.com/", "ExamCountWebservice2Port");
    static {
        URL url = ExamCountWebserviceService2.class.getResource("examCountservice2.wsdl");
        if (url == null) {
            try {
                url = new URL("http://172.29.198.31:8090/meso/ws/examCountservice2");
            } catch (MalformedURLException e) {
                java.util.logging.Logger.getLogger(ExamCountWebserviceService2.class.getName())
                        .log(java.util.logging.Level.INFO,
                                "Can not initialize the default wsdl from {0}", "");
            }
        }
        WSDL_LOCATION = url;
    }

    public ExamCountWebserviceService2(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ExamCountWebserviceService2(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ExamCountWebserviceService2() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ExamCountWebserviceService2(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ExamCountWebserviceService2(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ExamCountWebserviceService2(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns IExamCountWebservice2
     */
    @WebEndpoint(name = "ExamCountWebservice2Port")
    public IExamCountWebservice2 getExamCountWebservice2Port() {
        return super.getPort(ExamCountWebservice2Port, IExamCountWebservice2.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IExamCountWebservice2
     */
    @WebEndpoint(name = "ExamCountWebservice2Port")
    public IExamCountWebservice2 getExamCountWebservice2Port(WebServiceFeature... features) {
        return super.getPort(ExamCountWebservice2Port, IExamCountWebservice2.class, features);
    }

}

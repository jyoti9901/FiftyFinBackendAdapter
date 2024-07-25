package com.tcl;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.apache.camel.support.jsse.TrustManagersParameters;
import org.springframework.stereotype.Component;

import java.net.http.HttpClient;

//Use this Class for local testing

@Component
public class SslConfigurer extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        //Uncomment this for local testing
        /*System.out.println("IN SSL CONFIGURER OVERIDDEN METHOD");
        this.configureSslForHttp4();*/
    }

    private void configureSslForHttp4() {
        System.out.println("==============Configured===============");
        KeyStoreParameters trust_ksp = new KeyStoreParameters();
        trust_ksp.setResource("SSL/truststore.jks");
        trust_ksp.setPassword("storepass");

        TrustManagersParameters trustp = new TrustManagersParameters();
        trustp.setKeyStore(trust_ksp);

        SSLContextParameters scp = new SSLContextParameters();
        scp.setTrustManagers(trustp);

        HttpComponent httpComponent = getContext().getComponent("https", HttpComponent.class);
        httpComponent.setSslContextParameters(scp);
        //    httpComponent.setProxyAuthHost("157.227.4.5");
        //   httpComponent.setProxyAuthPort(8080);
    }
}

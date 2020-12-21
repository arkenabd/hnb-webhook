package org.hanabank.util;

import org.apache.camel.CamelContext;
import org.apache.camel.component.http4.HttpComponent;
import org.apache.camel.util.jsse.KeyManagersParameters;
import org.apache.camel.util.jsse.KeyStoreParameters;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.apache.camel.util.jsse.TrustManagersParameters;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

public class SSLRegistryDynamic {

	public SSLRegistryDynamic setSsl(String appJks, String jksPass, CamelContext camelContext) {
		System.out.println("appJKS :" + appJks);
		System.out.println("jksPass :" + jksPass);
//		System.out.println("camelContext :" + camelContext.getRoutes());
		KeyStoreParameters keyStoreParameters = new KeyStoreParameters();
		keyStoreParameters.setResource(appJks);
		 keyStoreParameters.setPassword(jksPass);

		KeyManagersParameters keyManagersParameters = new KeyManagersParameters();
		keyManagersParameters.setKeyStore(keyStoreParameters);
		keyManagersParameters.setKeyPassword(jksPass);

		TrustManagersParameters trustManagersParameters = new TrustManagersParameters();
		trustManagersParameters.setKeyStore(keyStoreParameters);

		SSLContextParameters sslContextParameters = new SSLContextParameters();
		sslContextParameters.setKeyManagers(keyManagersParameters);
		sslContextParameters.setTrustManagers(trustManagersParameters);

		HttpComponent httpComponent = camelContext.getComponent("https4", HttpComponent.class);
		httpComponent.setSslContextParameters(sslContextParameters);
		// This is important to make your cert skip CN/Hostname checks
		httpComponent.setX509HostnameVerifier(new AllowAllHostnameVerifier());
		return SSLRegistryDynamic.this;
	}
}

package org.pprls.client;

import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.representation.EntitlementResponse;

public class AuthClient {

    public AuthClient()
    {
        // create a new instance based on the configuration defined in keycloak-authz.json
        AuthzClient authzClient = AuthzClient.create();

        String eat = getEntitlementAPIToken(authzClient);

        EntitlementResponse response = authzClient.entitlement(eat).getAll("hello-world-authz-service");
        String rpt = response.getRpt();
    }
    private static String getEntitlementAPIToken(AuthzClient authzClient) {
        return authzClient.obtainAccessToken("alice", "alice").getToken();
    }
}

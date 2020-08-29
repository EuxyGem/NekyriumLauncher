package fr.euxygem.nekyrium.launcher.security.authentication.request;

/**
 * @author EuxyGem
 **/

public class RefreshRequest
{
    private final String accessToken;
    private final String clientToken;

    public RefreshRequest(String accessToken, String clientToken)
    {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getClientToken()
    {
        return clientToken;
    }
}

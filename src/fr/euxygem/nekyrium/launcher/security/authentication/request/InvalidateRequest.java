package fr.euxygem.nekyrium.launcher.security.authentication.request;

/**
 * @author EuxyGem
 **/

public class InvalidateRequest
{
    private final String accessToken;
    private final String clientToken;

    public InvalidateRequest(String accessToken, String clientToken)
    {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    public String getAccessToken()
    {
        return this.accessToken;
    }

    public String getClientToken()
    {
        return this.clientToken;
    }
}

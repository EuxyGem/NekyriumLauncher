package fr.euxygem.nekyrium.launcher.security.authentication.request;

/**
 * @author EuxyGem
 **/

public class ValidateRequest
{
    private final String accessToken;

    public ValidateRequest(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken()
    {
        return this.accessToken;
    }
}

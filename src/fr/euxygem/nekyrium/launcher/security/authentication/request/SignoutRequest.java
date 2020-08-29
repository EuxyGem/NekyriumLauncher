package fr.euxygem.nekyrium.launcher.security.authentication.request;

/**
 * @author EuxyGem
 **/

public class SignoutRequest
{
    private final String username;
    private final String password;

    public SignoutRequest(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }
}

package fr.euxygem.nekyrium.launcher.security.authentication.request;

import java.util.HashMap;

/**
 * @author EuxyGem
 **/

public class AuthenticationRequest
{
    private final HashMap<String, Object> agent;
    private final String username;
    private final String password;

    public AuthenticationRequest(HashMap<String, Object> agent, String username, String password)
    {
        this.agent = agent;
        this.username = username;
        this.password = password;
    }

    public HashMap<String, Object> getAgent()
    {
        return agent;
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

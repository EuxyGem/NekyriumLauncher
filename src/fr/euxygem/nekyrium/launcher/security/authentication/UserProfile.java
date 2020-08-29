package fr.euxygem.nekyrium.launcher.security.authentication;

/**
 * @author EuxyGem
 **/

public class UserProfile
{
    private final String name;
    private final String id;

    public UserProfile()
    {
        this.name = "";
        this.id = "";
    }

    public UserProfile(String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getId()
    {
        return this.id;
    }
}

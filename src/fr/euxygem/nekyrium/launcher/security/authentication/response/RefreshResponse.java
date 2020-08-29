package fr.euxygem.nekyrium.launcher.security.authentication.response;

import fr.euxygem.nekyrium.launcher.security.authentication.UserProfile;

/**
 * @author EuxyGem
 **/

public class RefreshResponse
{
    private final String accessToken;
    private final String clientToken;
    private final UserProfile selectedProfile;

    public RefreshResponse(String accessToken, String clientToken, UserProfile selectedProfile)
    {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
        this.selectedProfile = selectedProfile;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getClientToken()
    {
        return clientToken;
    }

    public UserProfile getSelectedProfile()
    {
        return selectedProfile;
    }
}

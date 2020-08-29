package fr.euxygem.nekyrium.launcher.security.authentication.response;

import fr.euxygem.nekyrium.launcher.security.authentication.UserProfile;

/**
 * @author EuxyGem
 **/

public class AuthenticationResponse
{
    private final String accessToken;
    private final String clientToken;
    private final UserProfile[] availableProfiles;
    private final UserProfile selectedProfile;

    public AuthenticationResponse(String accessToken, String clientToken, UserProfile[] availableProfiles, UserProfile selectedProfile)
    {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
        this.availableProfiles = availableProfiles;
        this.selectedProfile = selectedProfile;
    }

    public String getAccessToken()
    {
        return this.accessToken;
    }

    public String getClientToken()
    {
        return this.clientToken;
    }

    public UserProfile[] getAvailableProfiles()
    {
        return this.availableProfiles;
    }

    public UserProfile getSelectedProfile()
    {
        return this.selectedProfile;
    }
}

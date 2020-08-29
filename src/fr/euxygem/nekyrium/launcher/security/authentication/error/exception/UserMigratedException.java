package fr.euxygem.nekyrium.launcher.security.authentication.error.exception;

import fr.euxygem.nekyrium.launcher.security.authentication.error.model.AuthenticationErrorModel;

/**
 * @author EuxyGem
 **/

public class UserMigratedException extends Exception
{
    private final AuthenticationErrorModel model;

    public UserMigratedException(AuthenticationErrorModel model)
    {
        super(model.getErrorMessage());
        this.model = model;
    }

    public AuthenticationErrorModel getErrorModel()
    {
        return model;
    }
}

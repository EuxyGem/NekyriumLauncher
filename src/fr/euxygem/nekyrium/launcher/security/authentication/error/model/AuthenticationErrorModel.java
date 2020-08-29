package fr.euxygem.nekyrium.launcher.security.authentication.error.model;

/**
 * @author EuxyGem
 **/

public class AuthenticationErrorModel
{
    private final String error;
    private final String errorMessage;
    private final String cause;

    public AuthenticationErrorModel(String error, String errorMessage, String cause)
    {
        this.error = error;
        this.errorMessage = errorMessage;
        this.cause = cause;
    }

    public String getError()
    {
        return error;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public String getCause()
    {
        return cause;
    }
}

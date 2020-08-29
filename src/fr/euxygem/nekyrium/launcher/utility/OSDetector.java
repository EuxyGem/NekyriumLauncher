package fr.euxygem.nekyrium.launcher.utility;

/**
 * @author EuxyGem
 **/

public enum OSDetector
{
    LINUX("linux", new String[]{"linux", "unix"}),
    MACOS("osx", new String[]{"mac"}),
    WINDOWS("windows", new String[]{"win"}),
    UNKNOWN("unknown", new String[0]);

    private final String name;
    private final String[] aliases;

    OSDetector(String name, String[] aliases)
    {
        this.name = name;
        this.aliases = aliases == null ? new String[0] : aliases;
    }

    public static OSDetector getCurrentOS()
    {
        String osName = System.getProperty("os.name").toLowerCase();

        for (OSDetector osDetector : values())
        {
            for (String alias : osDetector.aliases)
            {
                if (osName.contains(alias))
                {
                    return osDetector;
                }
            }
        }

        return OSDetector.UNKNOWN;
    }

    public String getName()
    {
        return name;
    }

    public String[] getAliases()
    {
        return aliases;
    }
}

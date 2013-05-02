package org.cru.dss.give.functional;

import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.google.common.base.Throwables;

public enum Environment
{
    LOCAL("http", "localhost", 8080, "test", "test"),
    TEST("http", "hart-a321.net.ccci.org", 8680, "test", "stage"),
    STAGE1("http", "hart-a331.net.ccci.org", 8680, "stage", "stage"),
    STAGE2("http", "hart-a332.net.ccci.org", 8680, "stage", "stage"),
    STAGING("https", "wsapistaging.ccci.org", 443, "stage", "stage"),
    PROD1("http", "hart-a341.net.ccci.org", 8680, "prod", "prod"),
    PROD2("http", "hart-a342.net.ccci.org", 8680, "prod", "prod"),
    PRODUCTION("https", "wsapi.ccci.org", 443, "prod", "prod");
    
    private static final String DATABASES_PROPERTIES_FILENAME = "databases.properties.xml";
    public final String host;
    public final int port;
    public final String context = "/dss-middleware";
//    private final String siebelDatabase;
//    private DataSource siebelDataSource;
//    private DataSource hcmDataSource;
//    private final String hcmDatabase;
    private final String scheme;
    
    private Environment(String scheme, String host, int port, String siebelDatabase, String hcmDatabase)
    {
        this.scheme = scheme;
        this.host = host;
        this.port = port;
//        this.hcmDatabase = hcmDatabase;
//        this.siebelDatabase = siebelDatabase;
    }
    
//    public DataSource getSiebelDataSource()
//    {
//        if (siebelDataSource == null)
//        {
//            siebelDataSource = buildDataSource("siebel" + "." + siebelDatabase );
//        }
//        return siebelDataSource;
//    }
//
//
//    public DataSource getHcmDataSource()
//    {
//        if (hcmDataSource == null)
//        {
//            hcmDataSource = buildDataSource("hcm"+ "." + hcmDatabase );
//        }
//        return hcmDataSource;
//    }
    
//    private DataSource buildDataSource(String prefix)
//    {
//        Properties properties = getProperties();
//        String url = getRequiredProperty(properties, prefix + ".url", DATABASES_PROPERTIES_FILENAME);
//        String username = getRequiredProperty(properties, prefix + ".username", DATABASES_PROPERTIES_FILENAME);
//        String password = getRequiredProperty(properties, prefix + ".password", DATABASES_PROPERTIES_FILENAME);
//        
//        try
//        {
//            OracleDataSource dataSource = new OracleDataSource();
//            dataSource.setURL(url);
//            dataSource.setUser(username);
//            dataSource.setPassword(password);
//            return dataSource;
//        }
//        catch (SQLException e)
//        {
//            throw Throwables.propagate(e);
//        }
//    }
    
    
    private Properties getProperties()
    {
        Properties properties = new Properties();
        InputStream propertiesStream = getClass().getClassLoader().getResourceAsStream(DATABASES_PROPERTIES_FILENAME);
        try
        {
            properties.loadFromXML(propertiesStream);
        }
        catch (InvalidPropertiesFormatException e)
        {
            throw Throwables.propagate(e);
        }
        catch (IOException e)
        {
            throw Throwables.propagate(e);
        }
        finally
        {
            try
            {
                propertiesStream.close();
            }
            catch (IOException e)
            {
                throw Throwables.propagate(e);
            }
        }
        return properties;
    }

    
    private String getRequiredProperty(Properties properties, String name, String propertiesFileName)
    {
        String property = properties.getProperty(name);
        if (property == null)
            throw new IllegalStateException(String.format(
                "properties file %s does not have property %s",
                propertiesFileName,
                name
            ));
        return property;
    }

    public String getUrlAndContext()
    {
        return scheme + "://" + host + ":" + port + context;
    }
//
//	public String getSiebelDatabase()
//	{
//		return siebelDatabase;
//	}


}

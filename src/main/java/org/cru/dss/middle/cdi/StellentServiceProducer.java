package org.cru.dss.middle.cdi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.xml.ws.BindingProvider;

import com.stellent.dev.docinfo.DocInfoSoap;
import com.stellent.dev.getfile.GetFileSoap;
import com.stellent.dev.metadata.MetaDataSoap;
import com.stellent.dev.search.SearchSoap;

@ApplicationScoped
public class StellentServiceProducer
{
    private static final int socketReadTimeout = (int) TimeUnit.MINUTES.toMillis(5);
    
    @Produces public DocInfoSoap createDocInfoClient() throws Exception
    {
        return (DocInfoSoap)createStellentService("DocInfo");
    }
    
    @Produces public SearchSoap createSearchClient() throws Exception
    {
        return (SearchSoap)createStellentService("Search");
    }
    
    @Produces public GetFileSoap createGetFileClient() throws Exception
    {
        return (GetFileSoap)createStellentService("GetFile");
    }
    
    @Produces public MetaDataSoap createMetaDataClient() throws Exception
    {
        return (MetaDataSoap)createStellentService("MetaData");
    }
    
    private Object createStellentService(String serviceNameStr) throws Exception
    {
        Class<?> locatorClass = Class.forName("com.stellent.dev."+serviceNameStr.toLowerCase()+"."+serviceNameStr+"");
        Constructor<?> c = locatorClass.getConstructor();
        Object locator = c.newInstance();
        Method m = locator.getClass().getMethod("get" + serviceNameStr + "Soap");
        Object unwrappedClient = m.invoke(locator);
        
        BindingProvider bindingProvider = (BindingProvider) unwrappedClient;
        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", socketReadTimeout);

        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "rtcarlson");
        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "idc");
        return bindingProvider;
    }   
}

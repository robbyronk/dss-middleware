package org.cru.give.webservices;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

import javax.inject.Inject;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Path("/")
@Provider
@ServerInterceptor
public class CorsInterceptor implements MessageBodyWriterInterceptor {
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    private static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
    private static final String ORIGIN = "http://localhost:8000";

    @Inject
    Logger logger;

    @Override
    public void write(MessageBodyWriterContext messageBodyWriterContext) throws IOException, WebApplicationException {
        messageBodyWriterContext.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, ORIGIN);
        messageBodyWriterContext.proceed();
    }

    @OPTIONS
    @Path("/{path:.*}")
    public Response handleCORSRequest(
            @HeaderParam(ACCESS_CONTROL_REQUEST_METHOD) final String requestMethod,
            @HeaderParam(ACCESS_CONTROL_REQUEST_HEADERS) final String requestHeaders) {
        final Response.ResponseBuilder retValue = Response.ok();

        if (requestHeaders != null)
            retValue.header(ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);

        if (requestMethod != null)
            retValue.header(ACCESS_CONTROL_ALLOW_METHODS, requestMethod);

        retValue.header(ACCESS_CONTROL_ALLOW_ORIGIN, ORIGIN);

        return retValue.build();
    }
}

package com.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class HeaderAdditionContainerResponseFilter implements ContainerResponseFilter {

    //    curl http://localhost:8081/hello -v
    // Only valid for JAX-RS
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("X-Header", "Header added by container response filter");
    }
}

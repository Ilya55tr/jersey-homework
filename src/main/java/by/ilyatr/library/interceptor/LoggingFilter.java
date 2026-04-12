package by.ilyatr.library.interceptor;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    System.out.println("LOG: ");
    System.out.println("Method: " + requestContext.getMethod());
    System.out.println("URI: " + requestContext.getUriInfo().getRequestUri());
    System.out.println("Headers: " + requestContext.getHeaders());
    System.out.println("---");
  }
}

package by.ilyatr.library.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    System.out.println("LOG: ");
    System.out.println("Method: " + requestContext.getMethod());
    System.out.println("URI: " + requestContext.getUriInfo().getRequestUri());
    System.out.println("Headers: " + requestContext.getHeaders());

    InputStream is = requestContext.getEntityStream();
    byte[] bodyBytes = is.readAllBytes();
    String body = new String(bodyBytes, StandardCharsets.UTF_8);
    System.out.println("Body: " + body);
    System.out.println("---");

    requestContext.setEntityStream(
        new ByteArrayInputStream(bodyBytes)
    );
  }

}

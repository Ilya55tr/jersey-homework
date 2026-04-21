package by.ilyatr.library.resource;

import by.ilyatr.library.dto.BookDto;
import by.ilyatr.library.service.LibraryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibraryResource {

  private final LibraryService service = new LibraryService();

  @GET
  public Response getAll() {
    return Response.ok(service.getAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") UUID id) {
    BookDto book = service.getById(id);
    if (book == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(book).build();
  }

  @POST
  public Response create(BookDto book) {
    BookDto created = service.create(book);
    return Response.status(Response.Status.CREATED).entity(created).build();
  }
}

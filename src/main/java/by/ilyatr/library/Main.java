package by.ilyatr.library;


import by.ilyatr.library.interceptor.LoggingFilter;
import by.ilyatr.library.resource.LibraryResource;
import org.eclipse.jetty.ee11.servlet.ServletContextHandler;
import org.eclipse.jetty.ee11.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler( "/library");
		ResourceConfig config = new ResourceConfig();
		config.register(LibraryResource.class);
		config.register(LoggingFilter.class);
		ServletContainer servlet = new ServletContainer(config);
		ServletHolder holder = new ServletHolder(servlet);
		context.addServlet(holder, "/*");
		server.setHandler(context);

		try {
			server.start();
			server.join();
		}finally {
			server.destroy();
		}
	}

}

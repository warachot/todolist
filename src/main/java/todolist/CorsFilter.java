package main.java.todolist;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String origin = request.getHeader("Origin");
	        if (origin != null)
	        {
	            String o = response.getHeader("Access-Control-Allow-Origin");
	            if (o == null)
	            {
	                response.addHeader("Access-Control-Allow-Origin", origin);
	            }
	            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	            String headers = request.getHeader("Access-Control-Request-Headers");
	            if (headers != null) response.setHeader("Access-Control-Allow-Headers", headers);
	            // Allow caching cross-domain permission
	            response.setHeader("Access-Control-Max-Age", "3600");
	        }
	        if (!"OPTIONS".equalsIgnoreCase(request.getMethod()))
	        {
	            filterChain.doFilter(request, response);
	        }

	}

}

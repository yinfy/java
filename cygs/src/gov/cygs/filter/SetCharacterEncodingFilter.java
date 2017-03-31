package gov.cygs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilter
 */
@WebFilter("/SetCharacterEncodingFilter")
public class SetCharacterEncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	protected boolean ignore = true;
    /**
     * Default constructor. 
     */
    public SetCharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.encoding = null;
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(this.ignore||(request.getCharacterEncoding()==null)){
			String encoding=selectEncoding(request);
			if (encoding != null)
			   request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);
	}
	
	protected String selectEncoding(ServletRequest request) {
		  return (this.encoding);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig= fConfig;
		this.encoding=filterConfig.getInitParameter("encoding");
		String value= filterConfig.getInitParameter("ignore");
		if(value==null){
			this.ignore=true;
		}else if(value.equalsIgnoreCase("true")){
			this.ignore=true;
		}else{
			this.ignore=false;
		}
	}

}

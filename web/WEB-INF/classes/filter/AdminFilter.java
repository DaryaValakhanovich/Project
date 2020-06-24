package filter;

import dao.UserDao;
import entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"addAdmin"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            if (userIsAdmin(servletRequest)) {
                allowAccess(servletRequest, servletResponse, filterChain);
            } else {
                sendBack(servletRequest, servletResponse);
            }
        } else {
            allowAccess(servletRequest, servletResponse, filterChain);
        }
    }

    private void sendBack(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        ((HttpServletResponse) servletResponse).sendRedirect("/menu");
    }

    private void allowAccess(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean userIsAdmin(ServletRequest httpRequest) {
        if (((HttpServletRequest) httpRequest).getSession().getAttribute("currentUser") != null) {
            String s = ((HttpServletRequest) httpRequest).getSession().getAttribute("currentUser").toString();
            if (UserDao.getInstance().findById(new Integer(s)).get().getRole().equals(Role.ADMIN)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
    }
}
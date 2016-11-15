package ua.com.vertex.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/test.jsp")
public class TestServlet extends HttpServlet {

    private static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("test", "My test " + i++);
        resp.getOutputStream().print("in servlet");
        resp.sendRedirect("./test.jsp");
    }
}

package edu.born.cool.web;

import edu.born.cool.model.Cool;
import edu.born.cool.repository.CoolRepository;
import edu.born.cool.repository.CoolRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CoolController extends HttpServlet {

    private final CoolRepository repository;

    public CoolController() {
        this.repository = new CoolRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        var action = request.getServletPath();

        switch (action) {
            case "/new" -> showCreateForm(request, response);
            case "/insert", "/update" -> save(request, response);
            case "/delete" -> delete(request, response);
            case "/edit" -> showEditForm(request, response);
            default -> list(request, response);
        }
    }

    private void list(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        var list = repository.getAll();

        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp")
                .forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("form.jsp")
                .forward(request, response);
    }

    private void showEditForm(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

        var id = Integer.parseInt(request.getParameter("id"));
        var cool = repository.getById(id);

        request.setAttribute("cool", cool);
        request.getRequestDispatcher("form.jsp")
                .forward(request, response);
    }

    private void save(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String sId = request.getParameter("id");
        Integer id = sId != null ? Integer.parseInt(sId) : null;
        var amount = Integer.parseInt(request.getParameter("amount"));

        var cool = new Cool(id, amount);
        repository.save(cool);

        response.sendRedirect("list");
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        var id = Integer.parseInt(request.getParameter("id"));
        repository.delete(id);

        response.sendRedirect("list");
    }
}
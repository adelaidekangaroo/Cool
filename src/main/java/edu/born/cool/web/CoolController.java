package edu.born.cool.web;

import edu.born.cool.model.Cool;
import edu.born.cool.repository.CoolRepository;
import edu.born.cool.repository.CoolRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static edu.born.cool.CoolUtil.isInvalidAmount;

public class CoolController extends HttpServlet {

    private CoolRepository repository;

    @Override
    public void init() {
        this.repository = new CoolRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        var action = request.getParameter("action");

        if (action == null) {
            getAll(request, response);
        } else {
            switch (action) {
                case "new" -> showCreateForm(request, response);
                case "delete" -> delete(request, response);
                case "edit" -> showEditForm(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        var action = request.getParameter("action");

        if (action == null) {
            getAll(request, response);
        } else {
            switch (action) {
                case "create" -> create(request, response);
                case "update" -> update(request, response);
            }
        }
    }

    private void getAll(HttpServletRequest request,
                        HttpServletResponse response) throws IOException, ServletException {

        var list = repository.getAll();

        request.setAttribute("list", list);
        request.getRequestDispatcher("pages/list.jsp")
                .forward(request, response);
    }

    private void create(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        var amount = Integer.parseInt(request.getParameter("amount"));

        checkAmount(amount);

        var cool = new Cool(amount);
        repository.create(cool);

        response.sendRedirect("cool");
    }

    private void update(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        var id = Integer.parseInt(request.getParameter("id"));
        var amount = Integer.parseInt(request.getParameter("amount"));

        checkAmount(amount);

        var cool = new Cool(id, amount);
        repository.update(cool);

        response.sendRedirect("cool");
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        var id = Integer.parseInt(request.getParameter("id"));
        repository.delete(id);

        response.sendRedirect("cool");
    }

    private void showCreateForm(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("pages/form.jsp")
                .forward(request, response);
    }

    private void showEditForm(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {

        var id = Integer.parseInt(request.getParameter("id"));
        var cool = repository.getById(id);

        request.setAttribute("cool", cool);
        request.getRequestDispatcher("pages/form.jsp")
                .forward(request, response);
    }

    private void checkAmount(int amount) throws ServletException {
        if (isInvalidAmount(amount)) {
            throw new ServletException(("Oh, " + amount + "% cool? his is too much"));
        }
    }
}
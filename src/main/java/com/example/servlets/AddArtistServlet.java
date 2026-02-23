package com.example.servlets;

import com.example.service.ArtistService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import com.example.context.ContextSingleton;
import java.io.IOException;

@WebServlet("/addArtist")
public class AddArtistServlet extends HttpServlet {

    private ArtistService artistService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.artistService = context.getBean(ArtistService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/addArtist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String nationality = req.getParameter("nationality");

        try {
            artistService.createArtist(name, nationality);
            resp.sendRedirect(req.getContextPath() + "/artists");
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/addArtist.jsp").forward(req, resp);
        }
    }

}

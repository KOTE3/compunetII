package com.example.servlets;

import java.io.IOException;

import com.example.service.ArtistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import com.example.context.ContextSingleton;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {

    private ArtistService artistService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.artistService = context.getBean(ArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("artists", artistService.findAll());
        req.getRequestDispatcher("/artists.jsp").forward(req, resp);
    }
}
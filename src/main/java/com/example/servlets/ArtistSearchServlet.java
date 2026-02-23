package com.example.servlets;

import java.io.IOException;

import org.springframework.context.ApplicationContext;

import com.example.context.ContextSingleton;
import com.example.model.Artist;
import com.example.service.ArtistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchArtist")
public class ArtistSearchServlet extends HttpServlet {

    private ArtistService artistService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.artistService = context.getBean(ArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("searchArtist.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        if (name == null || name.isBlank()) {
            request.setAttribute("error", "Debe ingresar un nombre");
            request.getRequestDispatcher("searchArtist.jsp")
                    .forward(request, response);
            return;
        }

        Artist artist = artistService.findByName(name.trim());

        if (artist == null) {
            request.setAttribute("error", "Artista no encontrado");
        } else {
            request.setAttribute("artist", artist);
        }

        request.getRequestDispatcher("searchArtist.jsp")
                .forward(request, response);
    }
}
package com.example.servlets;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.example.context.ContextSingleton;
import com.example.model.Artist;
import com.example.service.ArtistService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteArtist")
public class ArtistDeleteServlet extends HttpServlet {

    private ArtistService artistService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.artistService = context.getBean(ArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Artist> artists = artistService.findAll();
        request.setAttribute("artists", artists);
        request.getRequestDispatcher("deleteArtist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("artistId");

        try {
            Integer id = Integer.parseInt(idParam);
            artistService.delete(id);
            response.sendRedirect(request.getContextPath() + "/artists");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("deleteArtist.jsp").forward(request, response);
        }
    }
}
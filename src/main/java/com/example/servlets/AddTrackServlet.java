package com.example.servlets;

import com.example.context.ContextSingleton;
import com.example.model.Artist;
import com.example.service.ArtistService;
import com.example.service.TrackService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;

@WebServlet("/addTrack")
public class AddTrackServlet extends HttpServlet {

    /*
     * Gracias a lo anterior no hay necesidad en el doGet de :
     * public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
     * ServletException, IOException {
     * GameService gameService = context.getBean(GameService.class); esto
     * UserService userService = context.getBean(UserService.class); esto
     * }
     */

    private ArtistService artistService;
    private TrackService trackService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.trackService = context.getBean(TrackService.class);
        this.artistService = context.getBean(ArtistService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Artist> artists = artistService.findAll();
        req.setAttribute("artists", artists);
        req.getRequestDispatcher("/addTrack.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String durationStr = req.getParameter("duration");
        String album = req.getParameter("albumTitle");
        String[] artistIdsArray = req.getParameterValues("artistIds");

        try {
            trackService.addTrack(title, genre, durationStr, album, artistIdsArray);
            resp.sendRedirect(req.getContextPath() + "/tracks");
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }
}

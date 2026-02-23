package com.example.servlets;

import java.io.IOException;
import java.util.List;
import org.springframework.context.ApplicationContext;

import com.example.context.ContextSingleton;
import com.example.service.TrackService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.model.Track;

@WebServlet("/deleteTrack")
public class TrackDeleteServlet extends HttpServlet {

    private TrackService trackService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.trackService = context.getBean(TrackService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Track> tracks = trackService.getAllTracks();
        request.setAttribute("tracks", tracks);
        request.getRequestDispatcher("deleteTrack.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("trackId");

        try {
            trackService.deleteTrack(idParam);
            resp.sendRedirect(req.getContextPath() + "/tracks");
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/tracks");
        }
    }
}
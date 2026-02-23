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

@WebServlet("/tracks")
public class TrackListServlet extends HttpServlet {

    private TrackService trackService;

    @Override
    public void init() {
        ApplicationContext context = ContextSingleton.getInstance().getContext();
        this.trackService = context.getBean(TrackService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Track> tracks = trackService.getAllTracks();

        req.setAttribute("tracks", tracks);
        req.getRequestDispatcher("/tracks.jsp").forward(req, resp);
    }
}

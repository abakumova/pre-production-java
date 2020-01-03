package com.viktoriia_abakumova.task10.servlets;

import com.viktoriia_abakumova.task10.command.Command;
import com.viktoriia_abakumova.task10.command.CommandsHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "CalculatorServlet",
        urlPatterns = {"/CalculatorServlet"}
)
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        Command command = CommandsHandler.getCommand(request.getParameter("op"));
        command.setOut(out);
        command.execute(request.getParameter("txt1"), request.getParameter("txt2"));
    }
}

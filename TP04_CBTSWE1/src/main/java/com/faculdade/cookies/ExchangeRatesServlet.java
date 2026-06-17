// Dupla: Adriano Júnior de Souza Almeida e Arthur Lanzilotti Farjanes
package com.faculdade.cookies;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "exchangeRatesServlet",
        urlPatterns = {"/exchange-rate"},
        loadOnStartup = 1)
public class ExchangeRatesServlet extends HttpServlet {
    static final String currencyPairKey = "currencyPair";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Optional<Cookie> op = Arrays.stream(req.getCookies())
                                    .filter(c -> currencyPairKey.equals(c.getName()))
                                    .findAny();
        if (op.isPresent()) {
            showCurrencyRate(resp, op.get().getValue());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/currencySelection.html");
            rd.forward(req, resp);
        }
    }

    private static void showCurrencyRate(HttpServletResponse resp, String currencyPair)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        long rate = Math.round((Math.random() + 1) * 100);

        writer.write("<!DOCTYPE html>");
        writer.write("<html lang='pt-BR'><head>");
        writer.write("<meta charset='UTF-8'>");
        writer.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.write("<title>Cotação Atual</title>");
        writer.write("<link rel='stylesheet' href='style.css'>");
        writer.write("</head><body>");
        writer.write("<div class='card'>");
        writer.write("<h2>Cotação Atual</h2>");
        writer.write("<div class='rate-result'>");
        writer.write("<div class='pair'>" + currencyPair + "</div>");
        writer.write("<div class='value'>" + rate + "</div>");
        writer.write("</div>");
        writer.write("<a href='remove-currency-pair' class='btn btn-secondary'>Remover seleção</a>");
        writer.write("<br><a href='Creditos.html' class='credits-link'>Ver créditos da dupla</a>");
        writer.write("</div>");
        writer.write("</body></html>");
        writer.close();
    }
}
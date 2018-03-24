package ufjf.br.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet(name = "Mapa", urlPatterns = {"/mapa.html"})
public class Mapa extends HttpServlet {

    Map<String, String> paises;

    public Mapa() {
        paises = new HashMap<>();
        paises.put("Brasil", "Verde");
        paises.put("Argentina", "Azul");
        paises.put("Mexico", "Verde");
        paises.put("França", "Azul");
        paises.put("Suécia", "Amarelo");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet InicialServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<dl>");
        switch (request.getParameter("ordem")) {
            case "pais-cor":
                for (Map.Entry<String, String> pais : paises.entrySet()) {
                    out.println("<dt><h3>" + pais.getKey() + "</h3></dt>");
                    out.println("<dd><h4>" + pais.getValue() + "</h4></dd>");
                }
                break;
            case "cor-pais":
                // Map.Entry<String, ArrayList <String>> cores = new HashMap<>;
                for (Map.Entry<String, String> pais : paises.entrySet()) {
                    out.println("<dt><h3>" + pais.getKey() + "</h3></dt>");
                    out.println("<dd><h4>" + pais.getValue() + "</h4></dd>");
                }
                break;
        }
        out.println("</dl>");
        out.println("<a href = '?ordem=pais-cor'>País --> Cor </a></br>");
        out.println("<a href = '?ordem=cor-pais'>Cor --> Países </a>");
        out.println("</body>");
        out.println("</html>");
    }

}

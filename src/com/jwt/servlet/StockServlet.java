package com.jwt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connBD = null;
    Statement estSQL;
    ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Mi libreria</title>");        
        response.addHeader("Pragma","no-cache");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>Tenemos los siguientes libros:</h2>");
		  //Desplegar los datos del registro actual en el navegador
        out.println("<br> ");
        out.println("<table align='center' width='90%' border='1' cellpadding='0' cellspacing='0'>  ");
        out.println("<tr> ");
        out.println("<td> ");
        out.println("<table width='100%' align='center' border='0' cellpadding='0' cellspacing='0'> ");
        out.println(" <tr bgcolor='#CCFF66' >");
        //Columnas de la tabla de la BD
        out.println("<td align='left' > <b> Nombre </b> </td>  ");
        out.println("<td align='left' > <b> Autor </b> </td> ");
       
        out.println(" </tr>");
        
        try
        {
            conectarBD();
            rs = estSQL.executeQuery("SELECT * FROM LIBRERIA");
            while( rs.next() )    //Mientras haya una sig. tupla
            { 
            	out.println(" <td>"+ rs.getString("nombre")+"</td>");
                out.println(" <td>"+ rs.getString("autor")+"</td>");
                out.println(" </tr>");
                

            }
            
        }catch( SQLException sqlex ){
        	 System.out.println("ERROR: Excepcion al conectar en la página principal ");
        	 sqlex.printStackTrace();
        }
        
        
        
        out.println("</table>");
        out.println("</td> ");
        out.println("</tr> ");
        out.println("</table>");
        out.println("<br><br>");
        
        out.println("<form action='stock' method='post'>");
        out.println("<input type='submit' value='Volver a Home'/>");
        out.println("</form>");
        
        out.println("</body>");
        out.println("</html>");
		
	}
	
	public boolean conectarBD() throws SQLException
    {
        try
        {
      //seleccionar el driver
            Class.forName("com.mysql.jdbc.Driver");
      //especificar datos de conexion
            connBD = DriverManager.getConnection(
                    "jdbc:mysql://mysql:3306/lllc", "root", "root");
            estSQL = connBD.createStatement();
      //Verificar si se obtuvo la conexion correctamente
            if (connBD == null )
                return false;   //No se pudo conectar
            return true;
        }
        catch ( SQLException e )
        {
            System.out.println("ERROR: Excepcion al conectar la BD ");
            return false;
        }
        catch( Exception es )
        {
            System.out.println("ERROR: Excepcion al conectar la BD ");
            return false;
        }
        
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("home.jsp");
	}

}

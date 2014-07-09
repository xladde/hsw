<html>
    <head><title>Lagerverwaltung</title></head>
    <body>
    
    <%@page import="ArtikelVerwaltungInterface, Lagerartikel, javax.naming.*, javax.rmi.*, java.util.*" session="true"%>
    
    <%
        Integer an      = Integer.parseInt( request.getParameter("an") );
        String  ab      = request.getParameter("ab");
        Integer rn      = Integer.parseInt( request.getParameter("rn") );
        Integer fn      = Integer.parseInt( request.getParameter("fn") );
        Integer best    = Integer.parseInt( request.getParameter("best") );
        Integer minbest = Integer.parseInt( request.getParameter("minbest") );
        String  meh     = request.getParameter("meh");
    %>
    
    <%
    try {
        Context ctx = new InitialContext();
        Object ref  = ctx.lookup("ArtikelVerwaltungInterface");
        ArtikelVerwaltungInterface avi = (ArtikelVerwaltungInterface)ref;
        
        Lagerartikel l = new Lagerartikel();
        l.setArtikelnummer(an);
        //...
    
        avi.speichern(l);
        
    } catch(NamingException e) {
        e.printStackTrace();
    }
    %>
    Erfolgreich erstellt, oder auch nicht ....<br />
    <a href="WebClient.html">neuen Lagerartikel einf&uuml;gen</a>
    </body>
</html>
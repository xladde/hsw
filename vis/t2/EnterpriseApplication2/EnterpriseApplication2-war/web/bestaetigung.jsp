<%-- 
    Document   : bestaetigung
    Created on : 2014-05-05
    Author     : tj
--%>

<%@page
    import="pack1.ReisebueroRemote,pack1.Kunde,javax.naming.*,javax.rmi.PortableRemoteObject,java.util.*"
    session="true"
%>

<%
    String vn = request.getParameter("vorname");
    String nn = request.getParameter("nachname");
    String ad = request.getParameter("adresse");
    String kr = request.getParameter("kreditkartennummer");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Java Server Page</h1>
        <h2>Best&auml;tigung</h2>
        <%
            try {
                Context jndiContext = new InitialContext();
                Object ref = jndiContext.lookup("pack1.ReisebueroRemote");
                ReisebueroRemote hw = (ReisebueroRemote)ref;
                Kunde kunde_1 = new Kunde();
                kunde_1.setVorname(vn);
                kunde_1.setNachname(nn);
                kunde_1.setAdresse(ad);
                kunde_1.setKreditkartennummer(kr);
                hw.createKunde(kunde_1);
            } catch(javax.naming.NamingException ne) {
                ne.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        %>
    </body>
</html>

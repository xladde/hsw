<%@page import="StraftatenVerwaltungInterface, Straftat, javax.naming.*, javax.rmi.*, javax.util.*" session="true" %>
<%
    String v1 = request.getParameter("meldendePerson");
    String v2 = request.getParameter("sachverhalt");
    String v3 = request.getParameter("tatOrt");
    String v4 = request.getParameter("tatZeit");
    String v5 = request.getParameter("tatHergang");
    String v6 = request.getParameter("zeugen");
    String v7 = request.getParameter("geschaedigter");
    String v8 = request.getParameter("taeter");
%>
<html>
    <head><title>...</title></head>
    <body>
        <%
            try {
                Context ctx = new InitialContext();
                Object ref = ctx.lookup("StraftatenVerwaltungInterface");
                StraftatenVerwaltungInterface i = (StraftatenVerwaltungInterface)ref;

                Straftat s = new Straftat();
                s.setMeldendePerson(v1);
                s.setSachverhalt(v2);
                s.setTatOrt(v3);
                s.setTatZeit(v4);
                s.setTatHergang(v5);
                s.setZeugen(v6);
                s.setGeschaedigter(v7);
                s.setTaeter(v8);

                i.speichereStraftat(s);
            }
        %>
    </body>
</html>
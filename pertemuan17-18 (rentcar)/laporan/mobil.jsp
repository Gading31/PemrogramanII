<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>

<%
Connection conn = Koneksi.getConnection();

Statement st =
        conn.createStatement();

ResultSet rs =
        st.executeQuery(
                "SELECT * FROM mobil");
%>

<!DOCTYPE html>
<html>
<head>
<title>Laporan Mobil</title>
</head>
<body>

<h2 align="center">
LAPORAN DATA MOBIL
</h2>

<table border="1"
       width="100%"
       cellpadding="5">

<tr>
<th>ID</th>
<th>Plat Nomor</th>
<th>Merk</th>
<th>Tahun</th>
<th>Harga</th>
<th>Status</th>
</tr>

<%
while(rs.next()){
%>

<tr>
<td><%=rs.getInt("id_mobil")%></td>
<td><%=rs.getString("plat_nomor")%></td>
<td><%=rs.getString("merk")%></td>
<td><%=rs.getInt("tahun")%></td>
<td><%=rs.getDouble("harga")%></td>
<td><%=rs.getString("status")%></td>
</tr>

<%
}
%>

</table>

</body>
</html>
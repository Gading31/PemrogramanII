<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Connection conn =
        Koneksi.getConnection();

String sql =
        "SELECT p.*, "
        + "c.nama, "
        + "m.merk "
        + "FROM pengembalian p "
        + "JOIN sewa s "
        + "ON p.id_sewa=s.id_sewa "
        + "JOIN customer c "
        + "ON s.id_customer=c.id_customer "
        + "JOIN mobil m "
        + "ON s.id_mobil=m.id_mobil";

Statement st =
        conn.createStatement();

ResultSet rs =
        st.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Pengembalian</title>
</head>
<body>

<h2>Data Pengembalian</h2>

<a href="tambah.jsp">
    Tambah Pengembalian
</a>

<br><br>

<table border="1" cellpadding="10">

<tr>

<th>ID</th>
<th>Customer</th>
<th>Mobil</th>
<th>Tanggal Kembali</th>
<th>Denda</th>

</tr>

<%
while(rs.next()){
%>

<tr>

<td><%=rs.getInt("id_kembali")%></td>

<td><%=rs.getString("nama")%></td>

<td><%=rs.getString("merk")%></td>

<td><%=rs.getDate("tgl_kembali")%></td>

<td><%=rs.getDouble("denda")%></td>

</tr>

<%
}
%>

</table>

</body>
</html>
<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <title>Data Mobil</title>

    <style>

        table{
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td{
            border:1px solid black;
        }

        th, td{
            padding:10px;
        }

        a{
            text-decoration:none;
        }

    </style>

</head>
<body>

<h2>Data Mobil</h2>

<a href="tambah.jsp">
    Tambah Mobil
</a>

<br><br>

<table>

    <tr>
        <th>ID</th>
        <th>Plat Nomor</th>
        <th>Merk</th>
        <th>Tahun</th>
        <th>Harga</th>
        <th>Status</th>
        <th>Aksi</th>
    </tr>

<%

try{

    Connection conn =
            Koneksi.getConnection();

    Statement st =
            conn.createStatement();

    ResultSet rs =
            st.executeQuery(
                    "SELECT * FROM mobil");

    while(rs.next()){

%>

<tr>

    <td>
        <%=rs.getInt("id_mobil")%>
    </td>

    <td>
        <%=rs.getString("plat_nomor")%>
    </td>

    <td>
        <%=rs.getString("merk")%>
    </td>

    <td>
        <%=rs.getInt("tahun")%>
    </td>

    <td>
        <%=rs.getDouble("harga")%>
    </td>

    <td>
        <%=rs.getString("status")%>
    </td>

    <td>

<a href="edit.jsp?id=<%=rs.getInt("id_mobil")%>">

    Edit

</a>

|

<a href="../MobilServlet?action=hapus&id=<%=rs.getInt("id_mobil")%>">

    Hapus

</a>

</td>

</tr>

<%

    }

}catch(Exception e){

    out.println(e);

}

%>

</table>

</body>
</html>
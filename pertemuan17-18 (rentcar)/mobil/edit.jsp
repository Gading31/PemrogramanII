<%@page import="java.sql.*"%>
<%@page import="config.Koneksi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

int id =
        Integer.parseInt(
                request.getParameter("id"));

Connection conn =
        Koneksi.getConnection();

PreparedStatement ps =
        conn.prepareStatement(
        "SELECT * FROM mobil WHERE id_mobil=?");

ps.setInt(1, id);

ResultSet rs =
        ps.executeQuery();

rs.next();

%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Mobil</title>
</head>
<body>

<h2>Edit Data Mobil</h2>

<form action="../MobilServlet" method="post">

    <input type="hidden"
           name="id_mobil"
           value="<%=rs.getInt("id_mobil")%>">

    <table>

        <tr>
            <td>Plat Nomor</td>
            <td>
                <input type="text"
                       name="plat_nomor"
                       value="<%=rs.getString("plat_nomor")%>">
            </td>
        </tr>

        <tr>
            <td>Merk</td>
            <td>
                <input type="text"
                       name="merk"
                       value="<%=rs.getString("merk")%>">
            </td>
        </tr>

        <tr>
            <td>Tahun</td>
            <td>
                <input type="number"
                       name="tahun"
                       value="<%=rs.getInt("tahun")%>">
            </td>
        </tr>

        <tr>
            <td>Harga</td>
            <td>
                <input type="number"
                       name="harga"
                       value="<%=rs.getDouble("harga")%>">
            </td>
        </tr>

        <tr>
            <td>Status</td>
            <td>

                <select name="status">

                    <option value="Tersedia">
                        Tersedia
                    </option>

                    <option value="Disewa">
                        Disewa
                    </option>

                </select>

            </td>
        </tr>

        <tr>

            <td></td>

            <td>

                <button type="submit"
                        name="action"
                        value="update">

                    Update

                </button>

            </td>

        </tr>

    </table>

</form>

</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Tambah Customer</title>
</head>
<body>

<h2>Tambah Customer</h2>

<form action="../CustomerServlet" method="post">

    <table>

        <tr>
            <td>Nama</td>
            <td>
                <input type="text"
                       name="nama"
                       required>
            </td>
        </tr>

        <tr>
            <td>Alamat</td>
            <td>
                <textarea name="alamat"
                          required></textarea>
            </td>
        </tr>

        <tr>
            <td>Telepon</td>
            <td>
                <input type="text"
                       name="telepon"
                       required>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit">
                    Simpan
                </button>
            </td>
        </tr>

    </table>

</form>

<br>

<a href="data.jsp">
    Lihat Data Customer
</a>

</body>
</html>
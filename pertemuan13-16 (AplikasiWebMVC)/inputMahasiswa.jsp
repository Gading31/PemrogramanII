<%-- 
    Document   : inputMahasiswa
    Created on : May 31, 2026, 12:37:22 AM
    Author     : dingg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Master Mahasiswa</title>
</head>
<body>

    <h2>Form Master Mahasiswa</h2>

    <form action="MahasiswaController" method="post">

        <table>

            <tr>
                <td>NIM</td>
                <td>
                    <input type="text" name="nim" required>
                </td>
            </tr>

            <tr>
                <td>Nama</td>
                <td>
                    <input type="text" name="nama" required>
                </td>
            </tr>

            <tr>
                <td>Semester</td>
                <td>
                    <input type="number" name="semester" required>
                </td>
            </tr>

            <tr>
                <td>Kelas</td>
                <td>
                    <input type="text" name="kelas" required>
                </td>
            </tr>

            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" required>
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Simpan">
                </td>
            </tr>

        </table>

    </form>

</body>
</html>

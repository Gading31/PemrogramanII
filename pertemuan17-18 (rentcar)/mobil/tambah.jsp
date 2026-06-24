<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Tambah Mobil</title>
</head>
<body>

    <h2>Tambah Data Mobil</h2>

    <form action="../MobilServlet" method="post">

        <table>

            <tr>
                <td>Plat Nomor</td>
                <td>
                    <input type="text"
                           name="plat_nomor"
                           required>
                </td>
            </tr>

            <tr>
                <td>Merk</td>
                <td>
                    <input type="text"
                           name="merk"
                           required>
                </td>
            </tr>

            <tr>
                <td>Tahun</td>
                <td>
                    <input type="number"
                           name="tahun"
                           required>
                </td>
            </tr>

            <tr>
                <td>Harga Sewa</td>
                <td>
                    <input type="number"
                           name="harga"
                           required>
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
                    <button type="submit">
                        Simpan
                    </button>
                </td>

            </tr>

        </table>

    </form>

</body>
</html>
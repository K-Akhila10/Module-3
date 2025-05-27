import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(String dbUrl) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl);
    }

    public void insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    public void updateStudent(int id, String name) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
}
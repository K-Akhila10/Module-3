import java.sql.*;

public class TransactionExample {
    public static void transfer(Connection conn, int fromId, int toId, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false);
            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");

            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            credit.setDouble(1, amount);
            credit.setInt(2, toId);

            debit.executeUpdate();
            credit.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
    }
}
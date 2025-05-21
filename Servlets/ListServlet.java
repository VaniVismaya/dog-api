@WebServlet("/lists")
public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listName = request.getParameter("listName");
        String userId = request.getParameter("userId");

        // Inserting list into database by the below code
        try (Connection conn = DriverManager.getConnection("jdbc:mysql:                                              
            PreparedStatement stmt = conn.prepareStatement("//localhost:3306/http_dog_api", "root", "")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lists (user_id, list_name) VALUES (?, ?)");
            stmt.setString(1, userId);
            stmt.setString(2, listName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting list: " + e.getMessage());
        }

        response.sendRedirect("lists.jsp");
    }
}

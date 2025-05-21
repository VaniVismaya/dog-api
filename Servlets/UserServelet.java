@WebServlet("/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Insert user into database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql:                                              
            PreparedStatement stmt = conn.prepareStatement("//localhost:3306/http_dog_api", "root", "")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }

        response.sendRedirect("login.jsp");
    }
}

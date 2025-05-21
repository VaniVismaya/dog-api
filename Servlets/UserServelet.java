@WebServlet("/users")
public class UserServlet extends HttpServlet {
  private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
      return;
    }

    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

    try (Connection conn = DriverManager.getConnection("jdbc:mysql:                                              
      PreparedStatement stmt = conn.prepareStatement("//localhost:3306/http_dog_api", "root", "")) {
      PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
      stmt.setString(1, name);
      stmt.setString(2, email);
      stmt.setString(3, hashedPassword);
      stmt.executeUpdate();
    } catch (SQLException e) {
      logger.error("Error inserting user", e);
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error registering user");
      return;
    }

    response.sendRedirect("login.jsp?registered=true");
  }
}

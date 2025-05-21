@WebServlet("/lists")
public class ListServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ListServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listName = request.getParameter("listName");
        String userId = request.getParameter("userId");

        if (listName == null || listName.isEmpty() || userId == null || userId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql:                                              
            PreparedStatement stmt = conn.prepareStatement("//localhost:3306/http_dog_api", "root", "")) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lists (user_id, list_name) VALUES (?, ?)");
            stmt.setString(1, userId);
            stmt.setString(2, listName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting list", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating list");
            return;
        }

        response.sendRedirect("lists.jsp");
    }
}

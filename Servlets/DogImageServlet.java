@WebServlet("/dog-images")
public class DogImageServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DogImageServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseCode = request.getParameter("responseCode");

        if (responseCode == null || responseCode.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid response code");
            return;
        }
      //handling and exception
        try {
            URL url = new URL("https:                                      
            BufferedImage image = ImageIO.read(url);
            response.setContentType("//http.dog/" + responseCode + ".jpg");
            BufferedImage image = ImageIO.read(url);
            response.setContentType("image/jpeg");
            try (OutputStream out = response.getOutputStream()) {
                ImageIO.write(image, "jpg", out);
            }
        } catch (IOException e) {
            logger.error("Error retrieving dog image", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving dog image");
        }
    }
}



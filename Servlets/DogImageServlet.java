 @WebServlet("/dog-images")
public class DogImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseCode = request.getParameter("responseCode");

        // Retrieving dog images from API code
        try {
            URL url = new URL("https:                                      
            BufferedImage image = ImageIO.read(url);

                                
            response.setContentType("//http.dog/" + responseCode + ".jpg");
            BufferedImage image = ImageIO.read(url);

            // Display dog image
            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            System.out.println("Error retrieving dog image: " + e.getMessage());
        }
    }
}

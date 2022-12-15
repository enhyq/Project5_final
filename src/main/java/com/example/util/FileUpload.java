//package com.example.util;
//
//import com.example.board.BoardVO;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//
//public class FileUpload {
//    public BoardVO uploadPhoto(HttpServletRequest request) {
//        String filename = "";
//        int sizeLimit = 15 * 1024 * 1024;
//
//        String realPath = request.getServletContext().getRealPath("upload");
//
////        MultipartFile file = request.getParameter("image");
//
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists())
//                    dir.mkdirs();
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//                logger.info("Server File Location="
//                        + serverFile.getAbsolutePath());
//
//                return "You successfully uploaded file=" + name;
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
//        }
//
//        File dir = new File(realPath);
//        if (!dir.exists()) dir.mkdirs();
//
//        BoardVO one = null;
//        MultipartRequest multipartRequest = null;
//        try{
//            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
//            filename = multipartRequest.getFilesystemName("photo");
//
//            one = new MemberVO();
//            String sid = multipartRequest.getParameter("sid");
//            if(sid!=null && !sid.equals("")) one.setSid(Integer.parseInt(sid));
//            one.setUserid(multipartRequest.getParameter("userid"));
//            one.setUsername(multipartRequest.getParameter("username"));
//            one.setPassword(multipartRequest.getParameter("password"));
//            one.setEmail(multipartRequest.getParameter("email"));
//            one.setBlogurl(multipartRequest.getParameter("blogurl"));
//            one.setDetail(multipartRequest.getParameter("detail"));
//
//            if(sid != null && !sid.equals("")){
//                MemberDAO dao = new MemberDAO();
//                String oldfilename = dao.getPhotoFilename(Integer.parseInt(sid));
//                if(filename!=null && oldfilename!=null)
//                    FileUpload.deleteFile(request, oldfilename);
//                else if(filename==null && oldfilename!=null)
//                    filename = oldfilename;
//            }
//            one.setPhoto(filename);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return one;
//    }
//
//    public static void deleteFile(HttpServletRequest request, String filename){
//        String filePath = request.getServletContext().getRealPath("upload");
//
//        File f = new File(filePath+"/" + filename);
//        if(f.exists()) f.delete();
//    }
//}
